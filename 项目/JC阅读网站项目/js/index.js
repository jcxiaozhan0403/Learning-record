window.onload = init;
var user,headimg,userStyle,leftBtn,imgs,title,dotBtn,path,flag,span;
var cnt = 0;
function init(){
    span = document.getElementById("span");
    path = document.getElementById("path");
    user = document.getElementById("user");
    headimg = document.getElementById("headimg");
    leftBtn = document.getElementById("left");
    imgs = document.getElementById("imgs");
    title = document.getElementById("title");
    dotBtns = document.getElementsByClassName("dotBtn");

    getParameter();

    for(var i = 0; i<3; i++){
        dotBtns[i].onclick = imgchg;
    }

    imgChange();
    user.onclick = login;
}

function login(){
    if(headimg.style.display == "none"){
        return false;
    }else{
        window.location.assign("html/login.html");
    }
}

// 获取登录参数
function getParameter(){
    flag = getUrlQueryString('flag');
    if(flag == 1){
        headimg.classList.add("img");
        span.classList.add("span");
    }else{
        headimg.classList.remove("img");
    }
}

function getUrlQueryString(names, urls) {
	urls = urls || window.location.href;
	urls && urls.indexOf("?") > -1 ? urls = urls
			.substring(urls.indexOf("?") + 1) : ""; //获取字符串
	var reg = new RegExp("(^|&)" + names + "=([^&]*)(&|$)", "i"); //不区分大小写
	var r = urls ? urls.match(reg) : window.location.search.substr(1)
			.match(reg);
	if (r != null && r[2] != "")
		return unescape(r[2]);
	return null;
};

// 幻灯片自动切换
function imgChange(){
    switch(cnt % 3){
        case 0 : imgs.src = "images/1.jpg";
        path.href = "html/article1.html"
        title.innerHTML = "计网笔记";
        break;
        case 1 : imgs.src = "images/2.jpg";
        path.href = "html/article2.html"
        title.innerHTML = "数据库笔记";
        break;
        case 2 : imgs.src = "images/3.jpg";
        path.href = "html/article3.html"
        title.innerHTML = "JavaScript笔记";
        break;
    }
    cnt++;
    window.setTimeout(imgChange,3000);
}

// 小圆点切换
function imgchg(){
    var obj = event.srcElement ? event.srcElement : event.target;
    if(obj == dotBtns[0]){
        imgs.src = "images/1.jpg";
        path.href = "html/article1.html"
        title.innerHTML = "计网笔记";
        cnt = 0;
    }else if(obj == dotBtns[1]){
        imgs.src = "images/2.jpg";
        path.href = "html/article2.html"
        title.innerHTML = "数据库笔记";
        cnt = 1;
    }else{
        imgs.src = "images/3.jpg";
        path.href = "html/article3.html"
        title.innerHTML = "JavaScript笔记";
        cnt = 2;
    }
}