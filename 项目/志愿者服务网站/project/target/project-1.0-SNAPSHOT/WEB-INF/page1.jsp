<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/6/24
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>文明川信-领先全国的志愿服务信息系统版|中国志愿|志愿中国</title>
    <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/common.js"></script>
    <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/datepicker.js"></script>
    <script type="text/javascript" src="https://css.zhiyuanyun.com/common/login.js"></script>
    <!--[if lte IE 6]>
    <script language="javascript" type="text/javascript" src="https://css.zhiyuanyun.com/lib/png.js" ></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, li, input , a, a:hover, h2, b');
    </script>
    <![endif]-->
    <script type="text/javascript" src="https://css.zhiyuanyun.com/common/front.js"></script>
    <link href="https://css.zhiyuanyun.com/default/style.css" rel="stylesheet" type="text/css">
    <link href="https://css.zhiyuanyun.com/chinavol/style.css" rel="stylesheet" type="text/css">
    <meta name="renderer" content="webkit|ie-stand">
</head>
<body>

<div class="header_logo">
    <div class="wrap clearfix">
        <div class="l">
            <a href="<c:url value="/index" />" style="display:block;width:340px;height:100px;"></a>
        </div>
    </div>
</div>
<div class="nav">
    <div class="wrap" style="color:#fff;">
        <a href="<c:url value="/index" />" style="width:73px;">首页</a>
        <a href="<c:url value="/page1" />" class="sel">文明川信</a>
        <a href="<c:url value="/page2" />">川信志愿者</a>
        <a href="<c:url value="/page3" />">雷锋热线</a>
        <a href="<c:url value="/page4" />">公益广告</a>
        <a href="<c:url value="/management/login" />">管理员登录</a>
    </div>
</div>
<style>
    #reg_province_vol ul,#reg_province_org ul,#reg_province_login ul,#map_org ul,#map_opp ul{width:100%;margin:10px;}
    #reg_province_vol ul li,#reg_province_org ul li,#reg_province_login ul li,#map_org ul li,#map_opp ul li{float:left;width:20%;text-align:center;line-height:200%;}
    body {
        position: relative;
    }

    .footer {
        position: absolute;
        bottom: -100px;
        left: 0;
        right: 0;
    }

    .main {
        background: url(${page1bk});
        background-size:cover;
    }

    .main ul {
        width: 800px;
        height: 700px;
        line-height: 80px;
        font-size: 25px;
        margin: 20px auto;
    }
</style>
<div id="reg_province_vol" style="display:none;">
    <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="//npo.zhiyuanyun.com/app/user/register.php">全国性社会组织</a></li><li><a href="//www.bv2008.cn/app/user/register.php">北京市</a></li><li><a href="//tj.zhiyuanyun.com/app/user/register.php">天津市</a></li><li><a href="//he.zhiyuanyun.com/app/user/register.php">河北省</a></li><li><a href="//sx.zhiyuanyun.com/app/user/register.php">山西省</a></li><li><a href="//nm.zhiyuanyun.com/app/user/register.php">内蒙古自治区</a></li><li><a href="//ln.zhiyuanyun.com/app/user/register.php">辽宁省</a></li><li><a href="//jl.zhiyuanyun.com/app/user/register.php">吉林省</a></li><li><a href="//hl.zhiyuanyun.com/app/user/register.php">黑龙江省</a></li><li><a href="//sh.zhiyuanyun.com/app/user/register.php">上海市</a></li><li><a href="//js.zhiyuanyun.com/app/user/register.php">江苏省</a></li><li><a href="//zj.zhiyuanyun.com/app/user/register.php">浙江省</a></li><li><a href="//ah.zhiyuanyun.com/app/user/register.php">安徽省</a></li><li><a href="//fj.zhiyuanyun.com/app/user/register.php">福建省</a></li><li><a href="//jx.zhiyuanyun.com/app/user/register.php">江西省</a></li><li><a href="//sd.zhiyuanyun.com/app/user/register.php">山东省</a></li><li><a href="//ha.zhiyuanyun.com/app/user/register.php">河南省</a></li><li><a href="//hb.zhiyuanyun.com/app/user/register.php">湖北省</a></li><li><a href="//hn.zhiyuanyun.com/app/user/register.php">湖南省</a></li><li><a href="//gd.zhiyuanyun.com/app/user/register.php">广东省</a></li><li><a href="//gx.zhiyuanyun.com/app/user/register.php">广西自治区</a></li><li><a href="//hi.zhiyuanyun.com/app/user/register.php">海南省</a></li><li><a href="//cq.zhiyuanyun.com/app/user/register.php">重庆市</a></li><li><a href="//sc.zhiyuanyun.com/app/user/register.php">四川省</a></li><li><a href="//www.zygz.org.cn/app/user/register.php">贵州省</a></li><li><a href="//yn.zhiyuanyun.com/app/user/register.php">云南省</a></li><li><a href="//xz.zhiyuanyun.com/app/user/register.php">西藏自治区</a></li><li><a href="//sn.zhiyuanyun.com/app/user/register.php">陕西省</a></li><li><a href="//gs.zhiyuanyun.com/app/user/register.php">甘肃省</a></li><li><a href="//qh.zhiyuanyun.com/app/user/register.php">青海省</a></li><li><a href="//nx.zhiyuanyun.com/app/user/register.php">宁夏自治区</a></li><li><a href="//xj.zhiyuanyun.com/app/user/register.php">新疆自治区</a></li><li><a href="//bt.zhiyuanyun.com/app/user/register.php">兵团</a></li></ul></div>

