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
  <meta name="viewport" content="width=1000">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>川信志愿者-领先全国的志愿服务信息系统版|中国志愿|志愿中国</title>
  <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
  <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.12.4/jquery.min.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/common.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/jquery.scroll.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/nbspslider/jquery.nbspslider.1.1.js"></script>
  <link href="https://css.zhiyuanyun.com/lib/nbspslider/css/css.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript">
    $(document).ready(function(){
      $("#news_photo").nbspSlider({widths:'500px',heights:'300px',numBtnSty:"roundness",altAlign:"left",numBtnShow:1,speeds:500,delays:4000,preNexBtnShow:0,altShow:1,altBgColor:"#000",altHeight:"45px"});
      //$('#index_ad_right').kxbdSuperMarquee({isEqual:false,distance:120,time:3,btnGo:{ left:'#index_ad_right_inner'},direction:'left'});
      $('#index_photo1').kxbdSuperMarquee({isEqual:false,distance:186,time:3,btnGo:{ left:'.aleft',right:'.aright'},direction:'left'});
      $('#index_photo2').kxbdSuperMarquee({isEqual:false,distance:186,time:3,btnGo:{ left:'.aleft',right:'.aright'},direction:'left'});
      $('#index_photo3').kxbdSuperMarquee({isEqual:false,distance:186,time:3,btnGo:{ left:'.aleft',right:'.aright'},direction:'left'});
      $('#index_photo4').kxbdSuperMarquee({isEqual:false,distance:186,time:3,btnGo:{ left:'.aleft',right:'.aright'},direction:'left'});
    });
    $(function(){
      C.tabs({"params":[
          {"nav":"#btn1","con":"#tab1","sclass":"current","nclass":""},
          {"nav":"#btn2","con":"#tab2","sclass":"current","nclass":""},
          {"nav":"#btn3","con":"#tab3","sclass":"current","nclass":""}
        ]
      });
      C.tabs({"event":"mouseover","params":[
          {"nav":"#tj_tab1","con":"#tj_con1","sclass":"cur","nclass":"ns1"},
          {"nav":"#tj_tab2","con":"#tj_con2","sclass":"cur","nclass":"ns2"},
        ]
      });



      C.tabs({"event":"mouseover","params":[
          {"nav":"#lm1_1","con":"#lm1_tab1","sclass":"l","nclass":""},
          {"nav":"#lm1_2","con":"#lm1_tab2","sclass":"l","nclass":""}
        ]
      });

      C.tabs({"event":"mouseover","params":[
          {"nav":"#lm2_1","con":"#lm2_tab1","sclass":"l","nclass":""},
          {"nav":"#lm2_2","con":"#lm2_tab2","sclass":"l","nclass":""}
        ]
      });

      C.tabs({"event":"mouseover","params":[
          {"nav":"#lm3_1","con":"#lm3_tab1","sclass":"l","nclass":""},
          {"nav":"#lm3_2","con":"#lm3_tab2","sclass":"l","nclass":""}
        ]
      });

      C.tabs({"event":"mouseover","params":[
          {"nav":"#lm4_1","con":"#lm4_tab1","sclass":"l","nclass":""},
          {"nav":"#lm4_2","con":"#lm4_tab2","sclass":"l","nclass":""},
          {"nav":"#lm4_3","con":"#lm4_tab3","sclass":"l","nclass":""},
          {"nav":"#lm4_4","con":"#lm4_tab4","sclass":"l","nclass":""}
        ]
      });

      $('.menu_div').css('left',($(document).width()-1004)/2+'px');
      $('.menu').mouseover(function(){
        $('#'+$(this).attr('id')+'_div').css('display','block').unbind().bind('mouseover',function(){
          $(this).css('display','block');
        });
      });
      $('.nav').mouseout(function(){
        $('.menu_div').css('display','none');
      });

    });
    function show_area(area){
      $('#map').attr('src','//css.zhiyuanyun.com/zyzg.zyy/map/'+decodeURIComponent(area)+'.png');
      $('.area_list').each(function(){
        $(this).css('display','none');
        var area_txt=$(this).attr('area');//alert(area_txt);alert(typeof(area_txt));
        if(area_txt.indexOf(area)>=0){
          $(this).css('display','block').find('.tit').html(area+'志愿服务数据统计');
        }
      });
      var has=0;
      $('.area_list').each(function(){
        if($(this).css('display')=='block') has++;
      });
      if(has==0) $('#nodata').css('display','block').find('.tit').html(area+'志愿服务数据统计');
    }
    function show_area_all(){
      $('.area_list').css('display','none');
      $('#all').css('display','block');
    }
  </script>

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
    <a href="<c:url value="/page1" />">文明川信</a>
    <a href="<c:url value="/page2" />" class="sel">川信志愿者</a>
    <a href="<c:url value="/page3" />">雷锋热线</a>
    <a href="<c:url value="/page4" />">公益广告</a>
    <a href="<c:url value="/manager/login" />">管理员登录</a>
  </div>
