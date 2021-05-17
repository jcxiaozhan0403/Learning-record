<template>
    <div class="login-container">
        <el-form :model="ruleForm2" :rules="rules2"
         status-icon
         ref="ruleForm2" 
         label-position="left" 
         label-width="0px" 
         class="demo-ruleForm login-page">
            <h3 class="title">登录</h3>
            <el-form-item prop="username">
                <el-input type="text" 
                    v-model="ruleForm2.username" 
                    auto-complete="off" 
                    placeholder="用户名"
                ></el-input>
            </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" 
                        v-model="ruleForm2.password" 
                        auto-complete="off" 
                        placeholder="密码"
                    ></el-input>
                </el-form-item>
            <el-checkbox 
                v-model="checked"
                class="rememberme"
            >记住密码</el-checkbox>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
require("../../static/js/md5.js");
export default {
    data(){
        return {
            logining: false,
            ruleForm2: {
                username: 'JohnCena',
                password: 'd5477920f46f1b30f259cff2b1e25c04',
            },
            rules2: {
                username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
                password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
            },
            checked: false
        }
    },
    methods: {
        handleSubmit(event){
            event.preventDefault();
            this.$refs.ruleForm2.validate((valid) => {
                if(valid){
                    this.logining = true;
                    let _this = this;
                    let password = hex_md5(_this.ruleForm2.password);
                    this.$http.post("http://localhost:8989/" + _this.ruleForm2.username).then((res,err)=>{
                        _this.logining = false;
                        console.log(password);
                        if (res.data.pwd == password) {
                            alert("登陆成功");
                        }else {
                            alert("密码错误");
                        }
                    }).catch(function(error){
                        _this.logining = false;
                        console.log(error);
                        alert("账号不存在");
                    });
                }else{
                    console.log('error submit!');
                    return false;
                }
            })
        }
    },
};
</script>

<style scoped>
h3.title {
    text-align: center;
}

.login-container {
    width: 100%;
    height: 100%;
}
.login-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
    margin: 0px 0px 15px;
    text-align: left;
}
</style>