<%@page import="action.OzqAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta name="author" content="Kei" />
<meta name="Copyright" content="Kei" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link href="css/global.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.lazyload.1.8.4.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
    $("img").lazyload({
        effect: "fadeIn"
    });
});
</script>
</head>

<body>
<div class="wrap clearfix" id="wrap">
<div class="nav" id="nav">
    <div class="top clearfix w960 center relative">
        <div class="city fl"><a href="javascript:void(0);">
            <span class="citynow fs16">&gt;东莞</span>
            <span class="citychange fs12">切换城市</span>
        </a></div>
        <div class="citylist absolute">
            <ul class="clearfix">
                <li>
                    <dl>
                        <dt>北京 ></dt>
                        <dd>
                            <a href="#">北京</a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>上海 ></dt>
                        <dd>
                            <a href="#">上海</a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>广东 ></dt>
                        <dd>
                            <a href="#">广州</a>
                            <a href="#">深圳</a>
                            <a href="#">东莞</a>  
                            <a href="#">惠州</a>
                            <a href="#">佛山</a>
                            <a href="#">珠海</a>
                            <a href="#">汕头</a>
                            <a href="#">汕尾</a>
                            <a href="#">韶关</a>
                            <a href="#">河源</a>
                            <a href="#">潮州</a>
                            <a href="#">阳江</a>
                            <a href="#">云浮</a>
                            <a href="#">湛江</a>
                            <a href="#">江门</a>
                            <a href="#">揭阳</a>
                            <a href="#">肇庆</a>
                            <a href="#">茂名</a>
                            <a href="#">中山</a>
                            <a href="#">梅州</a>
                            <a href="#">清远</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
        <ul class="fl">
            <li><a href="">医疗</a><span class="fr">|</span></li>
            <li><a href="">百科</a><span class="fr">|</span></li>
            <li><a href="">资讯</a><span class="fr">|</span></li>
            <li><a href="">保险</a><span class="fr hidden">|</span></li>
        </ul>
        <div class="fr">
            <ul>
               <li class="login"><a href="javascript:void(0);">你好,<s:property value="#session.user.name" default="游客    登录"/></a><span class="fr">|</span></li>
                <li><a href="regist.jsp">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="header w960 center" id="header">
    <dl class="logo fl">
        <dt><img src="images/logo.jpg" width="50" height="50" alt=""></dt>
        <dd>
            <span class="fs12 block">广东医学院</span>
            <p class="fs18 block">广东医学院xx医院网上预约挂号平台</p>
        </dd>
    </dl>
    <div class="search fr">
        <input type="text" id="search_key" class="fl fs16" autocomplete="off" placeholder="请输入您想搜索的内容">
        <input type="submit" value="搜索" id="search_btn" class="fl fs18 t_c">
    </div>