</div>
<style>
  #reg_province_vol ul,#reg_province_org ul,#reg_province_login ul,#map_org ul,#map_opp ul{width:100%;margin:10px;}
  #reg_province_vol ul li,#reg_province_org ul li,#reg_province_login ul li,#map_org ul li,#map_opp ul li{float:left;width:20%;text-align:center;line-height:200%;}
  body {
    background: url(${page2bk});
    background-size: cover;
  }
</style>
<div id="reg_province_vol" style="display:none;">
  <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="https://npo.zhiyuanyun.com/app/user/register.php">全国性社会组织</a></li><li><a href="https://www.bv2008.cn/app/user/register.php">北京市</a></li><li><a href="https://tj.zhiyuanyun.com/app/user/register.php">天津市</a></li><li><a href="https://he.zhiyuanyun.com/app/user/register.php">河北省</a></li><li><a href="https://sx.zhiyuanyun.com/app/user/register.php">山西省</a></li><li><a href="https://nm.zhiyuanyun.com/app/user/register.php">内蒙古自治区</a></li><li><a href="https://ln.zhiyuanyun.com/app/user/register.php">辽宁省</a></li><li><a href="https://jl.zhiyuanyun.com/app/user/register.php">吉林省</a></li><li><a href="https://hl.zhiyuanyun.com/app/user/register.php">黑龙江省</a></li><li><a href="https://sh.zhiyuanyun.com/app/user/register.php">上海市</a></li><li><a href="https://js.zhiyuanyun.com/app/user/register.php">江苏省</a></li><li><a href="https://zj.zhiyuanyun.com/app/user/register.php">浙江省</a></li><li><a href="https://ah.zhiyuanyun.com/app/user/register.php">安徽省</a></li><li><a href="https://fj.zhiyuanyun.com/app/user/register.php">福建省</a></li><li><a href="https://jx.zhiyuanyun.com/app/user/register.php">江西省</a></li><li><a href="https://sd.zhiyuanyun.com/app/user/register.php">山东省</a></li><li><a href="https://ha.zhiyuanyun.com/app/user/register.php">河南省</a></li><li><a href="https://hb.zhiyuanyun.com/app/user/register.php">湖北省</a></li><li><a href="https://hn.zhiyuanyun.com/app/user/register.php">湖南省</a></li><li><a href="https://gd.zhiyuanyun.com/app/user/register.php">广东省</a></li><li><a href="https://gx.zhiyuanyun.com/app/user/register.php">广西自治区</a></li><li><a href="https://hi.zhiyuanyun.com/app/user/register.php">海南省</a></li><li><a href="https://cq.zhiyuanyun.com/app/user/register.php">重庆市</a></li><li><a href="https://sc.zhiyuanyun.com/app/user/register.php">四川省</a></li><li><a href="https://www.zygz.org.cn/app/user/register.php">贵州省</a></li><li><a href="https://yn.zhiyuanyun.com/app/user/register.php">云南省</a></li><li><a href="https://xz.zhiyuanyun.com/app/user/register.php">西藏自治区</a></li><li><a href="https://sn.zhiyuanyun.com/app/user/register.php">陕西省</a></li><li><a href="https://gs.zhiyuanyun.com/app/user/register.php">甘肃省</a></li><li><a href="https://qh.zhiyuanyun.com/app/user/register.php">青海省</a></li><li><a href="https://nx.zhiyuanyun.com/app/user/register.php">宁夏自治区</a></li><li><a href="https://xj.zhiyuanyun.com/app/user/register.php">新疆自治区</a></li><li><a href="https://bt.zhiyuanyun.com/app/user/register.php">兵团</a></li></ul></div>