<div id="reg_province_org" style="display:none;">
    <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="//npo.zhiyuanyun.com/app/user/register.php?type=org">全国性社会组织</a></li><li><a href="//www.bv2008.cn/app/user/register.php?type=org">北京市</a></li><li><a href="//tj.zhiyuanyun.com/app/user/register.php?type=org">天津市</a></li><li><a href="//he.zhiyuanyun.com/app/user/register.php?type=org">河北省</a></li><li><a href="//sx.zhiyuanyun.com/app/user/register.php?type=org">山西省</a></li><li><a href="//nm.zhiyuanyun.com/app/user/register.php?type=org">内蒙古自治区</a></li><li><a href="//ln.zhiyuanyun.com/app/user/register.php?type=org">辽宁省</a></li><li><a href="//jl.zhiyuanyun.com/app/user/register.php?type=org">吉林省</a></li><li><a href="//hl.zhiyuanyun.com/app/user/register.php?type=org">黑龙江省</a></li><li><a href="//sh.zhiyuanyun.com/app/user/register.php?type=org">上海市</a></li><li><a href="//js.zhiyuanyun.com/app/user/register.php?type=org">江苏省</a></li><li><a href="//zj.zhiyuanyun.com/app/user/register.php?type=org">浙江省</a></li><li><a href="//ah.zhiyuanyun.com/app/user/register.php?type=org">安徽省</a></li><li><a href="//fj.zhiyuanyun.com/app/user/register.php?type=org">福建省</a></li><li><a href="//jx.zhiyuanyun.com/app/user/register.php?type=org">江西省</a></li><li><a href="//sd.zhiyuanyun.com/app/user/register.php?type=org">山东省</a></li><li><a href="//ha.zhiyuanyun.com/app/user/register.php?type=org">河南省</a></li><li><a href="//hb.zhiyuanyun.com/app/user/register.php?type=org">湖北省</a></li><li><a href="//hn.zhiyuanyun.com/app/user/register.php?type=org">湖南省</a></li><li><a href="//gd.zhiyuanyun.com/app/user/register.php?type=org">广东省</a></li><li><a href="//gx.zhiyuanyun.com/app/user/register.php?type=org">广西自治区</a></li><li><a href="//hi.zhiyuanyun.com/app/user/register.php?type=org">海南省</a></li><li><a href="//cq.zhiyuanyun.com/app/user/register.php?type=org">重庆市</a></li><li><a href="//sc.zhiyuanyun.com/app/user/register.php?type=org">四川省</a></li><li><a href="//www.zygz.org.cn/app/user/register.php?type=org">贵州省</a></li><li><a href="//yn.zhiyuanyun.com/app/user/register.php?type=org">云南省</a></li><li><a href="//xz.zhiyuanyun.com/app/user/register.php?type=org">西藏自治区</a></li><li><a href="//sn.zhiyuanyun.com/app/user/register.php?type=org">陕西省</a></li><li><a href="//gs.zhiyuanyun.com/app/user/register.php?type=org">甘肃省</a></li><li><a href="//qh.zhiyuanyun.com/app/user/register.php?type=org">青海省</a></li><li><a href="//nx.zhiyuanyun.com/app/user/register.php?type=org">宁夏自治区</a></li><li><a href="//xj.zhiyuanyun.com/app/user/register.php?type=org">新疆自治区</a></li><li><a href="//bt.zhiyuanyun.com/app/user/register.php?type=org">兵团</a></li></ul></div>

