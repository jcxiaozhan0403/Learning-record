<%--
  Created by IntelliJ IDEA.
  Check: YQF
  Date: 2019/10/14
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>检查单管理</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
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
            <label class="layui-form-label">检查单号:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="checkid" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入检查单号" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">存在问题:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="problem" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入存在的问题" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">问题描述:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="checkdesc" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入问题描述" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">出租单号:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="rentid" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入出租单号" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始时间:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="startTime" id="startTime" readonly="readonly"
                       class="layui-input layui-input-inline"
                       placeholder="请输入开始检查时间" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间:</label>
            <div class="layui-input-inline" style="padding: 5px;width: 280px">
                <input type="text" name="endTime" id="endTime" readonly="readonly"
                       class="layui-input layui-input-inline"
                       placeholder="请输入结束检查时间" style="height: 30px;border-radius: 10px;width: 280px">
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: center">
        <div class="layui-inline">
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
<table class="layui-hide" id="checkTable" lay-filter="checkTable"></table>
<div id="checkToolBar" style="display: none;">
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">批量删除</button>
</div>

<div style="display: none;" id="checkBar">
    <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
</div>

<!-- 添加和修改的弹出层-->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">检查单号:</label>
            <div class="layui-input-block">
                <input type="text" name="checkid" lay-verify="required" readonly="readonly" placeholder="请输入检查单号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出租单号:</label>
            <div class="layui-input-block">
                <input type="text" name="rentid" lay-verify="required" readonly="readonly" placeholder="请输入出租单号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">检查时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="checkdate" id="checkdate" lay-verify="required" placeholder="请输入起租时间" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">存在问题:</label>
                <div class="layui-input-inline">
                    <input type="text" name="problem" lay-verify="required" id="problem" placeholder="请输入存在的问题" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">问题描述:</label>
                <div class="layui-input-inline">
                    <input type="text" name="checkdesc" lay-verify="required" placeholder="请输入问题描述"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">赔付金额:</label>
                <div class="layui-input-inline">
                    <input type="text" name="paymoney" lay-verify="required"  placeholder="请输入车牌号" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
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

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['jquery','layer','form','table','laydate'],function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;

        //查询条件的日期组件
        laydate.render({
            elem: '#startTime',
            type: 'datetime'
        })

        laydate.render({
            elem: '#endTime',
            type: 'datetime'
        })

        //修改页面的日期组件
        laydate.render({
            elem: '#checkdate',
            type: 'datetime'
        })

        //初始化数据表格
        var tableIns;
        tableIns = table.render({
            elem: '#checkTable' , //渲染的表格对象
            url: '${pageContext.request.contextPath}/check/loadAllCheck.action', //请求数据接口的地址
            title:'检查单数据表',
            toolbar: '#checkToolBar',
            height: 'full-260',
            page: true , //开启分页
            cellMinWidth: 100,
            cols: [[
                {type: 'checkbox',fixed:'left'},
                {field: 'checkid',title:'检查单号',align:'center',width:'260'},
                {field: 'rentid',title:'出租单号',align:'center',width:'260'},
                {field: 'problem',title:'存在问题',align:'center',width:'105'},
                {field: 'checkdesc',title:'问题描述',align:'center',width:'150'},
                {field: 'paymoney',title:'赔付金额',align:'center',width:'100'},
                {field: 'opername',title:'操作员',align:'center',width:'100'},
                {field: 'checkdate',title:'检查时间',align:'center',width:'180'},
                {field: 'createtime',title:'录入时间',align:'center',width:'180'},
                {fixed:'right',title:'操作',toolbar:'#checkBar',align:'center',width:'150'}
            ]],
            done: function (data,curr,count){
                //如果不是第一页，返回的值为0，返回到上一页
                if(data.data.length == 0 && crr != 1){
                    tableIns.reload({
                        page: {
                            curr : curr - 1
                        }
                    })
                }
            }
        })

        //模糊查询
        $("#doSearch").click(function (){
            //获取表单的数据
            var params = $("#searchFrm").serialize();
            tableIns.reload({
                url: "${pageContext.request.contextPath}/check/loadAllCheck.action?"+params,
                page: {curr: 1}
            })
        })

        //监听行工具栏
        table.on('tool(checkTable)',function (obj){
            //获取当前的行数据
            var data = obj.data;
            //获取事件
            var layEvent = obj.event;
            if(layEvent == 'edit'){
                openUpdateCheck(data);
            }else if(layEvent == 'del'){
                layer.confirm("您是否确认删除"+data.checkid+"这个检查单吗？",function (index){
                    //发送ajax请求
                    $.get("${pageContext.request.contextPath}/check/deleteCheck.action",{checkid: data.checkid },function (res){
                        layer.msg(res.msg);
                        //刷新数据表格
                        tableIns.reload();
                    })
                })
            }
        })

        var mainIndex;
        var url;
        //打开检查单修改页面
        function openUpdateCheck(data){
            mainIndex =  layer.open({
                type: 1 ,
                title: "修改检查单",
                content: $("#saveOrUpdateDiv"),
                area: ['750px' , '420px'],
                success: function (index){
                    form.val("dataFrm",data);
                    url = "${pageContext.request.contextPath}/check/updateCheck.action"
                }
            })
        }

        //提交表单
        form.on("submit(doSubmit)",function (obj){
            //获取表单的数据
            var params = $("#dataFrm").serialize();
            $.post(url,params,function (obj){
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新表格数据
                tableIns.reload();
            })
        })

        //监听头部工具栏事件
        table.on("toolbar(checkTable)",function (obj){
            var layEvent = obj.event;
            if(layEvent == 'deleteBatch'){
                //得到选中的行信息
                var checkStatus =  table.checkStatus("checkTable");
                var data = checkStatus.data; //拿到行数据
                //定义要发送给后台的参数  ids=123123&231231
                var params = "";
                $.each(data ,function (i , item){
                    if(i == 0){
                        params += "ids="+item.checkid;
                    }else{
                        params += "&ids="+item.checkid;
                    }
                });
                layer.confirm("您确认要删除这些检查单信息吗?",function (index){
                    //发送异步请求删除
                    $.get("${pageContext.request.contextPath}/check/deleteBatchCheck.action",params,function (res){
                        layer.msg(res.msg);
                        //刷新表格
                        tableIns.reload();
                    })
                })
            }
        })
    })
</script>
</body>
</html>