<div id="reg_province_org" style="display:none;">
  <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="https://npo.zhiyuanyun.com/app/user/register.php?type=org">全国性社会组织</a></li><li><a href="https://www.bv2008.cn/app/user/register.php?type=org">北京市</a></li><li><a href="https://tj.zhiyuanyun.com/app/user/register.php?type=org">天津市</a></li><li><a href="https://he.zhiyuanyun.com/app/user/register.php?type=org">河北省</a></li><li><a href="https://sx.zhiyuanyun.com/app/user/register.php?type=org">山西省</a></li><li><a href="https://nm.zhiyuanyun.com/app/user/register.php?type=org">内蒙古自治区</a></li><li><a href="https://ln.zhiyuanyun.com/app/user/register.php?type=org">辽宁省</a></li><li><a href="https://jl.zhiyuanyun.com/app/user/register.php?type=org">吉林省</a></li><li><a href="https://hl.zhiyuanyun.com/app/user/register.php?type=org">黑龙江省</a></li><li><a href="https://sh.zhiyuanyun.com/app/user/register.php?type=org">上海市</a></li><li><a href="https://js.zhiyuanyun.com/app/user/register.php?type=org">江苏省</a></li><li><a href="https://zj.zhiyuanyun.com/app/user/register.php?type=org">浙江省</a></li><li><a href="https://ah.zhiyuanyun.com/app/user/register.php?type=org">安徽省</a></li><li><a href="https://fj.zhiyuanyun.com/app/user/register.php?type=org">福建省</a></li><li><a href="https://jx.zhiyuanyun.com/app/user/register.php?type=org">江西省</a></li><li><a href="https://sd.zhiyuanyun.com/app/user/register.php?type=org">山东省</a></li><li><a href="https://ha.zhiyuanyun.com/app/user/register.php?type=org">河南省</a></li><li><a href="https://hb.zhiyuanyun.com/app/user/register.php?type=org">湖北省</a></li><li><a href="https://hn.zhiyuanyun.com/app/user/register.php?type=org">湖南省</a></li><li><a href="https://gd.zhiyuanyun.com/app/user/register.php?type=org">广东省</a></li><li><a href="https://gx.zhiyuanyun.com/app/user/register.php?type=org">广西自治区</a></li><li><a href="https://hi.zhiyuanyun.com/app/user/register.php?type=org">海南省</a></li><li><a href="https://cq.zhiyuanyun.com/app/user/register.php?type=org">重庆市</a></li><li><a href="https://sc.zhiyuanyun.com/app/user/register.php?type=org">四川省</a></li><li><a href="https://www.zygz.org.cn/app/user/register.php?type=org">贵州省</a></li><li><a href="https://yn.zhiyuanyun.com/app/user/register.php?type=org">云南省</a></li><li><a href="https://xz.zhiyuanyun.com/app/user/register.php?type=org">西藏自治区</a></li><li><a href="https://sn.zhiyuanyun.com/app/user/register.php?type=org">陕西省</a></li><li><a href="https://gs.zhiyuanyun.com/app/user/register.php?type=org">甘肃省</a></li><li><a href="https://qh.zhiyuanyun.com/app/user/register.php?type=org">青海省</a></li><li><a href="https://nx.zhiyuanyun.com/app/user/register.php?type=org">宁夏自治区</a></li><li><a href="https://xj.zhiyuanyun.com/app/user/register.php?type=org">新疆自治区</a></li><li><a href="https://bt.zhiyuanyun.com/app/user/register.php?type=org">兵团</a></li></ul></div>

