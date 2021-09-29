<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>学生列表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- 引入 Bootstrap -->
        <link href="https://cdn.usebootstrap.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <style>
        body {
            background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
        }
    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
    $(function () {
        // 页面加载，获取第一页数据
        getPageList(1,5);

        // 首页
        let navigateFirstPage;

        // 末页
        let navigateLastPage;

        // 当前页
        let pageNum;

        // 下一页
        let nextPage;

        // 上一页
        let prePage;

        // 页码集
        let navigatepageNums;
    });

    function getPageList(pageNum,pageSize) {
        console.log("查询第" + pageNum + "页数据，每页" + pageSize + "条");

        $.get({
            url:"${pageContext.request.contextPath}/student/list/" + pageNum + "/" + pageSize,
            data:{},
            success: function (data) {
                myTable(data);
            },
            error: function () {
                alert("失败");
            }
        });
    }

    // 表格渲染
    function myTable(data) {
        navigateFirstPage = data.navigateFirstPage;
        pageNum = data.nowPage;
        nextPage = data.nextPage;
        prePage = data.prePage;
        navigatepageNums = data.navigatepageNums;
        navigateLastPage = data.navigateLastPage

        // 取出数据
        let arr = data.list;

        // 清空表格
        $("#tbody").html("");
        // 填充表格
        for(let i =0; i<arr.length ;i++) {
            let html = "<tr>" +
                "<td>" + arr[i].id +"</td>" +
                "<td>" + arr[i].name +"</td>" +
                "<td>" + arr[i].age +"</td>" +
                "<td>" + arr[i].sex +"</td>" +
                "<td>" + arr[i].cls +"</td>" +
                "<td>" + arr[i].num +"</td>" +
                "<td>" +
                '<a class="btn btn-primary" href="<c:url value="/student/edit/'+ arr[i].id +'" />" style="margin-right: 10px">修改</a>' +
                '<a class="btn btn-danger" href="<c:url value="/student/delete/'+ arr[i].id +'" />">删除</a>' +
                "</td>" +
                "</tr>"

            $("#tbody").append(html);
        }

        // 清空页数导航
        $("#pageNum").html("");
        // 填充页数导航
        for(let i=0; i<navigatepageNums.length ;i++) {
            nowPage = navigatepageNums[i];

            let pageNum = '<li class="page-item">' +
                '<button class="page-link" onclick="getPageList($(this).text(),5)">' + nowPage + '</button>' +
                "</li>";

            let pageStart = '<li class="page-item">' +
                '<button class="page-link" onclick="getPageList(navigateFirstPage,5)">首页</button>' +
                "</li>";

            let pageEnd = '<li class="page-item">' +
                '<button class="page-link" onclick="getPageList(nextPage,5)">下一页</button>' +
                "</li>";

            if(i == 0) {
                pageNum = pageStart + pageNum;
            }
            if(i == navigatepageNums.length -1) {
                pageNum = pageNum + pageEnd;
            }



            $("#pageNum").append(pageNum);
        }

        // 当前页面添加激活样式
        $("li.page-item")[data.pageNum].className += ' active';
    }
</script>
    <body>
        <div class="container">
            <div class="row clearfix mt-5">
                <div class="col-md-12 column">
                    <div class="page-header">
                        <h1>
                            <small>学生列表</small>
                        </h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-1 offset-md-11 mb-3">
                    <a class="btn btn-primary" href="<c:url value="/student/add" />">新增</a>
                </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-striped" style='vertical-align: middle;text-align: center;'>
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>性别</th>
                            <th>班级</th>
                            <th>学号</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody id="tbody">
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <nav aria-label="..." class="col-md-3 offset-md-9 mt-3">
                    <ul class="pagination" id="pageNum">
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>