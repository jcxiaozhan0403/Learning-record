<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                        <button type="button" class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm" id="doSearch">查询</button>
                        <button type="reset" class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm">重置</button>
                </div>
        </div>
</form>

<!-- 数据表格开始 -->
<table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>
<div style="display: none;" id="roleToolBar">
        <button type="button" class="layui-btn layui-btn-sm layui-btn-radius" lay-event="add">增加</button>
        <button type="button" class="layui-btn layui-btn-danger layui-btn-sm layui-btn-radius" lay-event="deleteBatch">批量删除</button>
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


</script>
</body>
</html>
