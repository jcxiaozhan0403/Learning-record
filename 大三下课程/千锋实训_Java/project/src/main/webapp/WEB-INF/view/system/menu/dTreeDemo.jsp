<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui_ext/dtree/font/dtreefont.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    </head>
<body>
    <div style="height: 400px;overflow: auto;">
        <ul id="menuTree" class="dtree" data-id="0"></ul>
    </div>
</body>
    <script type="text/javascript">
        var menuTree;
        layui.extend({
            dtree: '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
        }).use(['jquery','layer','form','dtree'],
        function (){
            var $ = layui.jquery;
            var layer = layui.layer;
            var form = layui.form;
            var dtree = layui.dtree;


            dtree.render({
                elem: "#menuTree",
                //url: "../../../json/case/dataTree2.json",
                data: [
                    {"id":"001","title": "湖南省","checkArr": "0","parentId": "0"},
                    {"id":"002","title": "湖北省","checkArr": "0","parentId": "0"},
                    {"id":"003","title": "广东省","checkArr": "0","parentId": "0"},
                    {"id":"004","title": "浙江省","checkArr": "0","parentId": "0"},
                    {"id":"005","title": "福建省","checkArr": "0","parentId": "0"},
                    {"id":"001001","title": "长沙市","checkArr": "0","parentId": "001"},
                    {"id":"001002","title": "株洲市","checkArr": "0","parentId": "001"},
                    {"id":"001003","title": "湘潭市","checkArr": "0","parentId": "001"},
                    {"id":"001004","title": "衡阳市","checkArr": "0","parentId": "001"},
                    {"id":"001005","title": "郴州市","checkArr": "0","iconClass": "dtree-icon-caidan_xunzhang","parentId": "001"}
                ],
                dataFormat: "list",  //配置data的风格为list
                //checkbar:true //开启复选框
            });
        })

    </script>
</html>
