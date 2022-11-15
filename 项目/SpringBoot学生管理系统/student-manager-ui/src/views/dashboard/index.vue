<template>
  <div class="dashboard-container">
    <!-- <div class="text">学生信息管理系统</div>
     -->
     <div id="container1" class="container"></div>
     <div id="container2" class="container"></div>
     <div id="container3" class="container"></div>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { listStudent } from '@/api/student';
import { listTeacher } from '@/api/teacher'
import { formatTime } from '@/utils';
import { listClazz } from '@/api/clazz'
// 引入基本模板
let echarts = require('echarts/lib/echarts')
// 引入柱状图组件
require('echarts/lib/chart/bar')
// 引入提示框和title组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')

export default {
  name: 'Dashboard',
  data() {
    return {
      // 第一张图数据
      boy: 0,
      girl: 0,
      studentList: [],
      // 第二张图数据
      teacherList: [],
      course: [],
      course2: {},
      course3: [],
      // 第三张表数据
      clazzList: [],
      clazz: [],
      clazz2: {},
      clazz3: []
    }
  },
  computed: {
    ...mapGetters([
    ])
  },
  methods: {
    myEcharts() {
      var dom1 = document.getElementById("container1");
      var dom2 = document.getElementById("container2");
      var dom3 = document.getElementById("container3");
      var myChart1 = echarts.init(dom1);
      var myChart2 = echarts.init(dom2);
      var myChart3 = echarts.init(dom3);
      var app = {};
      var option1,option2,option3,option4;
      option1 = {
        title: {
          text: '学生男女比例',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '学生男女比例',
            type: 'pie',
            radius: '50%',
            data: [
              { value: this.girl, name: '女' },
              { value: this.boy, name: '男' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      option2 = {
        title: {
          text: '专业教师分布比例',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '教师人数',
            type: 'pie',
            radius: '50%',
            data: this.course3,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      option3 = {
        title: {
          text: '班级分布比例',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: '班级分布比例',
            type: 'pie',
            radius: '50%',
            data: this.clazz3,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };

      if (option1 && typeof option1 === 'object') {
          myChart1.setOption(option1);
          myChart2.setOption(option2);
          myChart3.setOption(option3);
      }
    },
    getStudent() {
      listStudent().then(
        response=>{
          this.studentList = response.data.data;
          for(var i=0;i<this.studentList.length;i++) {
            if (this.studentList[i].sex == 1) {
              this.boy++;
            }else {
              this.girl++;
            }
          }
          this.myEcharts();
        }
      )
    },
    getTeacher() {
      listTeacher().then(
        response => {
          this.teacherList = response.data.data;
          // 填充课程数组
          for(var i=0;i<this.teacherList.length;i++) {
            this.course.push(this.teacherList[i].course);
          }

          // 遍历数组，
          this.course2 = this.course.reduce(function (allNames, name) { 
          if (name in allNames) {
            allNames[name]++;
          }
          else {
            allNames[name] = 1;
          }
          return allNames;
          }, {});

          for (var i in this.course2) {
            var obj = {value: this.course2[i],name: i}
            this.course3.push(obj);
          }
          this.myEcharts();
        }
      )
    },
    getClazz() {
      listClazz().then(
        response => {
          this.clazzList = response.data.data
          // 填充课程数组
          for(var i=0;i<this.clazzList.length;i++) {
            this.clazz.push(this.clazzList[i].grade);
          }

          // 遍历数组，
          this.clazz2 = this.clazz.reduce(function (allNames, name) { 
          if (name in allNames) {
            allNames[name]++;
          }
          else {
            allNames[name] = 1;
          }
          return allNames;
          }, {});

          for (var i in this.clazz2) {
            var obj = {value: this.clazz2[i],name: i}
            this.clazz3.push(obj);
          }
          this.myEcharts();
        }
      )
      
    }
  },
  mounted() {
    this.getStudent();
    this.getTeacher();
    this.getClazz();
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}

.container {
  height: 400px;
  width:700px;
  float: left;
  margin-top: 30px;
  margin-left:60px;
}
</style>
