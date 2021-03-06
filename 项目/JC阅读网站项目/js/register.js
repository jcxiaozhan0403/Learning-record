window.onload = init;
// 定义正确值标志标量，如果正确，定义变量为1，并返回
var flaguserName,flagpsd,flagsecPsd,flagphNum,flagVerCode;
//用户名，密码，二次密码，手机号码，用户输入验证码，提交按钮，系统给定验证码
var userName,psd,secPsd,phNum,userVerCode,submit,sysVerCode,check;
//信息提示：用户名，密码，二次密码，验证码，电话号码
var infoUserName,infoPsd,infoSecPsd,infoVerCode,infoPhNum;
function init(){
    userName = document.getElementById("userName");
    psd = document.getElementById("psd");
    secPsd = document.getElementById("secPsd");
    phNum = document.getElementById("phNum");
    userVerCode = document.getElementById("userVerCode");
    btn = document.getElementById("btn");
    sysVerCode = document.getElementById("sysVerCode");
    check = document.getElementById("check");

    imgUserName = document.getElementById("imgUserName");
    imgPsd      = document.getElementById("imgPsd");
    imgSecPsd   = document.getElementById("imgSecPsd");
    imgPhNum    = document.getElementById("imgPhNum");
    imgVerCode  = document.getElementById("imgVerCode");

    infoUserName = document.getElementById("infoUserName");
    infoPsd = document.getElementById("infoPsd");
    infoSecPsd = document.getElementById("infoSecPsd");
    infoPhNum = document.getElementById("infoPhNum");
    infoVerCode = document.getElementById("infoVerCode");

    userName.onfocus = checkUserName;
    userName.onblur = checkUserName; 

    psd.onfocus = checkPsd;
    psd.onblur  = checkPsd;

    secPsd.onfocus = checkSecPsd;
    secPsd.onblur  = checkSecPsd;

    phNum.onfocus = checkPhNum;
    phNum.onblur  = checkPhNum;

    userVerCode.onfocus = showVerCode;
    sysVerCode.onclick  = showVerCode;

    userVerCode.onblur = checkVerCode;

    btn.onclick = checkAll;
}
//字典
var dictUserName = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890.-_";
var dictOrdinary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
var dictAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
var dictNum = "1234567890";
// 更改提示图标
function infoImg(spanId,imgId){
if(spanId.style.color == "red")
    {
        imgId.src = "../images/onError.gif";
    }else if(spanId.style.color == "blue")
    {
        imgId.src = "../images/onFocus.gif";
    }else if(spanId.style.color == "green")
    {
        imgId.src = "../images/right.jpg";
    }
}
// 更改提示颜色
function infoColor(spanId){
if(event.type == "focus")
    {
        spanId.style.color = "blue";    
    }else{
        spanId.style.color = "red";
    }
}

//正则判断字符串是否包含特殊字符，不包含返回true，包含返回false
// 正则判断密码是否由数字+字母构成，是返回true，不是返回false
// 正则判断电话号码前两位，以及是否为11位组成，满足返回true，不满足返回false
var regUserName = /^\w*[_\.*]*$/;
var regPsd = /^(?![^0-9]+$)(?![^a-zA-Z]+$)\w+$/;
var regNum =/^1[3|4|5|6|8|9][0-9]{9,}$/;

function strJudge(str,reg){
    return reg.test(str);
}

//判断一个字符串是否包含特殊字符
//str:需要判断的字符串  返回值：若包含，返回true,否则返回false
function hasIllegalChar(str,dict){
    for(var i = 0;i < str.length;i++)
    {
        if(dict.indexOf(str.charAt(i)) == -1)
        {
            return true;
        }
    }
    return false;
}
//用于验证用户名输入是否正确，若正确，则提示信息为绿色，若错误，则获取焦点提示蓝色，失去焦点提示红色
//1.长度为0 2.长度不在6-18之间 3.包含了特殊字符(字母、数字._-以外的字符) 4.数字打头  5.特殊字符打头（.-_）
function checkUserName(){
    var str = userName.value; 

    infoColor(infoUserName);

    if(str.length == 0)
    {
        infoUserName.innerHTML ="用户名不能为空";
                    
    }else   if(str.length < 6 || str.length > 18)
            {
                infoUserName.innerHTML ="用户名长度不在6~18之间";
            }else   if(isNaN(Number(str.charAt(0))) == false){
                        infoUserName.innerHTML ="不能以数字打头";
                    }else   if(str.charAt(0) == "_" || str.charAt(0) == "-" || str.charAt(0) == "."){
                                infoUserName.innerHTML ="不能以特殊字符打头";
                            }else   if(hasIllegalChar(str,dictUserName) == true)
                                    {
                                        infoUserName.innerHTML ="不能包含特殊字符";        
                                    }else{
                                        infoUserName.innerHTML ="恭喜您，可以注册！";
                                        infoUserName.style.color = "green";
                                        flaguserName = 1;
                                    }
    infoImg(infoUserName,imgUserName);
    return flaguserName;
}
//判断str是否只有字母+数字来构成，不能包含其他字符，也不能只有一种
//若是则返回true,否则返回false 
//设定标志变量：flagSpecial = 1 -> 包含了特殊字符  flagAlpha = 1 ->只包含字母  flagNum = 1 ->只包含数字
function isAlphaAndNum(str){
    var flagSpecial,flagAlpha,flagNum;
    
    if(hasIllegalChar(str,dictOrdinary) == true)
    {
        flagSpecial = 1;
        return false;
    }
    if(hasIllegalChar(str,dictAlpha) == false){
        flagAlpha = 1;
        return false;
    }
    if(hasIllegalChar(str,dictNum) == false){
        flagNum = 1;
        return false;
    }
    return true;
}