<div id="reg_province_login" style="display:none;">
  <ul><li style="width:96%;border-bottom:1px solid #eee;text-align:left;"><a href="https://npo.zhiyuanyun.com/app/user/login.php">全国性社会组织</a></li><li><a href="https://www.bv2008.cn/app/user/login.php">北京市</a></li><li><a href="https://tj.zhiyuanyun.com/app/user/login.php">天津市</a></li><li><a href="https://he.zhiyuanyun.com/app/user/login.php">河北省</a></li><li><a href="https://sx.zhiyuanyun.com/app/user/login.php">山西省</a></li><li><a href="https://nm.zhiyuanyun.com/app/user/login.php">内蒙古自治区</a></li><li><a href="https://ln.zhiyuanyun.com/app/user/login.php">辽宁省</a></li><li><a href="https://jl.zhiyuanyun.com/app/user/login.php">吉林省</a></li><li><a href="https://hl.zhiyuanyun.com/app/user/login.php">黑龙江省</a></li><li><a href="https://sh.zhiyuanyun.com/app/user/login.php">上海市</a></li><li><a href="https://js.zhiyuanyun.com/app/user/login.php">江苏省</a></li><li><a href="https://zj.zhiyuanyun.com/app/user/login.php">浙江省</a></li><li><a href="https://ah.zhiyuanyun.com/app/user/login.php">安徽省</a></li><li><a href="https://fj.zhiyuanyun.com/app/user/login.php">福建省</a></li><li><a href="https://jx.zhiyuanyun.com/app/user/login.php">江西省</a></li><li><a href="https://sd.zhiyuanyun.com/app/user/login.php">山东省</a></li><li><a href="https://ha.zhiyuanyun.com/app/user/login.php">河南省</a></li><li><a href="https://hb.zhiyuanyun.com/app/user/login.php">湖北省</a></li><li><a href="https://hn.zhiyuanyun.com/app/user/login.php">湖南省</a></li><li><a href="https://gd.zhiyuanyun.com/app/user/login.php">广东省</a></li><li><a href="https://gx.zhiyuanyun.com/app/user/login.php">广西自治区</a></li><li><a href="https://hi.zhiyuanyun.com/app/user/login.php">海南省</a></li><li><a href="https://cq.zhiyuanyun.com/app/user/login.php">重庆市</a></li><li><a href="https://sc.zhiyuanyun.com/app/user/login.php">四川省</a></li><li><a href="https://www.zygz.org.cn/app/user/login.php">贵州省</a></li><li><a href="https://yn.zhiyuanyun.com/app/user/login.php">云南省</a></li><li><a href="https://xz.zhiyuanyun.com/app/user/login.php">西藏自治区</a></li><li><a href="https://sn.zhiyuanyun.com/app/user/login.php">陕西省</a></li><li><a href="https://gs.zhiyuanyun.com/app/user/login.php">甘肃省</a></li><li><a href="https://qh.zhiyuanyun.com/app/user/login.php">青海省</a></li><li><a href="https://nx.zhiyuanyun.com/app/user/login.php">宁夏自治区</a></li><li><a href="https://xj.zhiyuanyun.com/app/user/login.php">新疆自治区</a></li><li><a href="https://bt.zhiyuanyun.com/app/user/login.php">兵团</a></li></ul></div>

<div id="map_org" style="display:none;">
  <ul><li><a href="http://www.bv2008.cn/app/org/list.php?mode=map">北京市</a></li><li><a href="http://tj.zhiyuanyun.com/app/org/list.php?mode=map">天津市</a></li><li><a href="http://he.zhiyuanyun.com/app/org/list.php?mode=map">河北省</a></li><li><a href="http://sx.zhiyuanyun.com/app/org/list.php?mode=map">山西省</a></li><li><a href="http://nm.zhiyuanyun.com/app/org/list.php?mode=map">内蒙古自治区</a></li><li><a href="http://ln.zhiyuanyun.com/app/org/list.php?mode=map">辽宁省</a></li><li><a href="http://jl.zhiyuanyun.com/app/org/list.php?mode=map">吉林省</a></li><li><a href="http://hl.zhiyuanyun.com/app/org/list.php?mode=map">黑龙江省</a></li><li><a href="http://sh.zhiyuanyun.com/app/org/list.php?mode=map">上海市</a></li><li><a href="http://js.zhiyuanyun.com/app/org/list.php?mode=map">江苏省</a></li><li><a href="http://zj.zhiyuanyun.com/app/org/list.php?mode=map">浙江省</a></li><li><a href="http://ah.zhiyuanyun.com/app/org/list.php?mode=map">安徽省</a></li><li><a href="http://fj.zhiyuanyun.com/app/org/list.php?mode=map">福建省</a></li><li><a href="http://jx.zhiyuanyun.com/app/org/list.php?mode=map">江西省</a></li><li><a href="http://sd.zhiyuanyun.com/app/org/list.php?mode=map">山东省</a></li><li><a href="http://ha.zhiyuanyun.com/app/org/list.php?mode=map">河南省</a></li><li><a href="http://hb.zhiyuanyun.com/app/org/list.php?mode=map">湖北省</a></li><li><a href="http://hn.zhiyuanyun.com/app/org/list.php?mode=map">湖南省</a></li><li><a href="http://gd.zhiyuanyun.com/app/org/list.php?mode=map">广东省</a></li><li><a href="http://gx.zhiyuanyun.com/app/org/list.php?mode=map">广西自治区</a></li><li><a href="http://hi.zhiyuanyun.com/app/org/list.php?mode=map">海南省</a></li><li><a href="http://cq.zhiyuanyun.com/app/org/list.php?mode=map">重庆市</a></li><li><a href="http://sc.zhiyuanyun.com/app/org/list.php?mode=map">四川省</a></li><li><a href="http://www.zygz.org.cn/app/org/list.php?mode=map">贵州省</a></li><li><a href="http://yn.zhiyuanyun.com/app/org/list.php?mode=map">云南省</a></li><li><a href="http://xz.zhiyuanyun.com/app/org/list.php?mode=map">西藏自治区</a></li><li><a href="http://sn.zhiyuanyun.com/app/org/list.php?mode=map">陕西省</a></li><li><a href="http://gs.zhiyuanyun.com/app/org/list.php?mode=map">甘肃省</a></li><li><a href="http://qh.zhiyuanyun.com/app/org/list.php?mode=map">青海省</a></li><li><a href="http://nx.zhiyuanyun.com/app/org/list.php?mode=map">宁夏自治区</a></li><li><a href="http://xj.zhiyuanyun.com/app/org/list.php?mode=map">新疆自治区</a></li><li><a href="http://bt.zhiyuanyun.com/app/org/list.php?mode=map">兵团</a></li></ul></div>

