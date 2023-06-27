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
<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js"></script>
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
            elem:'#begindate',
            type:'datetime'
        })

        laydate.render({
            elem:'#returndate',
            type:'datetime'
        })

        //模糊查询
        $("#doSearch").click(function () {
            //获取用户输入的身份证号码
            var param = $("#searchFrm").serialize();
            $.get("${pageContext.request.contextPath}/rent/checkCustomerExist.action",param,function (obj) {
                if(obj.code == 0 ){ //客户存在
                    //初始化数据
                    initCarData(); //初始化未出租的汽车数据
                    //展示数据,隐藏的表格数据显现出来
                    $("#content").show();
                }else {
                    layer.msg("客户的身份证号码不存在,请更正后查询");
                    $("#content").hide();
                }
            })
        })

        //初始化未出租的车辆
        function initCarData() {
            tableIns = table.render({
                elem : "#carTable",
                url: "${pageContext.request.contextPath}/car/loadAllCar.action?isrenting=0", //数据接口
                title: "车辆数据表",
                height: "full-150",
                page: true , //启动分页
                cols:[[  //列表数据
                    {field:'carnumber',title:'车牌号',align:'center',with:'90'},
                    {field:'cartype',title:'车辆类型',align:'center',with:'70'},
                    {field:'color',title:'车辆颜色',align:'center',with:'70'},
                    {field:'price',title:'车辆价格',align:'center',with:'70'},
                    {field:'rentprice',title:'出租价格',align:'center',with:'70'},
                    {field:'deposit',title:'出租押金',align:'center',with:'90'},
                    {field:'isrenting',title:'出租状态',align:'center',with:'90',templet: function (d) {
                            return d.isrenting == '1'? '<font color=blue>已出租</font>' : '<font color=red>未出租</font>'
                        }},
                    {field:'description',title:'车辆描述',align:'center',with:'150'},
                    {field:'carimg',title:'缩略图',align:'center',with:'80',templet:function (d) {
                            return "<img width=40 height=40 src=${pageContext.request.contextPath}/file/downloadShowFile.action?path="+d.carimg+"/>"
                        }},
                    {field:'createtime',title:'录入时间',align:'center',with:'170'},
                    {fixd:'right',title:'操作',toolbar:'#carBar' ,align:'center',with:'220'}
                ]]
            })
        }



        //编写行工具栏监听
        table.on('tool(carTable)',function (obj) {
            //获取当前行数数据
            var data =  obj.data;
            console.log(data)
            if(obj.event == 'viewImage'){
                showCarImage(data);
            }else if (obj.event == 'rentCar'){
                openRentCar(data);
            }
        })

        //查看大图的方法
        function showCarImage(data){
            layer.open({
                type:1,
                title:"["+data.carnumber+"]的车辆图片",
                content: $("#viewCarImageDiv"),
                area: ['1100px','550px'],
                success:function (index) {
                    //找到图片,设置src属性
                    $("#view_carimg").attr("src","${pageContext.request.contextPath}/file/downloadShowFile.action?path="+data.carimg);
                }
            })
        }
        
        //打开出租汽车的弹出层
        var mainIndex;
        function openRentCar(data) {
            mainIndex = layer.open({
                type : 1,
                title: '添加汽车出租',
                content: $("#saveOrUpdateDiv"),
                area: ['690px','380px'],
                success: function (index) {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    var price = data.rentprice;
                    var identity = $("#identity").val();
                    var carnumber = data.carnumber;
                    $.get("${pageContext.request.contextPath}/rent/initRentFrom.action",{
                        identity:identity,
                        price:price,
                        carnumber:carnumber
                    },function (obj) {
                        //赋值
                        form.val("dataFrm",obj);
                    })
                }
            })
        }

        //添加
        form.on("submit(doSubmit)",function (obj) {
            //序列化表单数据
            var param = $("#dataFrm").serialize();
            //发送保存的ajax请求
            $.post("${pageContext.request.contextPath}/rent/saveRent.action",param,function (obj) {
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

