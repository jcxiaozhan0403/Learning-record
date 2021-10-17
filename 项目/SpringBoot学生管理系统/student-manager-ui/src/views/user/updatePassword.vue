<template>
  <el-form ref="form" :model="form" label-width="100px" style="width:30%;margin-top:20px" >
    <el-form-item label="旧密码">
      <el-input v-model="oldP" type="password"></el-input>
    </el-form-item>
    <el-form-item label="新密码">
      <el-input v-model="newP" type="password"></el-input>
    </el-form-item>
    <el-form-item label="新密码" >
      <el-input v-model="newP1" type="password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import {updateUserPassword} from '@/api/user'
  export default {
    data() {
      return {
          oldP: '',
          newP: '',
          newP1: '',
          form: null
      }
    },
    methods: {
      onSubmit() {
        var oldP = this.oldP;
        var newP = this.newP;
        var id = this.$store.getters.id
        if(null === oldP || "" === oldP || null === newP || "" === newP){
          this.$message({
                message: "请填写完整信息",
                type: 'error'
          });
        }else if(newP === oldP) {
          this.$message({
            message: "新密码不能与旧密码相同",
            type: 'error'
          });
        }else{
          //发送修改请求
          var data = {
            id: id,
            oldP: oldP,
            newP: newP
          }
          updateUserPassword(data).then(
            response => {
              if(response.code === 20000){
                this.$message({
                  message: response.message,
                  type: "success"
                })
                this.oldP = ""
                this.newP = ""
                this.newP1 = ""
                this.logout();
              }
            }
          )
        }
      },
      async logout() {
        await this.$store.dispatch('user/logout')
        this.$router.push(`/login?redirect=${this.$route.fullPath}`)
      }
    },
  }
</script>