<div id="map_opp" style="display:none;">
  <ul><li><a href="http://www.bv2008.cn/app/opp/list.php?mode=map">北京市</a></li><li><a href="http://tj.zhiyuanyun.com/app/opp/list.php?mode=map">天津市</a></li><li><a href="http://he.zhiyuanyun.com/app/opp/list.php?mode=map">河北省</a></li><li><a href="http://sx.zhiyuanyun.com/app/opp/list.php?mode=map">山西省</a></li><li><a href="http://nm.zhiyuanyun.com/app/opp/list.php?mode=map">内蒙古自治区</a></li><li><a href="http://ln.zhiyuanyun.com/app/opp/list.php?mode=map">辽宁省</a></li><li><a href="http://jl.zhiyuanyun.com/app/opp/list.php?mode=map">吉林省</a></li><li><a href="http://hl.zhiyuanyun.com/app/opp/list.php?mode=map">黑龙江省</a></li><li><a href="http://sh.zhiyuanyun.com/app/opp/list.php?mode=map">上海市</a></li><li><a href="http://js.zhiyuanyun.com/app/opp/list.php?mode=map">江苏省</a></li><li><a href="http://zj.zhiyuanyun.com/app/opp/list.php?mode=map">浙江省</a></li><li><a href="http://ah.zhiyuanyun.com/app/opp/list.php?mode=map">安徽省</a></li><li><a href="http://fj.zhiyuanyun.com/app/opp/list.php?mode=map">福建省</a></li><li><a href="http://jx.zhiyuanyun.com/app/opp/list.php?mode=map">江西省</a></li><li><a href="http://sd.zhiyuanyun.com/app/opp/list.php?mode=map">山东省</a></li><li><a href="http://ha.zhiyuanyun.com/app/opp/list.php?mode=map">河南省</a></li><li><a href="http://hb.zhiyuanyun.com/app/opp/list.php?mode=map">湖北省</a></li><li><a href="http://hn.zhiyuanyun.com/app/opp/list.php?mode=map">湖南省</a></li><li><a href="http://gd.zhiyuanyun.com/app/opp/list.php?mode=map">广东省</a></li><li><a href="http://gx.zhiyuanyun.com/app/opp/list.php?mode=map">广西自治区</a></li><li><a href="http://hi.zhiyuanyun.com/app/opp/list.php?mode=map">海南省</a></li><li><a href="http://cq.zhiyuanyun.com/app/opp/list.php?mode=map">重庆市</a></li><li><a href="http://sc.zhiyuanyun.com/app/opp/list.php?mode=map">四川省</a></li><li><a href="http://www.zygz.org.cn/app/opp/list.php?mode=map">贵州省</a></li><li><a href="http://yn.zhiyuanyun.com/app/opp/list.php?mode=map">云南省</a></li><li><a href="http://xz.zhiyuanyun.com/app/opp/list.php?mode=map">西藏自治区</a></li><li><a href="http://sn.zhiyuanyun.com/app/opp/list.php?mode=map">陕西省</a></li><li><a href="http://gs.zhiyuanyun.com/app/opp/list.php?mode=map">甘肃省</a></li><li><a href="http://qh.zhiyuanyun.com/app/opp/list.php?mode=map">青海省</a></li><li><a href="http://nx.zhiyuanyun.com/app/opp/list.php?mode=map">宁夏自治区</a></li><li><a href="http://xj.zhiyuanyun.com/app/opp/list.php?mode=map">新疆自治区</a></li><li><a href="http://bt.zhiyuanyun.com/app/opp/list.php?mode=map">兵团</a></li></ul></div><style>
  .tbox .tit span.l{padding:0;}
