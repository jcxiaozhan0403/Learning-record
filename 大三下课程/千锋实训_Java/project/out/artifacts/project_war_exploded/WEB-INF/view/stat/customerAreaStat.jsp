
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户地区统计</title>
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    //1.发送ajax
    $.get("${pageContext.request.contextPath}/stat/loadCustomerAreaStatJson.action",function (data) {
        var dom = document.getElementById("container")
        var myChart = echarts.init(dom);
        var option = {
            title: {
                text: '汽车出租系统客户地区统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: '客户地区人数',
                    type: 'pie',
                    radius: '50%',
                    data: data,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        //把option设置到myChart中
        myChart.setOption(option);
    })

</script>
</body>
</html>
