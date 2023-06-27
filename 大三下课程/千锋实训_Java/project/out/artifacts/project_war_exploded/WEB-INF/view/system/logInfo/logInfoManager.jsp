<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/23
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>日志管理</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">

<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">登陆名称:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="loginname" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入登陆名称" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">登陆IP:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="loginip" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入登陆IP" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始时间:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="startTime" id="startTime" readonly="readonly" class="layui-input layui-input-inline"
                       placeholder="yyyy-MM-dd" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="endTime" id="endTime" readonly="readonly" class="layui-input layui-input-inline"
                       placeholder="yyyy-MM-dd" style="height: 30px;border-radius: 10px">
            </div>
        </div>

        <div class="layui-inline" style="margin-left: 50px">
            <button type="button" class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm" id="doSearch">查询</button>
            <button type="reset" class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm">重置</button>
        </div>
    </div>
</form>

<!-- 数据表格开始 -->
<table class="layui-hide" id="logInfoTable" lay-filter="logInfoTable"></table>
<div style="display: none;" id="logInfoToolBar">
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">批量删除</button>
</div>
<div id="logInfoBar" style="display: none;">
    <a class="layui-btn layui-btn-danger layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
</div>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">

    //1.声明数据表格对象
    var tableIns;
    //2.初始化layui的模块
    layui.use(['jquery','layer','form','table','laydate'],function () {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            laydate = layui.laydate;

        laydate.render({
            elem:'#startTime',
            type:'datetime'
        })

        laydate.render({
            elem:'#endTime',
            type:'datetime'
        })

        //3.渲染数据表格
        tableIns = table.render({
            elem : "#logInfoTable",
            url: "${pageContext.request.contextPath}/logInfo/loadAllLogInfo.action", //数据接口
            title: "日志信息表",
            toolbar: "#logInfoToolBar" ,
            height: "full-190",
            cellMinWidth: 100 ,
            page: true , //启动分页
            cols:[[  //列表数据
                {type:'checkbox',fixed:"left"},
                {field:'id',title:'ID',align:'center',with:'120'},
                {field:'loginname',title:'登录名称',align:'center',with:'260'},
                {field:'loginip',title:'登录ip',align:'center',with:'105'},
                {field:'logintime',title:'登录时间',align:'center',with:'180'},
                {fixd:'right',title:'操作',toolbar:'#logInfoBar' ,align:'center',with:'130'}
            ]],
            done:function (data , curr ,count) {
                //如果不是第一页,当前返回数据为0,我们就让返回上一页
                if(data.data.length == 0 && curr != 1){
                    tableIns.reload({
                        page:{
                            curr:curr-1
                        }
                    })
                }
            }
        })


        //模糊查询
        $("#doSearch").click(function () {
            //获取搜索框中的参数
            var param =  $("#searchFrm").serialize();
            tableIns.reload({
                url: "${pageContext.request.contextPath}/logInfo/loadAllLogInfo.action?"+param,
                page: {curr: 1}
            })
        })


        //监听行工具栏
        table.on('tool(logInfoTable)',function (obj) {
            //获取当前行数据
            var data = obj.data;
            var layEvent = obj.event;
            if(layEvent == 'del'){
                layer.confirm("真的确认删除["+data.loginname+"]这个日志信息吗?",function (index) {
                    $.get("${pageContext.request.contextPath}/logInfo/deleteLogInfo.action",{id:data.id},function (result) {
                        layer.msg(result.msg);
                        //刷新数据表格
                        tableIns.reload();
                    })
                })
            }
        })

        //监听头工具栏
        table.on("toolbar(logInfoTable)",function (obj) {
            switch (obj.event) {
                case 'deleteBatch':
                    deleteBatch();
                    break;
            }
        })

        //批量删除
        function deleteBatch() {
            //得到选中的数据
            var checkStatus = table.checkStatus("logInfoTable");
            var data = checkStatus.data;
            var param = "";
            //循环拼接id
            $.each(data,function (i,item) {
                if(i==0){
                    param +="ids="+item.id;
                }else{
                    param +="&ids="+item.id;
                }
            });
            layer.confirm("真的要删除这些日志吗?",function (index) {
                //发送ajax请求
                $.get("${pageContext.request.contextPath}/logInfo/deleteBatchLogInfo.action",param,function (result) {
                    layer.msg(result.msg);
                    //刷新数据表格
                    tableIns.reload();
                })
            })
        }
    })
</script>
</body>
</html>