</style>
<!--<div class="topword wrap">
</div>-->
<div class="wrap clearfix m10">
  <div class="l news_photo">
    <video width="500" height="300" controls="">
      <video width="320" height="240" controls="">
        <source src="./vedio.mp4" type="video/mp4">
      </video>
    </video>
  </div>
  <div class="r clearfix">
    <div class="tbox8" style="width:488px;height:300px;overflow:hidden;">
      <div class="tit clearfix"><span class="l" id="lm1_1"><a href="https://www.zhiyuanyun.com/cate/zyzg_xxdt/" target="_blank">项目介绍</a></span><!--<span id="lm1_2">地方动态</span>--></div>
      <div class="tcon" style="height:268px;" id="lm1_tab1">

      </div>
    </div>
  </div>
</div>


<div class="wrap clearfix m10">
  <div class="l clearfix">
    <div class="tbox8" style="width:495px;height:305px;overflow:hidden;">
      <div class="tit clearfix"><span class="l" id="lm2_1"><a href="https://www.zhiyuanyun.com/cate/zyzg_mtbd/" target="_blank">新闻专栏</a></span></div>
      <div class="tcon" style="height:268px;" id="lm2_tab1">
        <ul>
          <li><a href="https://www.zhiyuanyun.com/show/1070319.html" title="三峡日报：居民们线上点单 志愿者抢单服务" target="_blank">三峡日报：居民们线上点单 志愿者抢单服务</a><span>2021-06-18</span></li><li><a href="https://www.zhiyuanyun.com/show/1070324.html" title="工人日报：志愿服务让城市更有温度" target="_blank">工人日报：志愿服务让城市更有温度</a><span>2021-06-17</span></li><li><a href="https://www.zhiyuanyun.com/show/1070323.html" title="贵阳日报：凝聚志愿服务力量 构建税收共治新格局" target="_blank">贵阳日报：凝聚志愿服务力量 构建税收共治新格局</a><span>2021-06-17</span></li><li><a href="https://www.zhiyuanyun.com/show/1070194.html" title="瑞安日报：践行志愿精神 传承人间大爱" target="_blank">瑞安日报：践行志愿精神 传承人间大爱</a><span>2021-06-15</span></li><li><a href="https://www.zhiyuanyun.com/show/1070195.html" title="齐鲁晚报：推进志愿服务专业化，引领文明实践新风尚" target="_blank">齐鲁晚报：推进志愿服务专业化，引领文明实践新风尚</a><span>2021-06-12</span></li><li><a href="https://www.zhiyuanyun.com/show/1070085.html" title="乌鲁木齐晚报：42个高考服务站千余志愿者助力高考" target="_blank">乌鲁木齐晚报：42个高考服务站千余志愿者助力高考</a><span>2021-06-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1070089.html" title="中新网：南宁市青年志愿者踊跃投身公益活动 爱心助力高考" target="_blank">中新网：南宁市青年志愿者踊跃投身公益活动 爱心助力高考</a><span>2021-06-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1070083.html" title="人民日报：北京冬奥会赛会志愿者报名人数超百万 为冬奥筹办贡献力量" target="_blank">人民日报：北京冬奥会赛会志愿者报名人数超百万 为冬奥筹办贡献力量</a><span>2021-06-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1070046.html" title="广州日报：近六千名志愿者增援检测" target="_blank">广州日报：近六千名志愿者增援检测</a><span>2021-06-07</span></li>                </ul>
      </div>
      <div class="tcon" style="height:268px;" id="lm2_tab2">
        <ul>
          <li><a href="https://www.zhiyuanyun.com/show/1070321.html" title="张强：释放志愿服务新活力 构建现代生态环境治理体系" target="_blank">张强：释放志愿服务新活力 构建现代生态环境治理体系</a><span>2021-06-16</span></li><li><a href="https://www.zhiyuanyun.com/show/1069332.html" title="谭建光：志愿服务项目书填写的十个要素" target="_blank">谭建光：志愿服务项目书填写的十个要素</a><span>2021-05-05</span></li><li><a href="https://www.zhiyuanyun.com/show/1066496.html" title="《志愿服务记录与证明出具办法（试行）》解读问答" target="_blank">《志愿服务记录与证明出具办法（试行）》解读问答</a><span>2020-12-25</span></li><li><a href="https://www.zhiyuanyun.com/show/1066495.html" title="志愿服务记录与证明出具办法（试行）" target="_blank">志愿服务记录与证明出具办法（试行）</a><span>2020-12-25</span></li><li><a href="https://www.zhiyuanyun.com/show/1038643.html" title="陆士桢：发展中国特色志愿服务，促进社会文明进步" target="_blank">陆士桢：发展中国特色志愿服务，促进社会文明进步</a><span>2017-09-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1038642.html" title="肖金明：《志愿服务条例》的立法创新与多重效应" target="_blank">肖金明：《志愿服务条例》的立法创新与多重效应</a><span>2017-09-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1038641.html" title="党秀云：为志愿服务保驾护航" target="_blank">党秀云：为志愿服务保驾护航</a><span>2017-09-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1038640.html" title="李芳：准确把握《志愿服务条例》的立法重点" target="_blank">李芳：准确把握《志愿服务条例》的立法重点</a><span>2017-09-08</span></li><li><a href="https://www.zhiyuanyun.com/show/1038639.html" title="谭建光：强化志愿服务激励 促进诚信社会建设" target="_blank">谭建光：强化志愿服务激励 促进诚信社会建设</a><span>2017-09-08</span></li>                </ul>
      </div>
    </div>
  </div>
  <div class="r clearfix">
    <div class="tbox8" style="width:495px;height:305px;overflow:hidden;">
      <div class="tit clearfix"><span class="l" id="lm3_1"><a href="https://www.zhiyuanyun.com/cate/zyzg_tzgg/" target="_blank">专题活动</a></span><!--<span id="lm3_2">调查征集</span>--></div>
      <div class="tcon" style="height:268px;" id="lm3_tab1">

      </div>
    </div>
  </div>
