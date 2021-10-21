## 概述
Ajax即Asynchronous Javascript And XML（异步JavaScript和XML）在 2005年被Jesse James Garrett提出的新术语，用来描述一种使用现有技术集合的‘新’方法，包括: HTML 或 XHTML, CSS, JavaScript, DOM, XML, XSLT, 以及最重要的XMLHttpRequest。 [3]  使用Ajax技术网页应用能够快速地将增量更新呈现在用户界面上，而不需要重载（刷新）整个页面，这使得程序能够更快地回应用户的操作。

## JQuery Ajax
```jsp
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
```