<div id="reg_province_login" style="display:none;">
    <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="//npo.zhiyuanyun.com/app/user/login.php">全国性社会组织</a></li><li><a href="//www.bv2008.cn/app/user/login.php">北京市</a></li><li><a href="//tj.zhiyuanyun.com/app/user/login.php">天津市</a></li><li><a href="//he.zhiyuanyun.com/app/user/login.php">河北省</a></li><li><a href="//sx.zhiyuanyun.com/app/user/login.php">山西省</a></li><li><a href="//nm.zhiyuanyun.com/app/user/login.php">内蒙古自治区</a></li><li><a href="//ln.zhiyuanyun.com/app/user/login.php">辽宁省</a></li><li><a href="//jl.zhiyuanyun.com/app/user/login.php">吉林省</a></li><li><a href="//hl.zhiyuanyun.com/app/user/login.php">黑龙江省</a></li><li><a href="//sh.zhiyuanyun.com/app/user/login.php">上海市</a></li><li><a href="//js.zhiyuanyun.com/app/user/login.php">江苏省</a></li><li><a href="//zj.zhiyuanyun.com/app/user/login.php">浙江省</a></li><li><a href="//ah.zhiyuanyun.com/app/user/login.php">安徽省</a></li><li><a href="//fj.zhiyuanyun.com/app/user/login.php">福建省</a></li><li><a href="//jx.zhiyuanyun.com/app/user/login.php">江西省</a></li><li><a href="//sd.zhiyuanyun.com/app/user/login.php">山东省</a></li><li><a href="//ha.zhiyuanyun.com/app/user/login.php">河南省</a></li><li><a href="//hb.zhiyuanyun.com/app/user/login.php">湖北省</a></li><li><a href="//hn.zhiyuanyun.com/app/user/login.php">湖南省</a></li><li><a href="//gd.zhiyuanyun.com/app/user/login.php">广东省</a></li><li><a href="//gx.zhiyuanyun.com/app/user/login.php">广西自治区</a></li><li><a href="//hi.zhiyuanyun.com/app/user/login.php">海南省</a></li><li><a href="//cq.zhiyuanyun.com/app/user/login.php">重庆市</a></li><li><a href="//sc.zhiyuanyun.com/app/user/login.php">四川省</a></li><li><a href="//www.zygz.org.cn/app/user/login.php">贵州省</a></li><li><a href="//yn.zhiyuanyun.com/app/user/login.php">云南省</a></li><li><a href="//xz.zhiyuanyun.com/app/user/login.php">西藏自治区</a></li><li><a href="//sn.zhiyuanyun.com/app/user/login.php">陕西省</a></li><li><a href="//gs.zhiyuanyun.com/app/user/login.php">甘肃省</a></li><li><a href="//qh.zhiyuanyun.com/app/user/login.php">青海省</a></li><li><a href="//nx.zhiyuanyun.com/app/user/login.php">宁夏自治区</a></li><li><a href="//xj.zhiyuanyun.com/app/user/login.php">新疆自治区</a></li><li><a href="//bt.zhiyuanyun.com/app/user/login.php">兵团</a></li></ul></div>

