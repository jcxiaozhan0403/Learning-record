<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
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
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="rolename" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入角色名称" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">角色备注:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" name="roledesc" autocomplete="off" class="layui-input layui-input-inline"
                       placeholder="请输入角色备注" style="height: 30px;border-radius: 10px">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">是否可用:</label>
            <div class="layui-input-inline">
                <input type="radio" name="available" value="1" title="可用">
                <input type="radio" name="available" value="0" title="不可用">
            </div>
        </div>
        <div class="layui-inline">
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
<table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>
<div style="display: none;" id="roleToolBar">
    <button type="button" class="layui-btn layui-btn-sm layui-btn-radius" lay-event="add">增加</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">
        批量删除
    </button>
</div>
<div id="roleBar" style="display: none;">
    <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-radius" lay-event="selectRoleMenu">分配菜单</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
</div>

<!-- 添加和修改的弹出层-->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
    <form class="layui-form" lay-filter="dataFrm" id="dataFrm">

        <div class="layui-form-item">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-block">
                <input type="hidden" name="roleid">
                <input type="text" name="rolename" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色备注:</label>
            <div class="layui-input-block">
                <input type="text" name="roledesc" placeholder="请输入角色备注" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">是否可用:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="available" value="1" checked="checked" title="可用">
                    <input type="radio" name="available" value="0" title="不可用">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: center;padding-right: 110px">
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

<%--角色分配菜单的弹出层开始--%>
<div style="display: none" id="selectRoleMenu">
    <ul id="menuTree" class="dtree" data-id="0"></ul>
