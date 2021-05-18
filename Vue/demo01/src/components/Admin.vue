<template>
    <div id="form">
        <p>登录</p>
        <el-row>
            <el-col :span="6"><span>用户名：</span></el-col>
            <el-col :span="16"><el-input v-model="username" placeholder="请输入账号"></el-input></el-col>
        </el-row>
        <el-row>
            <el-col :span="6"><span>密码：</span></el-col>
            <el-col :span="16"><el-input placeholder="请输入密码" v-model="password" show-password></el-input></el-col>
        </el-row>
        <el-row>
            <el-col :span="6" :offset="2"><el-button type="primary" round @click="judge">登录</el-button></el-col>
            <el-col :span="6" :offset="8"><el-button type="primary" round @click="reset">重置</el-button></el-col>
        </el-row>
    </div>
</template>

<script>
import { md5 } from '../../static/js/md5.js';
export default {
  name: 'Admin',
  data(){
      return{
          username: '',
          password: ''
      }
  },
  methods:{
    judge(){
        let pwd = md5(this.password);
       console.log(pwd);
    },

    reset(){
        this.username = '';
        this.password = '';
    }
  }
}
</script>
    
<style>
div#form{
    background-color: lightblue;
    width: 360px;
    height: 270px;
    margin: 250px auto;
    border-radius: 10px;
    text-align: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
}

.el-row{
    margin-top: 30px;
}

div#form>p{
    font-size: 25px;
}
</style>