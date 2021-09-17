<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/9
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../resource/css/bootstrap.css">
    <script src="<%=request.getContextPath()%>/resource/js/jquery-3.4.1.js"></script>
</head>
${result}

<script type="text/javascript">
    function deleteOrder(orderId) {
        var url = "http://localhost:8080/MVC_Study/user/doDelete/"+orderId;
      $.ajax({
          url:url,
          type:"post",
          contentType:"application/json",
          data:{
              orderId:orderId
          },
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
     <div>
         <a class="btn-block" href="<%=request.getContextPath()%>/user/logout">注销</a>
     </div>
      <div align="center">
          <h3>订单列表</h3>
          <table border="1" class="col-md-8 table-bordered table-striped">

              <tr>
                  <td>订单编号</td>
                  <td>订单名称</td>
                  <td>订单价格</td>
                  <td>销售日期</td>
                  <td>操作</td>
              </tr>
              <c:forEach var="order" items="${orderList}">
                  <tr>

                      <td>${order.order_id}</td>
                      <td>${order.order_name}</td>
                      <td>${order.order_price}</td>
                      <td>${order.order_date}</td>
                      <td>
                          <a class="btn-warning btn-block" href="<%=request.getContextPath()%>/user/update/${order.order_id}">修改</a>
<%--                          <a class="btn-danger btn-block" href="<%=request.getContextPath()%>/user/delete/${order.order_id}">删除</a>--%>
                          <a class="btn-danger btn-block" onclick="deleteOrder('${order.order_id}');">删除</a>
                          <a class="btn-success btn-block" href="<%=request.getContextPath()%>/user/add.jsp">新增</a>
                      </td>
                  </tr>
              </c:forEach>
          </table>
      </div>
</body>
</html>