</div>

<link href="https://css.zhiyuanyun.com/chinavol/cnmap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/echarts/4.8.0/echarts.js"></script>
<script type="text/javascript" src="https://css.zhiyuanyun.com/chinavol/js/china.js"></script>
<!-- <script type="text/javascript" src="https://css.zhiyuanyun.com/chinavol/js/cnmap.js"></script> -->



<div class="footer clearfix">
  <div class="wrap m10">ICP备案编号：<a href="https://beian.miit.gov.cn" target="_blank">京ICP备13002525号-7</a> 版权所有：<a href="https://www.zhiyuanyun.net" target="_blank">志愿云运维团队</a> <a href="https://www.zhiyuanyun.com/show/1040107.html">联系我们</a><br>
    为了达到最好效果，推荐使用 <a href="https://www.microsoft.com/zh-cn/edge" target="_blank">Microsoft Edge</a>或 <a href="https://www.firefox.com.cn/" target="_blank">Mozilla Firefox</a>浏览器
    <!--技术支持：<a href="https://www.bv2008.cn" target="_blank">志愿北京</a> <a href="https://www.zhiyuanyun.com" target="_blank">志愿云</a>-->
  </div>
</div>
<link href="https://css.zhiyuanyun.com/default/kf.css" rel="stylesheet" type="text/css">
<style type="text/css">
  .kf_menu .kf-btn-mz{background:url(http://css.zhiyuanyun.com/default/img/r_mz1.png) 0px 0px no-repeat;background-color:#c54033;color:#fff;}
  .kf_menu .kf-btn-mz:hover{background:url(http://css.zhiyuanyun.com/default/img/r_mz.png) 0px 0px no-repeat;background-color:#f1f1f1 !important;color:#c54033;}
  .kf_menu a.kf-btn-mz,a.kf-btn-cz:visited{background:url(http://css.zhiyuanyun.com/default/img/r_mz1.png) 0px 0px no-repeat;background-color:#c54033;text-decoration:none;display:block;}
</style>
<div id="kf_top"></div>
</body>
</html>