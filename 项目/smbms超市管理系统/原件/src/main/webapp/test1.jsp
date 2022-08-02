<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2021/3/24
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src = "${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script>
        $(function (){
            $("#btu").click(function (){
            $.post("${pageContext.request.contextPath}/book/a2",function (data) {
                console.log(data);
                var html="";

                for (let i = 0; i < data.length; i++) {
                    html += "<tr>" +
                        "<td>"+ data[i].bookID+"</td>"+
                        "<td>"+ data[i].bookName+"</td>"+
                        "<td>"+ data[i].bookCounts+"</td>"+
                        "<td>"+ data[i].detail+"</td>"+

                "</tr>"
                    $("#content").html(html);
                }
            });
        })
        });
    </script>
</head>
<body>

<input type="button" value="加载数据" id="btu">
<table>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>数量</td>
        <td>细节</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>
</body>
</html>