<div id="map_org" style="display:none;">
    <ul><li><a href="http://www.bv2008.cn/app/org/list.php?mode=map">北京市</a></li><li><a href="http://tj.zhiyuanyun.com/app/org/list.php?mode=map">天津市</a></li><li><a href="http://he.zhiyuanyun.com/app/org/list.php?mode=map">河北省</a></li><li><a href="http://sx.zhiyuanyun.com/app/org/list.php?mode=map">山西省</a></li><li><a href="http://nm.zhiyuanyun.com/app/org/list.php?mode=map">内蒙古自治区</a></li><li><a href="http://ln.zhiyuanyun.com/app/org/list.php?mode=map">辽宁省</a></li><li><a href="http://jl.zhiyuanyun.com/app/org/list.php?mode=map">吉林省</a></li><li><a href="http://hl.zhiyuanyun.com/app/org/list.php?mode=map">黑龙江省</a></li><li><a href="http://sh.zhiyuanyun.com/app/org/list.php?mode=map">上海市</a></li><li><a href="http://js.zhiyuanyun.com/app/org/list.php?mode=map">江苏省</a></li><li><a href="http://zj.zhiyuanyun.com/app/org/list.php?mode=map">浙江省</a></li><li><a href="http://ah.zhiyuanyun.com/app/org/list.php?mode=map">安徽省</a></li><li><a href="http://fj.zhiyuanyun.com/app/org/list.php?mode=map">福建省</a></li><li><a href="http://jx.zhiyuanyun.com/app/org/list.php?mode=map">江西省</a></li><li><a href="http://sd.zhiyuanyun.com/app/org/list.php?mode=map">山东省</a></li><li><a href="http://ha.zhiyuanyun.com/app/org/list.php?mode=map">河南省</a></li><li><a href="http://hb.zhiyuanyun.com/app/org/list.php?mode=map">湖北省</a></li><li><a href="http://hn.zhiyuanyun.com/app/org/list.php?mode=map">湖南省</a></li><li><a href="http://gd.zhiyuanyun.com/app/org/list.php?mode=map">广东省</a></li><li><a href="http://gx.zhiyuanyun.com/app/org/list.php?mode=map">广西自治区</a></li><li><a href="http://hi.zhiyuanyun.com/app/org/list.php?mode=map">海南省</a></li><li><a href="http://cq.zhiyuanyun.com/app/org/list.php?mode=map">重庆市</a></li><li><a href="http://sc.zhiyuanyun.com/app/org/list.php?mode=map">四川省</a></li><li><a href="http://www.zygz.org.cn/app/org/list.php?mode=map">贵州省</a></li><li><a href="http://yn.zhiyuanyun.com/app/org/list.php?mode=map">云南省</a></li><li><a href="http://xz.zhiyuanyun.com/app/org/list.php?mode=map">西藏自治区</a></li><li><a href="http://sn.zhiyuanyun.com/app/org/list.php?mode=map">陕西省</a></li><li><a href="http://gs.zhiyuanyun.com/app/org/list.php?mode=map">甘肃省</a></li><li><a href="http://qh.zhiyuanyun.com/app/org/list.php?mode=map">青海省</a></li><li><a href="http://nx.zhiyuanyun.com/app/org/list.php?mode=map">宁夏自治区</a></li><li><a href="http://xj.zhiyuanyun.com/app/org/list.php?mode=map">新疆自治区</a></li><li><a href="http://bt.zhiyuanyun.com/app/org/list.php?mode=map">兵团</a></li></ul></div>

<div id="map_opp" style="display:none;">
    <ul><li><a href="http://www.bv2008.cn/app/opp/list.php?mode=map">北京市</a></li><li><a href="http://tj.zhiyuanyun.com/app/opp/list.php?mode=map">天津市</a></li><li><a href="http://he.zhiyuanyun.com/app/opp/list.php?mode=map">河北省</a></li><li><a href="http://sx.zhiyuanyun.com/app/opp/list.php?mode=map">山西省</a></li><li><a href="http://nm.zhiyuanyun.com/app/opp/list.php?mode=map">内蒙古自治区</a></li><li><a href="http://ln.zhiyuanyun.com/app/opp/list.php?mode=map">辽宁省</a></li><li><a href="http://jl.zhiyuanyun.com/app/opp/list.php?mode=map">吉林省</a></li><li><a href="http://hl.zhiyuanyun.com/app/opp/list.php?mode=map">黑龙江省</a></li><li><a href="http://sh.zhiyuanyun.com/app/opp/list.php?mode=map">上海市</a></li><li><a href="http://js.zhiyuanyun.com/app/opp/list.php?mode=map">江苏省</a></li><li><a href="http://zj.zhiyuanyun.com/app/opp/list.php?mode=map">浙江省</a></li><li><a href="http://ah.zhiyuanyun.com/app/opp/list.php?mode=map">安徽省</a></li><li><a href="http://fj.zhiyuanyun.com/app/opp/list.php?mode=map">福建省</a></li><li><a href="http://jx.zhiyuanyun.com/app/opp/list.php?mode=map">江西省</a></li><li><a href="http://sd.zhiyuanyun.com/app/opp/list.php?mode=map">山东省</a></li><li><a href="http://ha.zhiyuanyun.com/app/opp/list.php?mode=map">河南省</a></li><li><a href="http://hb.zhiyuanyun.com/app/opp/list.php?mode=map">湖北省</a></li><li><a href="http://hn.zhiyuanyun.com/app/opp/list.php?mode=map">湖南省</a></li><li><a href="http://gd.zhiyuanyun.com/app/opp/list.php?mode=map">广东省</a></li><li><a href="http://gx.zhiyuanyun.com/app/opp/list.php?mode=map">广西自治区</a></li><li><a href="http://hi.zhiyuanyun.com/app/opp/list.php?mode=map">海南省</a></li><li><a href="http://cq.zhiyuanyun.com/app/opp/list.php?mode=map">重庆市</a></li><li><a href="http://sc.zhiyuanyun.com/app/opp/list.php?mode=map">四川省</a></li><li><a href="http://www.zygz.org.cn/app/opp/list.php?mode=map">贵州省</a></li><li><a href="http://yn.zhiyuanyun.com/app/opp/list.php?mode=map">云南省</a></li><li><a href="http://xz.zhiyuanyun.com/app/opp/list.php?mode=map">西藏自治区</a></li><li><a href="http://sn.zhiyuanyun.com/app/opp/list.php?mode=map">陕西省</a></li><li><a href="http://gs.zhiyuanyun.com/app/opp/list.php?mode=map">甘肃省</a></li><li><a href="http://qh.zhiyuanyun.com/app/opp/list.php?mode=map">青海省</a></li><li><a href="http://nx.zhiyuanyun.com/app/opp/list.php?mode=map">宁夏自治区</a></li><li><a href="http://xj.zhiyuanyun.com/app/opp/list.php?mode=map">新疆自治区</a></li><li><a href="http://bt.zhiyuanyun.com/app/opp/list.php?mode=map">兵团</a></li></ul></div>
