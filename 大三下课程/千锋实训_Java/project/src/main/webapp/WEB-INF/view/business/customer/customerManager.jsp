<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>客户管理</title>
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
            <label class="layui-form-label">客户姓名:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="custname" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入客户名称" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">身份证号:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="identity" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入身份证号" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户地址:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="address" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入客户地址" style="height: 30px;border-radius: 10px">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">客户电话:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="phone" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入客户电话" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客户职业:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="career" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入客户职业" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-inline">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="0" title="女">
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
<table class="layui-hide" id="customerTable" lay-filter="customerTable"></table>
<div id="customerToolBar" style="display: none;">
    <button type="button" class="layui-btn layui-btn-sm layui-btn-radius" lay-event="add">增加</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">
        批量删除
    </button>
</div>
<div id="customerBar" style="display: none;">
    <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
</div>

<!-- 添加和修改的弹出层-->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="custname" lay-verify="required" placeholder="请输入客户姓名" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">身份证号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="identity" lay-verify="required" placeholder="请输入客户姓名" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户地址:</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" placeholder="请输入客户地址" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户职业:</label>
                <div class="layui-input-inline">
                    <input type="text" name="career" placeholder="请输入客户职业" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户电话:</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" lay-verify="required|phone" placeholder="请输入客户电话" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户性别:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="sex" value="1" checked="checked" title="男">
                    <input type="radio" name="sex" value="0" title="女">
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
    //1.定义渲染的数据表格
    var tableIns;
    //2.定义和初始化模块
    layui.use(['jquery','layer','form','table'],function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;

        //3.渲染数据表格
        tableIns = table.render({
            elem: '#customerTable' , //渲染的目标对象
            url: '${pageContext.request.contextPath}/customer/loadAllCustomer.action', //数据接口地址
            title:'客户数据表', //标题
            height: 'full-210',
            cellMinWidth : 100 , //设置列最小默认宽度
            toolbar: '#customerToolBar' , //表格的头部工具栏
            page: true , //启动分页
            cols: [[
                {type:'checkbox',fixed: 'left'},
                {field:'identity',title:'身份证',align:'center',width:'200'},
                {field:'custname',title:'客户姓名',align:'center',width:'125'},
                {field:'address',title:'客户地址',align:'center',width:'125'},
                {field:'career',title:'客户职业',align:'center',width:'150'},
                {field:'phone',title:'手机号码',align:'center',width:'150'},
                {field:'sex',title:'性别',align:'center',width:'200',templet:function (d) {
                    return d.sex == '1' ? '<font color=blue>男</font>' : '<font color=red>女</font>'
                    }},
                {field:'createtime',title:'录入时间',align:'center',width:'200'},
                {fixed:'right',title:'操作',toolbar:'#customerBar',align:'center',width:'150'}
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
        });

        //模糊查询
        $("#doSearch").click(function () {
            //获取搜索框中的参数
           var param =  $("#searchFrm").serialize();
           tableIns.reload({
               url: "${pageContext.request.contextPath}/customer/loadAllCustomer.action?"+param,
               page: {curr: 1}
           })
        })

        //监听头部工具栏，触发事件
        table.on('toolbar(customerTable)', function(obj){
            switch(obj.event){
                case 'add':
                    //打开一个弹出层
                    openAddCustomer();
                    break;
                case 'deleteBatch':
                    deleteBatch();
                    break;
            };
        });

        //打开弹出层
        var url; //定义url一会保存的时候使用
        var mainIndex; //弹出层对象
        function openAddCustomer(){
            mainIndex = layer.open({
                type : 1,
                title: '添加客户',
                content: $("#saveOrUpdateDiv"),
                area: ['700px','320px'],
                success:function (index) {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    url = "${pageContext.request.contextPath}/customer/addCustomer.action";
                }
            })
        }

        //保存数据
        form.on("submit(doSubmit)",function (obj) {
            //序列化表单数据
            var param = $("#dataFrm").serialize();
            //发送ajax请求
            $.post(url,param,function (obj) {
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新数据表格
                tableIns.reload();
            })
        })

        //监听行工具栏
        table.on('tool(customerTable)',function (obj) {
            //console.log(obj)
            //获取当前行的数据
            var data = obj.data;
            //获取当前触发的事件
            var layEvent =  obj.event;
            if(layEvent == 'del'){
                layer.confirm('您确认要删除['+data.custname+'这个客户吗',function (index) {
                    //如果用户点击确认执行该函数
                    $.get("${pageContext.request.contextPath}/customer/deleteCustomer.action",{identity: data.identity},function (result) {
                        layer.msg(result.msg);
                        //刷新数据表格
                        tableIns.reload();
                    })
                })
            } else if (layEvent == 'edit'){
                //调用方法打开一个编辑窗口
                openUpdateCustomer(data);
            }
        })

        //打开编辑窗口
        function openUpdateCustomer(data){
            mainIndex = layer.open({
                type : 1,
                title: '修改客户',
                content: $("#saveOrUpdateDiv"),
                area: ['700px','320px'],
                success:function (index) {
                    //要把数据回显到表单中
                    form.val('dataFrm',data);
                    //设置url值
                    url = "${pageContext.request.contextPath}/customer/updateCustomer.action";
                }
            })
        }


        //批量删除的方法
        function deleteBatch(){
            //获取选中行的数据
           var checkStatus =  table.checkStatus("customerTable");
           var data = checkStatus.data;  //data就是一行数据
           //循环拼接参数
            var param = "";
            $.each(data,function (i,item) {
                if(i == 0){
                    param += "ids="+item.identity;
                }else{
                    param +="&ids="+item.identity;
                }
            })
            //param = ids=111&ids=222&ids=333
            //是否确认删除
            layer.confirm("真的要删除这些数据?",function (index) {
                //发送ajax请求
                $.get("${pageContext.request.contextPath}/customer/batchDeleteCustomer.action",param,function (res) {
                    layer.msg(res.msg);
                    //刷新表格数据
                    tableIns.reload();
                })
            })
        }
    })
</script>
</body>
</html>

