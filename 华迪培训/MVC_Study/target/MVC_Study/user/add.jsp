<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/14
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
    <script src="<%=request.getContextPath()%>/resource/js/jquery-3.4.1.js"></script>
</head>
<script type="text/javascript">
    function doAdd() {
        var url = "http://localhost:8080/MVC_Study/user/doAdd";
        alert(url);
        // debugger;
        $.ajax({
            type:"post",
            url:url,
            // dataType: "json",
            contentType:"application/json;charset=UTF-8",

            data:JSON.stringify({
                "order_name":$("#order_name").val(),
                "order_price":$("#order_price").val(),
                "order_date":$("#order_date").val()
            }),
            success:function (data) {
               alert(data);
                // console.log(data);
                window.location.href = "http://localhost:8080/MVC_Study/user/showOrders";
            },
            error: function (error) {
                alert(error);
                // console.log(error);
            }

        });
    }
</script>
<body>
<div align="center">
    <h3>订单新增</h3>
    <form class="form-group" action="<%=request.getContextPath()%>/user/doAdd" method="post">
        <table  border="1" class="col-md-8 table-bordered table-striped">

            <tr>
                <td>名称</td><td><input id="order_name" class="form-control" type="text" name="order_name" ></td>
            </tr>
            <tr>
                <td>价格</td><td><input id="order_price" class="form-control" type="text" name="order_price" ></td>
            </tr>
            <tr>
                <td>日期</td><td><input id="order_date" class="form-control" type="date" name="order_date" ></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input class="btn-primary" type="button" value="保存" onclick="doAdd()">
                    <input class="btn-warning" type="button" onclick="history.go(-1)" value="取消"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
