    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="utf-8">
        <title>菜单管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="favicon.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">

        <style type="text/css">
        .select-test{position: absolute;max-height: 500px;height: 350px;overflow: auto;width: 100%;z-index: 123;display: none;border:1px solid silver;top: 42px;}
        .layui-show{display: block!important;}
        </style>
        </head>
        <body class="childrenBody">
        <!-- 搜索条件开始 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>查询条件</legend>
        </fieldset>
        <form class="layui-form" method="post" id="searchFrm">
        <div class="layui-form-item">
        <div class="layui-inline">
        <label class="layui-form-label">菜单名称:</label>
        <div class="layui-input-inline">
        <input type="text" name="title"  autocomplete="off" class="layui-input">
        </div>
        </div>
        <div class="layui-inline">
        <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
        <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
        </div>
        </div>
        </form>

        <!-- 搜索条件结束 -->


        <!-- 数据表格开始 -->
        <table class="layui-hide" id="menuTable" lay-filter="menuTable"></table>
        <div style="display: none;" id="menuToolBar">
        <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
        </div>
        <div  id="menuBar" style="display: none;">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </div>
        <!-- 数据表格结束 -->

        <!-- 添加和修改的弹出层开始 -->
        <div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
        <form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
        <label class="layui-form-label">父级菜单：</label>
        <div class="layui-input-block">
        <div class="layui-unselect layui-form-select" id="pid_div">
        <div class="layui-select-title">
        <input type="hidden" name="pid"  id="pid">
        <input type="text" name="pid_str" id="pid_str" placeholder="请选择" readonly="" class="layui-input layui-unselect">
        <i class="layui-edge"></i>
        </div>
        </div>
        <div class="layui-card select-test" id="menuSelectDiv">
        <div class="layui-card-body">
        <div id="toolbarDiv"><ul id="menuTree" class="dtree" data-id="0" style="width: 100%;"></ul></div>
        </div>
        </div>
        </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">菜单名称:</label>
        <div class="layui-input-block">
        <input type="hidden" name="id">
        <input type="text" name="title"  placeholder="请输入菜单名称" autocomplete="off"
        class="layui-input">
        </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">菜单地址:</label>
        <div class="layui-input-block">
        <input type="text" name="href" placeholder="请输入菜单地址" autocomplete="off"
        class="layui-input">
        </div>
        </div>
        <div class="layui-form-item">
        <div class="layui-inline">
        <label class="layui-form-label">菜单图标:</label>
        <div class="layui-input-inline">
        <input type="text" name="icon"   placeholder="请输入菜单图标" lay-verify="required" autocomplete="off"
        class="layui-input">
        </div>
        </div>
        <div class="layui-inline">
        <label class="layui-form-label">TARGET:</label>
        <div class="layui-input-inline">
        <input type="text" name="target"  placeholder="请输入TRAGET"  autocomplete="off"
        class="layui-input">
        </div>
        </div>
        </div>
        <div class="layui-form-item">
        <div class="layui-inline">
        <label class="layui-form-label">是否展开:</label>
        <div class="layui-input-inline">
        <input type="radio" name="spread" value="1" title="展开">
        <input type="radio" name="spread" value="0" title="不展开"  checked="checked">
        </div>
        </div>
        <div class="layui-inline">
        <label class="layui-form-label">是否可用:</label>
        <div class="layui-input-inline">
        <input type="radio" name="available" value="1" checked="checked" title="可用">
        <input type="radio" name="available" value="0" title="不可">
        </div>
        </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
        <div class="layui-input-block">
        <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
        <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
        </div>
        </div>
        </form>

        </div>
        <!-- 添加和修改的弹出层结束 -->

        <script src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
        <script type="text/javascript">
        
        </script>
        </body>
        </html>