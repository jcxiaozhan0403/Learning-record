<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
  <script>
      function a() {
        $.post({
          url:"${pageContext.request.contextPath}/all",
          data:{"name":$("#username").val()},
          success: function (data) {
            alert(data);
          },
          error: function () {
            alert("失败");
          }
        })
      }
  </script>
  <body>
    <button id="btn" onclick="a">点一下</button>
  </body>
</html>
