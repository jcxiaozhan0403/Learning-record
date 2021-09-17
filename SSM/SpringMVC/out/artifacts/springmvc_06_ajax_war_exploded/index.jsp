<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
  <script>
    $(function(){
        $("#btn").click(function(){
          alert("页面触发点击事件");
        });
    });
  </script>
  <body>
    <button id="btn">点一下</button>
  </body>
</html>