<div class="main">
    <ul >
        <li><a title="【党史学习教育进行时】人文学院举办“学党史感党恩 听党话 跟党走”英语秀文艺汇演" href="http://www.scitc.com.cn/info/1002/16181.htm" target="_blank">党史学习教育进行时人文学院举办“学党史感党恩 听党话 跟党</a></li>
        <li><a title="【党史学习教育进行时】软件学院党总支召开联系校领导“走基层”学生代表座谈会" href="http://www.scitc.com.cn/info/1002/16174.htm" target="_blank">党史学习教育进行时软件学院党总支召开联系校领导“走基层”</a>
        </li><li><a title="赛康学徒班开班仪式暨校企合作签约仪式在学校举行" href="http://www.scitc.com.cn/info/1002/16173.htm" target="_blank">赛康学徒班开班仪式暨校企合作签约仪式在学校举行</a>
    </li><li><a title="【党史学习教育进行时】学校庆祝中国共产党成立100周年党史知识竞赛圆满结束" href="http://www.scitc.com.cn/info/1002/16161.htm" target="_blank">党史学习教育进行时学校庆祝中国共产党成立100周年党史知识</a>
    </li><li><a title="学校开展2021年“二级学院院长说专业群（学科）竞赛”活动" href="http://www.scitc.com.cn/info/1002/16158.htm" target="_blank">学校开展2021年“二级学院院长说专业群（学科）竞赛”活动</a>
    </li><li><a title="省公安厅反恐防暴巡视组莅临学校检查指导工作" href="http://www.scitc.com.cn/info/1002/16157.htm" target="_blank">省公安厅反恐防暴巡视组莅临学校检查指导工作</a>
    </li><li><a title="【党史学习教育进行时】以党建深化校企合作  以共建促进产教融合——数字经济学院与京东西南仓储党支部举行党建共建启动仪式" href="http://www.scitc.com.cn/info/1002/16150.htm" target="_blank">党史学习教育进行时以党建深化校企合作  以共建促进产教融合</a>
    </li>
    </ul>
</div>
<div class="footer clearfix">
    <div class="wrap m10">ICP备案编号：<a href="//beian.miit.gov.cn" target="_blank">京ICP备xxxxxxxx号-x</a> 版权所有：<a href="//www.zhiyuanyun.net" target="_blank">软件19-1 2021生产实习5组</a> <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=349636607&amp;site=qq&amp;menu=yes">联系我们</a><br>
        为了达到最好效果，推荐使用 <a href="//www.microsoft.com/zh-cn/edge" target="_blank">Microsoft Edge</a>或 <a href="//www.firefox.com.cn/" target="_blank">Mozilla Firefox</a>浏览器
        <!--技术支持：<a href="//www.bv2008.cn" target="_blank">志愿北京</a> <a href="//www.zhiyuanyun.com" target="_blank">志愿云</a>-->
    </div>
</div>
</body>
</html>
