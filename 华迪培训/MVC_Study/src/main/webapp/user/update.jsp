<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/13
  Time: 16:01
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
    function update() {
        var url = "http://localhost:8080/MVC_Study/user/doUpdate";
        $.ajax({
            type:"post",
            url:url,
            // dataType:"json",
            contentType:"application/json",
            data:JSON.stringify({
                order_id:$("#order_id").val(),
                order_name:$("#order_name").val(),
                order_price:$("#order_price").val(),
                order_date:$("#order_date").val()
            }),
            success:function (data) {
                alert(data);
                window.location.href = "http://localhost:8080/MVC_Study/user/showOrders";
            },
            error:function (data) {
                alert(data);
            }
        });
    }
</script>
<body>
   <div align="center">
       <h3>订单修改</h3>
       <form class="form-group" action="<%=request.getContextPath()%>/user/doUpdate" method="post">
           <table  border="1" class="col-md-8 table-bordered table-striped">
               <tr>
                   <td>编号</td><td><input id="order_id" class="form-control" type="text" name="order_id" value="${order.order_id}" readonly></td>
               </tr>
               <tr>
                   <td>名称</td><td><input id="order_name" class="form-control" type="text" name="order_name" value="${order.order_name}"></td>
               </tr>
               <tr>
                   <td>价格</td><td><input id="order_price" class="form-control" type="text" name="order_price" value="${order.order_price}"></td>
               </tr>
               <tr>
                   <td>日期</td><td><input id="order_date" class="form-control" type="date" name="order_date" value="${order.order_date}"></td>
               </tr>
               <tr>
                   <td></td>
                   <td><input class="btn-primary" type="button" value="保存" onclick="update()">
                       <input class="btn-warning" type="button" onclick="history.go(-1)" value="取消"></td>
               </tr>
           </table>
       </form>
   </div>
</body>
</html>
