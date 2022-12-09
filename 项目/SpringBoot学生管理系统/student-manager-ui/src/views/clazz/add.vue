<template>
  <el-form ref="form" :model="form" label-width="100px" style="width:30%;margin-top:20px" >
    <el-form-item label="年级">
      <el-input v-model="grade" oninput="value=value.replace(/[^\u4e00-\u9fa5]/g, '')" :maxlength="6" placeholder="最大长度6个中文字符" @blur="grade = $event.target.value"></el-input>
    </el-form-item>
    <el-form-item label="班级">
      <el-input v-model="clazz" :maxlength="6" placeholder="最大长度6个字符"></el-input>
    </el-form-item>
    <el-form-item label="班导师">
      <el-input v-model="headTeacher" oninput="value=value.replace(/[^\u4e00-\u9fa5]/g, '')" :maxlength="6" placeholder="最大长度6个中文字符" @blur="headTeacher = $event.target.value"></el-input>
    </el-form-item>
    <el-form-item label="限定总人数">
      <el-input v-model="totalStudent" onkeyup="this.value=this.value.replace(/^\.+|[^\d.]/g,'')" placeholder="请输入数字" :maxlength="3"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit">添加</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import {addClazz} from '@/api/clazz'
  export default {
    data() {
      return {
          grade: '',
          clazz: '',
          headTeacher: '',
          totalStudent: ''
      }
    },
    methods: {
      onSubmit() {
        var grade = this.grade;
        var clazz = this.clazz;
        var headTeacher = this.headTeacher;
        var totalStudent = this.totalStudent;

        if(null === grade || "" === grade
           || null === clazz || "" === clazz
           || null === headTeacher || "" === headTeacher
           || null === totalStudent || "" === totalStudent){
             this.$message({
                 message: "请填写完整的班级信息",
                 type: 'error'
               });
           }else{
             //发送新增请求
             var data = {
               grade: grade,
               clazz: clazz,
               headTeacher: headTeacher,
               totalStudent: totalStudent
             }
             addClazz(data).then(
               response => {
                 if(response.code === "3002"){
                   this.$message({
                     message: "班级已存在",
                     type: "error"
                   })
                 }
                 if(response.code === 20000){
                   this.$message({
                     message: response.message,
                     type: "success"
                   })
                   this.grade = ""
                   this.clazz = ""
                   this.headTeacher = ""
                   this.totalStudent = ""
                 }
               }
             )

           }
      }
    },
    // watch:{
    //   grade: {
    //     handler: function(newVal, oldVal){
    //       if(newVal != oldVal){
    //         this.classVisible = true
    //       }
    //     },
    //     deep: true
    //   }
    // }
  }
</script>
