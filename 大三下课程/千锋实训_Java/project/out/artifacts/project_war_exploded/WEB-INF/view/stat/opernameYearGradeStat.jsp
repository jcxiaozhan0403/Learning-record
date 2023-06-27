
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>业务员年度业务统计</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
</head>


<body style="height: 100%; margin: 0">
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>

<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">选择年份:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" class="layui-input" id="year" readonly="readonly" placeholder="yyyy" style="height: 30px;border-radius: 10px">
            </div>
            <button type="button"
                    class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm"
                    id="doSearch" style="margin-top: 4px">查询
            </button>
            <button type="reset"
                    class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm"
                    style="margin-top: 4px">重置
            </button>
        </div>
    </div>
</form>
<div id="container" style="height: 75%;width: 90%"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
    var tableIns;
    layui.use(['jquery', 'layer', 'form', 'table', 'laydate'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            laydate = layui.laydate;

        //设置日期的插件
        laydate.render({
            elem: '#year',
            type: 'year',
            value:new Date()
        })

        //点击查询
        $("#doSearch").click(function () {
            getData();
        })

        function getData() {
            //1.获取年
            var year = $("#year").val();

            if(year ==""){
                year = new Date().getFullYear();
            }

            //2.发送ajax请求
            $.get("${pageContext.request.contextPath}/stat/loadOpernameYearGradeStatJson.action",{year:year},function (data) {
                var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var option = {
                    title:{
                        text:'年度业务员销售额统计',
                        x:'center'
                    },
                    tooltip:{
                        trigger:'axis',
                        axisPointer:{
                            type:'shadow'
                        }
                    },
                    xAxis: {
                        type: 'category',
                        data: data.name
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            name:'销售额',
                            data: data.value,
                            type: 'bar',
                            showBackground: true,
                            backgroundStyle: {
                                color: 'rgba(180, 180, 180, 0.2)'
                            }
                        }
                    ]
                }
                myChart.setOption(option);
            })
        }
    })

</script>
</body>
</html>
