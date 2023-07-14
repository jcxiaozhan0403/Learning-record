<%--
  Created by IntelliJ IDEA.
  Car: pageContext.request.contextPath
  Date: 2020 3/8
  Time 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>出租管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <%--<link rel="icon" href="favicon.ico">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
</head>
<body class="childrenBody">

<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>

<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">身份证号:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="identity" id="identity" autocomplete="off"
                       class="layui-input layui-input-inline"
                       placeholder="请输入身份证号" style="height: 30px;border-radius: 10px">
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

<!-- 数据表格开始 -->
<div id="content" style="display: none;">
    <table id="carTable" lay-filter="carTable"></table>
    <div id="carBar" style="display: none;">
        <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-radius" lay-event="rentCar">出租汽车</a>
        <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="viewImage">查看车辆大图</a>
    </div>
</div>

<%--添加和修改的弹出层开始--%>
<div style="display: none;padding: 20px;" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">出租单号:</label>
            <div class="layui-input-block">
                <input type="text" name="rentid" lay-verify="required" readonly="readonly" placeholder="请输入出租单号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">起租时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="begindate" id="begindate" lay-verify="required" placeholder="请输入起租时间" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">还车时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="returndate" id="returndate" lay-verify="required" placeholder="请输入还车时间" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">身份证号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="identity" lay-verify="required" readonly="readonly" placeholder="请输入身份证号"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车牌号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnumber" lay-verify="required" readonly="readonly"  placeholder="请输入车牌号" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出租价格:</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required" placeholder="请输入出租价格" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">操作员:</label>
                <div class="layui-input-inline">
                    <input type="text" name="opername" id="opername" lay-verify="required" placeholder="请输入操作员" readonly="readonly" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: center;padding-right: 120px">
                <button type="button"
                        class="layui-btn layui-btn-normal layui-btn-md layui-icon layui-icon-release layui-btn-radius"
                        lay-filter="doSubmit" lay-submit="">提交
                </button>
                <button type="reset"
                        class="layui-btn layui-btn-warm layui-btn-md layui-icon layui-icon-refresh layui-btn-radius">重置
                </button>
            </div>
        </div>
    </form>
</div>

<%--查看大图弹出的层开始--%>
<div id="viewCarImageDiv" style="display: none;text-align: center">
    <img alt="出租图片" id="view_carimg">
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery','layer','form','table','laydate'],function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;

        //渲染日期表格
        laydate.render({
            elem: '#begindate',
            type: 'datetime'
        })

        laydate.render({
            elem: '#returndate',
            type: 'datetime'
        })

        //初始化数据表格
        var tableIns;
        function initCarData(){
            tableIns = table.render({
                elem: '#carTable' , //渲染的表格对象
                url: '${pageContext.request.contextPath}/car/loadAllCar.action', //请求数据接口的地址
                title:'车辆的数据表',
                height: 'full-150',
                page: true , //开启分页
                cols: [[
                    {field: 'carnumber',title:'车牌号',align:'center',width:'95'},
                    {field: 'cartype',title:'车辆类型',align:'center',width:'90'},
                    {field: 'color',title:'车辆颜色',align:'center',width:'90'},
                    {field: 'price',title:'车辆价格',align:'center',width:'90'},
                    {field: 'rentprice',title:'出租价格',align:'center',width:'90'},
                    {field: 'deposit',title:'出租押金',align:'center',width:'90'},
                    {field: 'isrenting',title:'是否出租',align:'center',width:'90' ,templet: function (d){
                            return d.isrenting == '1' ? '<font color=blue>已出租</font>' : '<font color=red>未出租</font>'
                        }},
                    {field: 'description',title:'车辆描述',align:'center',width:'150'},
                    {field: 'carimg',title:'缩略图',align:'center',width:'90',templet: function (d){
                            return "<img width=40 height=40 src=${pageContext.request.contextPath}/file/downloadShowFile.action?path="+d.carimg+">"
                        }},
                    {field: 'createtime',title:'录入时间',align:'center',width:'160'},
                    {fixed:'right',title:'操作',toolbar:'#carBar',align:'center',width:'180'}
                ]]
            })
        }

        //根据身份证号码进行查询
        $("#doSearch").click(function (){
            //获取表单的数据
            var params = $("#searchFrm").serialize();
            //发送请求检查客户是否存在
            $.post("${pageContext.request.contextPath}/rent/checkCustomerExit.action",params,function (obj){
                if(obj.code >= 0){  //客户存在，code的值为0
                    $("#content").show();
                    initCarData(); //初始化表格
                }else{
                    layer.msg("客户身份证不存在，请更正后再查询");
                    //隐藏数据表格
                    $("#content").hide();
                }
            })
        })

        //监听行工具栏
        table.on('tool(carTable)',function (obj){
            //获取当前的行数据
            var data = obj.data;
            //获取事件
            var layEvent = obj.event;
            if(layEvent == 'viewImage'){
                showCarImage(data);
            }else if(layEvent == 'rentCar'){
                openRentCar(data);
            }
        })

        var mainIndex;
        //打开出租车辆的页面
        function openRentCar(data){
            mainIndex =  layer.open({
                type: 1 ,
                title: "添加汽车出租",
                content: $("#saveOrUpdateDiv"),
                area: ['700px' , '380px'],
                success: function (index){
                   //清空数据表单
                    $("#dataFrm")[0].reset();
                    //获取参数(前台行数据)
                    var price = data.rentprice;
                    var identity = $("#identity").val();
                    var carnumber = data.carnumber;
                    //后台获取的数据
                    $.get("${pageContext.request.contextPath}/rent/initRentFrom.action",{
                        identity:identity,
                        price:price,
                        carnumber:carnumber
                    },function (obj){
                        //给form表单设置值
                        form.val("dataFrm",obj);
                    })
                }
            })
        }



        //查看大图的方法
        function showCarImage(data){
            layer.open({
                type: 1 ,
                title: "["+data.carnumber+"]的车辆图片",
                content: $("#viewCarImageDiv"),
                area: ['1100px' , '550px'],
                success: function (index){
                    //通过改变img 的src属性让图片展示
                    $("#view_carimg").attr("src","${pageContext.request.contextPath}/file/downloadShowFile.action?path="+data.carimg);
                }
            })
        }

        //提交表单
        form.on("submit(doSubmit)",function (obj){
            //获取表单的数据
            var params = $("#dataFrm").serialize();
            $.post("${pageContext.request.contextPath}/rent/saveRent.action",params,function (obj){
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex);
                $("#content").hide();
            })
        })

    })
</script>
</body>
</html>