</div>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
    var tableIns;
    layui.extend({
        dtree: '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
    }).use(['jquery', 'layer', 'form', 'dtree', 'table'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var dtree = layui.dtree;
        var table = layui.table;
        //渲染表格
        tableIns = table.render({
            elem: '#roleTable', //渲染的目标对象
            url: '${pageContext.request.contextPath}/role/loadAllRole.action', //数据接口地址
            title: '角色列表数据', //标题
            height: 'full-150',
            cellMinWidth: 100, //设置列最小默认宽度
            toolbar: '#roleToolBar', //表格的头部工具栏
            page: true, //启动分页
            cols: [[
                {type: 'checkbox', fixed: 'left'},
                {field: 'roleid', title: 'ID', align: 'center'},
                {field: 'rolename', title: '角色名称', align: 'center'},
                {field: 'roledesc', title: '角色备注', align: 'center'},
                {
                    field: 'available', title: '是否可用', align: 'center', templet: function (d) {
                        return d.available == '1' ? '<font color=blue>可用</font>' : '<font color=red>不可用</font>'
                    }
                },
                {fixed: 'right', title: '操作', toolbar: '#roleBar', align: 'center'}
            ]]
        });

        //模糊查询
        $("#doSearch").click(function () {
            //获取搜索框中的参数
            var param = $("#searchFrm").serialize();
            tableIns.reload({
                url: "${pageContext.request.contextPath}/role/loadAllRole.action?" + param,
                page: {curr: 1}
            })
        })

        //监听头部工具栏
        table.on("toolbar(roleTable)", function (obj) {
            switch (obj.event) {
                case 'add':
                    openAddRole();
                    break;
                case 'deleteBatch':
                    deleteBatch();
                    break;
            }
        })

        var url;
        var mainIndex;

        //打开添加页面
        function openAddRole() {
            mainIndex = layer.open({
                type: 1,
                title: "添加角色",
                content: $("#saveOrUpdateDiv"),
                area: ['600px', '350px'],
                success: function (index) {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    url = "${pageContext.request.contextPath}/role/addRole.action"

                }
            })
        }

        //批量删除角色
        function deleteBatch() {
            //得到我们选中的行
            var checkStatus = table.checkStatus('roleTable');
            var data = checkStatus.data;
            var params = "";
            $.each(data, function (i, item) {
                if (i == 0) {
                    params += "ids=" + item.roleid;
                } else {
                    params += "&ids=" + item.roleid;
                }
            });
            layer.confirm("您真的确认删除这些角色吗?", function (index) {
                $.get("${pageContext.request.contextPath}/role/deleteBatchRole.action", params, function (res) {
                    layer.msg(res.msg);
                    //刷新表格
                    tableIns.reload();
                })
            })

        }

        //保存
        form.on("submit(doSubmit)", function (obj) {
            //序列化表单数据
            var param = $("#dataFrm").serialize();
            $.get(url, param, function (obj) {
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新数据表格
                tableIns.reload();
            })
        })

        //初始化添加和修改页面的下拉树
        /*                var menuTree = dtree.render({
                                elem: "#menuTree",
                                dataStyle: "layuiStyle", //使用layui风格展示数据
                                response:{message:"msg",statusCode:0}, //修改response中返回数据的定义
                                dataFormat: "list", //配置data的风格为list
                                url: "
        ${pageContext.request.contextPath}/menu/loadMenuManagerLeftTreeJson.action?spread=1",
                        icon:"2",
                        accordion:true
                })*/

        //点击下拉可以加载树
        /* $("#pid_div").on("click",function() {
                 $(this).toggleClass("layui-form-selected");
                 $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
         })

         dtree.on("node(menuTree)",function(obj) {
                 $("#pid_str").val(obj.param.context);
                 $("#pid").val(obj.param.nodeId);
                 $("#pid_div").toggleClass("layui-form-selected");
                 $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
         })*/

        //监听行工具栏
        table.on("tool(roleTable)", function (obj) {
            //获取当前行数据
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent == 'del') {
                layer.confirm("您真的确定删除[" + data.rolename + "]这个角色吗?", function (index) {
                    $.get("${pageContext.request.contextPath}/role/deleteRole.action", {roleid: data.roleid}, function (res) {
                        layer.msg(res.msg);
                        //刷新表格
                        tableIns.reload();
                    })
                })
            } else if (layEvent == 'edit') {
                openUpdateRole(data);
            } else if (layEvent == 'selectRoleMenu') { //分配权限
                openselectRoleMenu(data);
            }
        })

        function openUpdateRole(data) {
            mainIndex = layer.open({
                type: 1,
                title: "修改角色",
                content: $("#saveOrUpdateDiv"),
                area: ['600px', '350px'],
                success: function (index) {
                    form.val("dataFrm", data);//回显
                    $("menuSelectDiv").removeClass("layui-show");
                    url = "${pageContext.request.contextPath}/role/updateRole.action"
                }
            })
        }

        //打开分配菜单的弹出层
        function openselectRoleMenu(data) {
            var menuTree;
            mainIndex = layer.open({
                type: 1,
                tilte: '分配[' + data.rolename + "]的角色",
                content: $("#selectRoleMenu"),
                area: ['400px', '500px'],
                //添加按钮设定按钮的位置
                btnAlign: 'c',
                btn: ['<div class="layui-icon layui-icon-release">确认分配</div>', '<div class="layui-icon layui-icon-close">取消分配</div>'],
                yes: function (index, layero) {
                    var nodes = dtree.getCheckbarNodesParam("menuTree");
                    var roleid = data.roleid;
                    //拼接参数
                    var params = "roleid=" + roleid;
                    //循环拼接菜单的id
                    $.each(nodes, function (i, item) {
                        params += "&ids=" + item.nodeId;
                    })
                    //保存角色和菜单的关系
                    $.get("${pageContext.request.contextPath}/role/saveRoleMenu.action", params, function (obj) {
                        layer.msg(obj.msg);
                        //关闭弹出层
                        layer.close(mainIndex);
                    })
                },
                success: function (index) {
                    //初始化树
                    menuTree = dtree.render({
                        elem: "#menuTree",
                        dataStyle: "layuiStyle", //使用layui风格的数据格式
                        response: {message: "msg", statusCode: 0},
                        dataFormat: "list",
                        checkbar: true,
                        checkbarData: "choose",
                        url: "${pageContext.request.contextPath}/role/initRoleMenuTreeJson.action?roleid=" + data.roleid
                    })
                }
            })
        }

    })


</script>
</body>
</html>
