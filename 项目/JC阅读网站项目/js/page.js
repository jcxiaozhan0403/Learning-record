window.onload = init;
var user,userStyle;
function init(){
    user = document.getElementById("user");
    userStyle = document.defaultView.getComputedStyle(headimg,null);
    user.onclick = login;
}

function login(){
    if(userStyle.display == "none"){
        window.location.assign("../html/login.html");
    }
}