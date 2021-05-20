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
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
// 引入md5加密插件
import md5 from 'js-md5';
export default {
    data(){
        return {
            logining: false,
            ruleForm2: {
                username: 'JohnCena',
                password: '123456',
            },
            rules2: {
                username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
                password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
            },
        }
    },
    methods: {
        handleSubmit(event){
            event.preventDefault();
            this.$refs.ruleForm2.validate((valid) => {
                if(valid){
                    // 修改登录按钮状态
                    this.logining = true;

                    // 保存当前this值
                    let _this = this;

                    // 将提交到后台的密码进行md5混淆加密处理
                    let pwd = md5("!@#" + _this.ruleForm2.password + "$%^");

                    this.$http.post("http://localhost:8989/" + _this.ruleForm2.username).then((res,err)=>{
                        _this.logining = false;
                        if (res.data.pwd == pwd) {
                            console.log("登陆成功");
                            _this.$router.push({
                                path: `/home`,
                            });
                        }else {
                            alert("密码错误");
                        }
                    }).catch(function(error){
                        // 异常处理
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
    position: absolute;
    left: 0px;
    top: 0px;
    width: 100%;
    height: 100%;
    background: url("https://img.jcxiaozhan.top/%E5%AF%BC%E8%88%AA%E9%A1%B5%E8%83%8C%E6%99%AF.jpg");
    background-size: 100%;
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