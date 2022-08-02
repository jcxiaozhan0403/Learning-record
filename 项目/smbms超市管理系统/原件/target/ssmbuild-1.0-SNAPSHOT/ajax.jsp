<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2021/3/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src = "${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js">
    </script>
    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/book/a3",
                data:{"name":$("#username").val()},
                success:function (data) {
                 // console.log(data);
                 if (data.toString()==="ok"){
                     console.log(1);
                     $("#userInfo").css("color","green");
                 }else {
                     $("#userInfo").css("color","red");
                 }
                 $("#userInfo").html(data);
             }
                })
        }

        function a2(){
            $.post({
                url:"${pageContext.request.contextPath}/book/a3",
                data:{"pwd":$("#password").val()},
                success:function (data) {
                    console.log(data);
                    if (data.toString()=== "ok") {
                        console.log(1);
                        $("#passwordInfo").css("color", "green");
                    } else {
                        $("#passwordInfo").css("color", "red");
                    }
                    $("#passwordInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>
<p>
    用户名：<input type="text" id="username"  onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码：<input type="text" id="password"  onblur="a2()">
    <span id="passwordInfo"></span>
</p>
</body>
</html>
