<template>
<el-container>
  <el-aside width="200px">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#343a40"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1">
        <i class="el-icon-search"></i>
        <span slot="title">信息查询</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-user"></i>
        <span slot="title">个人中心</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right;">
      <span id="title">学生信息管理系统</span>
      <span>你好，王小虎</span>
      <el-link type="primary" :underline="false" class="logout">注销</el-link>
    </el-header>
      <queryPage></queryPage>
  </el-container>
</el-container>
</template>

<script>
import queryPage from './QueryPage.vue';
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item),
                options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value: '',
        input: ''
      }
    },
    components: {queryPage}
  };
</script>

<style>
.el-header {
    background-color: #343a40;
    color: rgba(255,255,255,.5);
    line-height: 60px;
    position: relative;
    width: 100.95%;
    height: 60px;
    bottom: 9px;
    right: 10px;
}
  
.el-aside {
    background-color: #343a40;
    display: block;
    position: absolute;
    left: 0;
    top: 59px;
    bottom: 0;
}

.el-menu {
    border-right: none;
    color: #fff;
}

.el-main {
    position: absolute;
    left: 200px;
    right: 0;
    top: 60px;
    bottom: 0;
    overflow: hidden;
}

.el-main div.el-table {
  height: 100%;
  overflow-y: scroll;
}

#title {
  position: absolute;
  left: 40px;
}

div.search {
  margin-bottom: 10px;
}

.logout {
  position: relative;
  left: 5px;
}
</style>