</div>
<div class="content w960 center clearfix">
    <div class="focus fl">
        <div class="fcs_box relative o-hidden">
            <ul class="absolute" id="fcs_cnt">
                <li><a href="http://sz.91160.com/health/nosmoking.html"><img src="images/banner1.jpg" width="650" height="246" alt=""></a></li>
                <li><a href="http://sz.91160.com/special/mobile.html?hmsr=91160jd&hmmd=pic&hmpl=2.14&hmkw=&hmci="><img src="images/banner2.jpg" width="650" height="246" alt=""></a></li>
                <li><a href="http://sz.91160.com/help/league.html?hmsr=JD&hmmd=pic&hmpl=4.18&hmkw=&hmci="><img src="images/banner3.jpg" width="650" height="246" alt=""></a></li>
            </ul>
        </div>
        <ul id="fcs_tab">
            <li class="fcs_on"><i>1</i>提高烟草税 保护下一代</li>
            <li><i>2</i>就医160APP V3.0</li>
            <li><i>3</i>医院加盟</li>
        </ul>
    </div>
    <div class="side_login fr">
        <div class="s_data">
          <ul>
            <li>累计服务人次 <strong>17,312,481</strong></li>
            <li>可预约医生数 <strong>172,738</strong></li>
          </ul>
        </div>
        <form class="s_login" action="login.action" method="post" name="login">
            <div class="s_l_tt t_c fs16">用户登录</div>
            <div class="s_l_bd">
                <label class="s_wrong clearfix"><b>×</b><span></span></label>
                <ul class="center clearfix">
                    <li class="login-li center"><span>用户名</span><input id="s_uid" type="text" autocomplete="off" placeholder="手机/邮箱/身份证" name="user_id"></li>
                    <li class="login-li center"><span>密&nbsp;&nbsp;码</span><input id="s_pwd" type="password" maxlength="20" autocomplete="off" placeholder="请输入您的密码" name="pwd"></li>
                </ul>
                <input type="submit" class="s_login_btn center t_c fs20" value="登录">
            </div>
        </form>
    </div>
    <div class="hospital fl o-hidden">
        <div class="hp_tt cnt_tt">找医院</div>
        <div class="hs_cnt">
            <ul>
                <li class="clearfix">
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs10 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路</span>
                        </dd>
                    </dl>
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                </li>
                <li class="clearfix">
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                </li>
                <li class="clearfix">
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                </li>
                <li class="clearfix">
                    <dl class="hs_not3j">
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                </li>
                <li class="clearfix">
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                    <dl>
                        <dt><a href=""><img src="images/hospital.jpg" width="210" height="auto" alt=""></a></dt>
                        <dd>
                            <a href="" class="block fl fs14">东莞市人民医院</a>
                            <em class="fs12 fl">三甲</em>
                            <span class="fl fs12">东莞市万江区新谷涌万道路南3号</span>
                        </dd>
                    </dl>
                </li>
            </ul>      
        </div>
    </div>
    <div class="famoushospital fr">
        <div class="fh_tt cnt_tt">名院</div>
        <div class="fh_cnt">
            <ul>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
                <li>
                    <a href="" class="fh_ads">东莞</a>
                    <a href="" class="fh_name">东莞市人民医院</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="specialty fl">
        <div class="sp_tt cnt_tt">找专科</div>
        <div class="sp_cnt">
            <ul>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon1"></i>内科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon2"></i>外科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon3"></i>妇产科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon4"></i>五官科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon5"></i>中医科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon6"></i>中西医结合科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon7"></i>皮肤性病科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon8"></i>儿科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon9"></i>肿瘤科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon10"></i>男科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon11"></i>传染病科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon12"></i>精神心理科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon13"></i>生殖健康科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon14"></i>康复医学科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon15"></i>整形美容科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon16"></i>介入医学科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon17"></i>麻醉医学科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon18"></i>职业病科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon19"></i>医学影像科</a></li>
                <li><a href="specialty.jsp" target="_blank"><i class="sp_icon fl block sp_icon20"></i>病理科</a></li>
            </ul>
        </div>
    </div>
    <div class="doctor fl">
    <s:debug></s:debug>
        <div class="dc_tt cnt_tt fl">
            <span>找医生</span>
            <div class="dc_tab">
                <ul >
                    <li class="fl" tab="tab1"><a href="OzqActionDoctorNametab1.action" target="doctorframe_tab1">门诊内科</a></li>
                    <li class="fl" tab="tab2"><a href="OzqActionDoctorNametab2.action" target="doctorframe_tab2">门诊妇科</a></li>
                    <li class="fl" tab="tab3"><a href="OzqActionDoctorNametab3.action" target="doctorframe_tab3">门诊急诊科</a></li>
                    <li class="fl" tab="tab4"><a href="OzqActionDoctorNametab4.action" target="doctorframe_tab4">门诊口腔科</a></li>
                    <li class="fl" tab="tab5"><a href="OzqActionDoctorNametab5.action" target="doctorframe_tab5">门诊中医科</a></li>
                    <li class="fl" tab="tab6"><a href="OzqActionDoctorNametab6.action" target="doctorframe_tab6">门诊外科</a></li>
                    <li class="fl" tab="tab7"><a href="OzqActionDoctorNametab7.action" target="doctorframe_tab7">体检科</a></li>
                </ul>
            </div>
        </div>
        <div class="dc_tabbox">
            <div class="dc_tabcnt" id="tab1" style="display:block;">
        		<iframe class="doc_view_tab1" name="doctorframe_tab1" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctorview.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab2">
        		<iframe class="doc_view_tab2" name="doctorframe_tab2" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab2.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab3">
        		<iframe class="doc_view_tab3" name="doctorframe_tab3" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab3.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab4">	
        		<iframe class="doc_view_tab4" name="doctorframe_tab4" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab4.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab5">	
        		<iframe class="doc_view_tab5" name="doctorframe_tab5" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab5.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab6">	
        		<iframe class="doc_view_tab6" name="doctorframe_tab6" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab6.jsp"></iframe>
        	</div>
        	<div class="dc_tabcnt" id="tab7">	
        		<iframe class="doc_view_tab7" name="doctorframe_tab7" height="250px" width="100%" frameborder="0" scrolling="auto" src="doctortab7.jsp"></iframe>
        	</div>	
    </div>
</div>
<div class="footer center t_c">
    <p>客服电话 110&nbsp;&nbsp;&nbsp;&nbsp;报警电话 110</p>
    <p>版权所有 Copyright©2014-9999 广东医学院10级信管15班 All rights reserved</p>
</div>
</div>
<div class="login_bg absolute center"><div class="lg_bg fixed center"></div></div>
<div class="lg_cnt center fixed">
    <div class="lg_tt">
        <span>登录</span>
        <a href="javascript:void(0);" class="t_c block fr loginclose">×</a>
    </div>
    <form class="lg_form relative" action="login.action" method="post" name="login">
        <label class="wrong clearfix"><b>×</b><span></span></label>
        <ul class="center clearfix">
            <li><span>用户名</span><input id="uid" type="text" autocomplete="off" size="35" placeholder="手机/邮箱/身份证" name="user_id"></li>
            <li><span>密码</span><input id="pwd" type="password" 	maxlength="20" autocomplete="off" size="35" name="pwd"></li>
            <li>
                <span>验证码</span><input id="vcc" type="text" maxlength="4" size="9">
                <img alt="验证码" class="vccode fl" src="images/code1.png" width="70" height="36" style="cursor:pointer;">
                <a href="javascript:void(0);" class="changecode">看不清换一张</a>
            </li>
        </ul>	
        <input type="submit" class="login_btn center t_c" value="登录">
    </form>
</div>
</body>
</html>