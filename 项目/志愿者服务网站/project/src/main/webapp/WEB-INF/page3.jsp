<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/6/24
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=1000">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>雷锋热线-领先全国的志愿服务信息系统版|中国志愿|志愿中国</title>
  <link rel="icon" href="<c:url value="/static/images/logo.jpg" />" type="image/x-icon">
  <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.12.4/jquery.min.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/common.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/jquery.scroll.js"></script>
  <script type="text/javascript" src="https://css.zhiyuanyun.com/lib/nbspslider/jquery.nbspslider.1.1.js"></script>
  <link href="https://css.zhiyuanyun.com/lib/nbspslider/css/css.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript">
    $(document).ready(function(){
      //$("#news_photo").nbspSlider({widths:'500px',heights:'300px',numBtnSty:"roundness",altAlign:"left",numBtnShow:1,speeds:500,delays:4000,preNexBtnShow:0,altShow:1,altBgColor:"#000",altHeight:"45px"});
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
    <a href="<c:url value="/page2" />">川信志愿者</a>
    <a href="<c:url value="/page3" />" class="sel">雷锋热线</a>
    <a href="<c:url value="/page4" />">公益广告</a>
    <a href="<c:url value="/management/login" />">管理员登录</a>
  </div>
</div>
<style>
  #reg_province_vol ul,#reg_province_org ul,#reg_province_login ul,#map_org ul,#map_opp ul{width:100%;margin:10px;}
  #reg_province_vol ul li,#reg_province_org ul li,#reg_province_login ul li,#map_org ul li,#map_opp ul li{float:left;width:20%;text-align:center;line-height:200%;}
  body {
    background: url(${page3bk});
    background-size: cover;
    position: relative;
  }
  .footer {
    position: absolute;
    bottom: -150px;
    left: 0;
    right: 0;
  }
</style>

<div style="margin: 0 auto;width: 1000px;height: 700px; margin-top: 10px;">
  <iframe src="http://player.bilibili.com/player.html?aid=670193328&bvid=BV1ia4y1s7gy&cid=254178196&page=1" allowfullscreen="allowfullscreen" width="100%" height="100%" scrolling="no" frameborder="0" sandbox="allow-top-navigation allow-same-origin allow-forms allow-scripts"></iframe>
</div>

<div class="wrap clearfix m10">
  <div class="l clearfix">
    <div class="tbox8" style="width:485px;overflow:hidden;">
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
    <div class="tbox8" style="width:485px;height:314px;overflow:hidden;">
      <div class="tit clearfix"><span class="l" id="lm3_1"><a href="https://www.zhiyuanyun.com/cate/zyzg_tzgg/" target="_blank">项目介绍</a></span><!--<span id="lm3_2">调查征集</span>--></div>
      <div class="tcon" style="height:268px;padding: 10px 10px;" id="lm3_tab1">
        <p style="line-height: 20px;">
          雷锋热线是由成都晚报社打造的媒体融合产品品牌。
          成立于2015年，以“媒体+互联网+志愿公益”的模式立足推动实现“所有人帮所有人”的社会氛围。
          成都晚报雷锋热线在开设报纸专版及热线电话的基础上，推出互联网新媒体矩阵，
          包括微博、微信、多个线上社群、视频直播等产品，形成线上、线下系统化矩阵，实现志愿公益信息的传播。
          雷锋热线是由成都晚报社发起的全民共享友善公益平台，成立于2015年，以“媒体+互联网+友善公益”的思路立足推动实现“所有人帮所有人”的社会氛围。
          雷锋热线旨在实现志愿公益信息和公益供需的对接。成都晚报雷锋热线报纸专栏包括精品项目、热线帮扶、心愿清单及雷锋热线应答墙等特色板块。
          雷锋热线将志愿者、公益组织、爱心企业等组建成雷锋热线爱心联盟，为公益供需双方牵线搭桥。遇到困难，市民只需拨打雷锋热线或通过新媒体互动平台留言，
          发布求助心愿。成都晚报雷锋热线记者会根据实际情况，寻找爱心联盟中符合条件的志愿者或相关组织给予帮助或回馈。
        </p>
      </div>
    </div>
  </div>
</div>

<div style="background-color: white; width:1000px;margin: 0 auto; margin-top: 10px;">
  <h4 style="margin-left: 10px; font-weight: bold;">品牌活动：</h4>
  <div class="clearfix" style="margin-bottom: 15px;">
    <div style="float: left;">
      <p style="font-size: 20px;">“+5℃计划”为上千名困难群众增温：</p>
      <img src="https://img.jcxiaozhan.top/Mybatis%E6%96%87%E7%AB%A0%E5%9B%BE%E6%A0%87.jpg" style="width:200px;height:200px;margin-left: 20px;"/>
    </div>
    <div style="float: left;width: 600px;margin-top: 25px;">
      <p style="line-height: 20px;">
        该区域的志愿者负责人李强告诉记者，这次的“+5℃计划”他们在年前就已经开始计划了，
        “1月底活动信息刚发出来后，就有50多人报名，后来陆续又有80多人加入。”李强说，因为人数过多，
        他们便将活动开展的点位由原先的3个扩展为温江区的文庙、碧落湖、永宁、天府、渣子沟、南浦郡、国色天乡、天府家园8个人流量较大的点位，
        “每个点位都有专门的组长，统一发放炊具、炉具、餐具、粽子、桶装水，以及爱心礼包等物资。
        据了解，在温江区开展“+5℃计划”的同时，在崇州，也有38名志愿者在当地的文庙广场和万达广场开展增温活动。
        累计为上千名困难群众送去新春的温暖祝福。此外，
        雷锋热线爱心联盟成员单位四川益路同行慈善服务中心的多名志愿者还在春节期间前往了凉山布拖县阿布泽鲁小学，
        特别看望了该校的26名特困学生。“除了给孩子们送去新春礼物，我们还为学校带去了爱心人士捐赠的550床棉被。”志愿者肖建军说。
      </p>
    </div>
  </div>
  <hr/>
  <div class="clearfix" style="padding: 15px;">
    <div style="float: left;">
      <p style="font-size: 20px;">“+5℃计划”为上千名困难群众增温：</p>
      <img src="https://img.jcxiaozhan.top/Mybatis%E6%96%87%E7%AB%A0%E5%9B%BE%E6%A0%87.jpg" style="width:200px;height:200px;margin-left: 20px;"/>
    </div>
    <div style="float: left;width: 600px;margin-top: 25px;">
      <p style="line-height: 20px;">
        该区域的志愿者负责人李强告诉记者，这次的“+5℃计划”他们在年前就已经开始计划了，
        “1月底活动信息刚发出来后，就有50多人报名，后来陆续又有80多人加入。”李强说，因为人数过多，
        他们便将活动开展的点位由原先的3个扩展为温江区的文庙、碧落湖、永宁、天府、渣子沟、南浦郡、国色天乡、天府家园8个人流量较大的点位，
        “每个点位都有专门的组长，统一发放炊具、炉具、餐具、粽子、桶装水，以及爱心礼包等物资。
        据了解，在温江区开展“+5℃计划”的同时，在崇州，也有38名志愿者在当地的文庙广场和万达广场开展增温活动。
        累计为上千名困难群众送去新春的温暖祝福。此外，
        雷锋热线爱心联盟成员单位四川益路同行慈善服务中心的多名志愿者还在春节期间前往了凉山布拖县阿布泽鲁小学，
        特别看望了该校的26名特困学生。“除了给孩子们送去新春礼物，我们还为学校带去了爱心人士捐赠的550床棉被。”志愿者肖建军说。
      </p>
    </div>
  </div>
</div>

<link href="https://css.zhiyuanyun.com/chinavol/cnmap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/echarts/4.8.0/echarts.js"></script>
<script type="text/javascript" src="https://css.zhiyuanyun.com/chinavol/js/china.js"></script>
<!-- <script type="text/javascript" src="https://css.zhiyuanyun.com/chinavol/js/cnmap.js"></script> -->

<div class="footer clearfix">
  <div class="wrap m10">ICP备案编号：<a href="//beian.miit.gov.cn" target="_blank">京ICP备xxxxxxxx号-x</a> 版权所有：<a href="//www.zhiyuanyun.net" target="_blank">软件19-1 2021生产实习5组</a> <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=349636607&amp;site=qq&amp;menu=yes">联系我们</a><br>
    为了达到最好效果，推荐使用 <a href="//www.microsoft.com/zh-cn/edge" target="_blank">Microsoft Edge</a>或 <a href="//www.firefox.com.cn/" target="_blank">Mozilla Firefox</a>浏览器
    <!--技术支持：<a href="//www.bv2008.cn" target="_blank">志愿北京</a> <a href="//www.zhiyuanyun.com" target="_blank">志愿云</a>-->
  </div>
</div>
</body>
</html>