//用于验证密码输入是否正确，若正确，则提示信息为绿色，若错误，则获取焦点提示蓝色，失去焦点提示红色
//1.空  2。6-18  3.只有数字，只有字母，包含了非字母和数字
function checkPsd(){
    var str = psd.value;

    infoColor(infoPsd);

    if(str.length == 0)
    {
        infoPsd.innerHTML ="密码不能为空";
    }else   if(str.length < 6 || str.length > 18)
            {
                infoPsd.innerHTML ="密码长度不在6-18之间";
            }else   if(isAlphaAndNum(str) == false){
                        infoPsd.innerHTML ="请尝试字母+数字的组合";
                    }else{
                        infoPsd.innerHTML ="";
                        infoPsd.style.color = "green";
                        flagpsd = 1;
                    }
    infoImg(infoPsd,imgPsd);
    return flagpsd;
}
//用于验证二次密码输入是否正确，若正确，则提示信息为绿色，若错误，则获取焦点提示蓝色，失去焦点提示红色
//1.空  2。6-18  3.只有数字，只有字母，包含了非字母和数字 4.两次密码不相等
function checkSecPsd(){
    var str = secPsd.value;
    var str2 = psd.value;

    infoColor(infoSecPsd);

    if(str.length == 0)
    {
        infoSecPsd.innerHTML ="密码不能为空";
    }else   if(str.length < 6 || str.length > 18)
            {
                infoSecPsd.innerHTML ="密码长度不在6-18之间";
            }else   if(isAlphaAndNum(str) == false){
                    infoSecPsd.innerHTML ="请尝试字母+数字的组合";
                    }else   if(str != str2){
                                infoSecPsd.innerHTML ="两次密码不相同";
                            }else{
                                infoSecPsd.innerHTML ="";
                                infoSecPsd.style.color = "green";
                                flagsecPsd = 1;
                            }
    infoImg(infoSecPsd,imgSecPsd);
    return flagsecPsd;
}
//判断指定字符串是否在某个特定范围之内，若在返回true,否则返回false
//str:待判定的字符串,scope：给定的某个范围
var scopePhNum = ["13","14","15","16","18","19"];
function isStrInScope(str,scope){

    for(var i = 0;i < scope.length;i++)
    {
        if(str == scope[i])
        {
            return true;
        }
    }
    return false;
}

//用于验证手机号码输入是否正确，若正确，则提示信息为绿色，若错误，则获取焦点提示蓝色，失去焦点提示红色
//1.长度不对 2.包含特殊字符(非数字) 3.前两位不是13,14,15,16,17,18,19  4.已被注册
//截取字符串
// alert(str.slice(0,3));从下标0开始取，取3个字符
// alert(str.substr(0,4));从下标0开始，取4个字符
// alert(str.substring(0,5));从下标0开始，取到下标5
function checkPhNum(){
    var str = phNum.value;
    
    infoColor(infoPhNum);
    
    if(str.length != 11 || hasIllegalChar(str,dictNum) == true || isStrInScope(str.substr(0,2),scopePhNum) == false)
    {
        infoPhNum.innerHTML ="手机号码输入有误";
    }else{
        infoPhNum.innerHTML ="";
        infoPhNum.style.color = "green";
        flagphNum = 1;
    }
    infoImg(infoPhNum,imgPhNum);
    return flagphNum;
}
//产生新的验证码，随机的字母+数字的格式
//在dictOrdinary中的62个字符里随机取4个字符构成验证码 0~61 
//随机数C:rand  srand JS:

// 随机码函数
function createVerCode(length,dict){
    var str = "";
    var randNum;

    for(var i = 0;i < length;i++){
        randNum = Math.floor(Math.random() * dict.length)
        str += dict.charAt(randNum); 
    }

    return str;
}
// 调用函数产生验证码
function showVerCode(){
   var str = createVerCode(4,dictOrdinary);

   sysVerCode.innerText = str;
}
//用于验证用户输入验证码是否与系统给定验证码相同，若正确，则提示信息为绿色，若错误，则提示红色
function checkVerCode(){
    var str = userVerCode.value;
    var str2 = sysVerCode.innerText;

    if(str.toLowerCase() == str2.toLowerCase())
    {
        infoVerCode.style.color = "green";
        infoVerCode.innerHTML = "输入正确";
        flagVerCode = 1;
    }else{
        infoVerCode.style.color = "red";
        infoVerCode.innerHTML = "验证码输入错误";
    }
    infoImg(infoVerCode,imgVerCode);
    return flagVerCode;
}
//用于提交注册信息时，验证所有信息是否均正确，若正确，转入welcome.html，否则清空文本框内容
//return false阻止了sumit按钮被点击的默认事件，也就是让提交表单行为不再被执行，而执行的是我们自己写函数
function checkAll(){
    if(check.checked == true && checkUserName() == 1 && checkPsd() == 1 && checkSecPsd() == 1 && checkPhNum() == 1 && checkVerCode() == 1)
    {
        window.location.replace("../html/login.html");            //替换文档
        // window.location.assign("https://www.baidu.com"); //加载文档
    }else{
        alert("请正确填写信息！");
    }
    return false;
}