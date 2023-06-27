<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/25
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>公告管理</title>
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
            <label class="layui-form-label">公告标题:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="title" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入公告标题" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">公告内容:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="content" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入公告内容" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">开始时间:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="startTime" id="startTime" readonly="readonly"
                       class="layui-input layui-input-inline"
                       placeholder="yyyy-MM-dd" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">操作人:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="opername" id="opername" class="layui-input layui-input-inline"
                       style="height: 30px;border-radius: 10px">
            </div>
        </div>

        <div class="layui-inline" style="margin-left: 50px">
            <button type="button"
                    class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm"
                    id="doSearch">查询
            </button>
            <button type="reset"
                    class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm">重置
            </button>
        </div>
    </div>
</form>

<!-- 数据表格开始 -->
<table class="layui-hide" id="newsTable" lay-filter="newsTable"></table>
<div style="display: none;" id="newsToolBar">
    <button type="button" class="layui-btn layui-btn-sm layui-btn-radius" lay-event="add">增加</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">
        批量删除
    </button>
</div>
<div id="newsBar" style="display: none;">
    <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-radius" lay-event="viewNews">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
</div>

<!-- 添加和修改的弹出层-->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm" style="margin-right: 20px">
        <div class="layui-form-item">
            <label class="layui-form-label">公告标题:</label>
            <div class="layui-input-block">
                <input type="hidden" name="id">
                <input type="text" name="title" placeholder="请输入公告标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公告内容:</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="content"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: center;padding-right: 120px">
                <button type="button"
                        class="layui-btn layui-btn-normal layui-btn-md layui-icon layui-icon-release layui-btn-radius"
                        lay-filter="doSubmit" lay-submit="">提交
                </button>
                <button type="reset" id="dataFrmResetBtn"
                        class="layui-btn layui-btn-warm layui-btn-md layui-icon layui-icon-refresh layui-btn-radius">重置
                </button>
            </div>
        </div>
    </form>
</div>

<%--查看公告的div--%>
<div id="viewNewsDiv" style="padding: 10px;display: none">
    <h2 id="view_title" align="center"></h2>
    <hr>
    <div style="text-align: right">
        发布人:<span id="view_opername"></span>
        <span style="display: inline-block;width: 20px"></span>
        发布时间:<span id="view_createtime"></span>
    </div>
    <hr>
    <div id="view_content"></div>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
    //1.声明数据表格对象
    var tableIns;
    //2.初始化layui的模块
    layui.use(['jquery','layer','form','table','laydate','layedit'],function () {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            laydate = layui.laydate,
            layedit = layui.layedit;


        laydate.render({
            elem:'#startTime',
            type:'datetime'
        })

        laydate.render({
            elem:'#endTime',
            type:'datetime'
        })

        //富文本编辑器
        var editIndex ;

        //3.渲染数据表格
        tableIns = table.render({
            elem : "#newsTable",
            url: "${pageContext.request.contextPath}/news/loadAllNews.action", //数据接口
            title: "公告信息",
            toolbar: "#newsToolBar" ,
            height: "full-190",
            cellMinWidth: 100 ,
            page: true , //启动分页
            cols:[[  //列表数据
                {type:'checkbox',fixed:"left"},
                {field:'id',title:'ID',align:'center',with:'120'},
                {field:'title',title:'公告标题',align:'center',with:'260'},
                {field:'createtime',title:'发布时间',align:'center',with:'105'},
                {field:'opername',title:'发布人',align:'center',with:'180'},
                {fixd:'right',title:'操作',toolbar:'#newsBar' ,align:'center',with:'130'}
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
                url: "${pageContext.request.contextPath}/news/loadAllNews.action?"+param,
                page: {curr: 1}
            })
        })

        //监听头工具栏
        table.on("toolbar(newsTable)",function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddNews();
                    break;
                case 'deleteBatch':
                    deleteBatch();
                    break;
            }
        })

        var url;
        var mainIndex;
        //添加用户
        function openAddNews() {
            mainIndex = layer.open({
                type:1,
                title:'添加公告',
                content:$("#saveOrUpdateDiv"),
                area:['700px','540px'],
                success:function (index) {
                    //建立编辑器
                    editIndex = layedit.build('content');
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    url = "${pageContext.request.contextPath}/news/addNews.action"
                }
            })
        }

        //监听行工具栏

        table.on('tool(newsTable)',function (obj) {
            //获取当前行数据
            var data = obj.data;
            var layEvent = obj.event;
            if(layEvent == 'edit'){
                openUpdateNews(data);
            }else if(layEvent == 'del'){
                layer.confirm("真的确认删除["+data.title+"]这个公告吗?",function (index) {
                    $.get("${pageContext.request.contextPath}/news/deleteNews.action",{id:data.id},function (result) {
                        layer.msg(result.msg);
                        //刷新数据表格
                        tableIns.reload();
                    })
                })
            }else if(layEvent == 'viewNews'){
                viewNews(data);
            }
        })



        //打开修改窗口
       function openUpdateNews(data){
            mainIndex = layer.open({
                type:1,
                title:'修改公告',
                content:$("#saveOrUpdateDiv"),
                area:['700px','540px'],
                success:function (index) {
                    //建立编辑器
                    editIndex = layedit.build('content');
                    form.val("dataFrm",data);
                    url = "${pageContext.request.contextPath}/news/updateNews.action"
                }
            })
        }

        //保存用户信息
        form.on("submit(doSubmit)",function (obj) {
            //把富文本中的数据同步到自己写的textarea中
            layedit.sync(editIndex);
            //序列化表单数据
            var param = $("#dataFrm").serialize();
            $.post(url,param,function (result) {
                layer.msg(result.msg);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新数据表格
                tableIns.reload();
            });
        })

        //批量删除
        function deleteBatch() {
            //得到选中的数据
            var checkStatus = table.checkStatus("newsTable");
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
            layer.confirm("真的要删除这些公告吗?",function (index) {
                //发送ajax请求
                $.get("${pageContext.request.contextPath}/news/deleteBatchNews.action",param,function (result) {
                    layer.msg(result.msg);
                    //刷新数据表格
                    tableIns.reload();
                })
            })
        }

        //查看公告
        function viewNews(data){
            mainIndex = layer.open({
                type:1,
                title:'查看公告',
                content:$("#viewNewsDiv"),
                area:['700px','540px'],
                success:function (index) {
                   $("#view_title").html(data.title);
                   $("#view_opername").html(data.opername);
                   $("#view_createtime").html(data.createtime);
                   $("#view_content").html(data.content);
                }
            })
        }
    })

</script>
</body>
</html>
