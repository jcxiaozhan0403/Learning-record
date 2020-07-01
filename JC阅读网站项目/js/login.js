window.onload = init;
var login,logup,userName,psd,spanInfo;
function init(){
    login = document.getElementById("login");
    logup = document.getElementById("logup");
    userName = document.getElementById("userName");
    psd = document.getElementById("psd");
    uspanInfo = document.getElementById("spanInfo");
    psd.onkeydown = keydown;
    logup.onclick = registered;
    login.onclick = logIn;
}

// 验证用户名
function logIn(){
    if(userName.value == "Admin" && psd.value == "123456"){
        window.location.replace("../index.html?flag=1");
    }else{
        uspanInfo.innerHTML = "邮箱名或密码错误";
    }
    return false;
}

// 页面跳转
function registered(){
    window.location.assign("../html/register.html");
    return false;
}

// 回车跳转
function keydown(){
    if(event.keyCode == 13){
        logIn();
    }
}