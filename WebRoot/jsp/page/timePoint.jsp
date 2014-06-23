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
<link href="css/specialty.css" rel="stylesheet" type="text/css">
<link href="css/doctor.css" rel="stylesheet" type="text/css">
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
<div class="wrap">
<div class="nav" id="nav">
    <div class="top clearfix w960 center relative">
        <div class="city fl"><a href="javascript:void(0);">
            <span class="citynow fs16">东莞</span>
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
                <li class="login"><a href="javascript:void(0);">登录</a><span class="fr">|</span></li>
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
        <input type="text" id="search_key" class="fl fs16" autocomplete="off" placeholder="请输入您想搜索的内容 ">
        <input type="submit" value="搜索" id="search_btn" class="fl fs18 t_c">
    </div>
</div>
<div class="content w960 center clearfix">
    <div class="pst fl fs12"><a href="login.jsp">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="">东莞市妇幼保健院</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="specialty.jsp"><s:property value="#session.thedeptName"/></a>&nbsp;&nbsp;>&nbsp;&nbsp;<s:property value="#session.doctName"/>（专病门诊）</div>
    <div class="clear"></div>
	<div class="sp_cnt clearfix">
        <div class="aside fl fs12">
            <div class="aside_cnt clearfix">
               <div class="ordernum">已预约<b>631</b>&nbsp;人</div>
                <div class="dpt_dpt card">
                    <div class="dpt_img">
                        <img src="images/doctor.jpg" alt='<s:property value="#session.doctName"/>' title='<s:property value="#session.doctName"/>' width="150" height="200">
                    </div>
                    <dl class="dpt_info">
                        <dt><s:property value="#session.doctName"/></dt>
                        <dd>
                            <b><s:property value="#session.queuename"/></b>
                            <p>科室：<a href="specialty.jsp"><s:property value="#session.thedeptName"/></a></p>
                            <p>医院：<a href="">东莞市妇幼保健院</a></p>
                            <p>挂号级别：<strong> 9 元</strong></p>
                        </dd>
                    </dl>
                </div>
                <div class="dc_pd card">
                     <span>擅长</span>
                    <p>从事门诊内科临床工作二十余年，对门诊内科常见病及疑难杂症临床处理具有丰富的临床经验。</p>
                </div>
                <div class="dc_pd card">
                    <span>医生介绍</span>
                    <p>从事门诊内科临床工作二十余年，对门诊内科常见病及疑难杂症临床处理具有丰富的临床经验。</p>
                </div>
            </div>
        </div>
        <div class="sp_main fl">
            <div class="orderdata dc_od fl">
                <div class="od_tt">
                    <div class="timetable block t_c">
                             	<span><s:property value="#request.counseldate"/></span>
                             	<p><s:property value="#request.clinicduration"/></p>
                    </div>
                </div>
                <div class="od_cnt">
                	<s:if test='#request.registtime != ""'>
                		<s:iterator value="#request.registtime">
                            <a href="javascript:void(0);" class="fl t_c block fs14 od_btn order_access"><s:property /></a>
                    	</s:iterator>
                    </s:if>
                    <s:else>
                    		<a href="javascript:void(0);" class="fl t_c block fs14 od_btn order_null"></a>
                    </s:else>
                </div>
            </div>
            <div class="bar_middle fl"></div>
            <div class="dc_page fl t_c">
            </div>
        </div>
        <div class="board fl">
            <div class="board_tt clearfix">
               <span class="fl">本科室其它医生</span>
                <a class="fs14 fr" href="specialty.jsp">更多></a>
            </div>
            <div class="board_cnt o-hidden">
                <ul>
                    <s:iterator value="#request.otherdoctor">
                    <li class="fl">
                        <dl class="clearfix">
                            <dt class="fl"><a href='OzqActionOnDuty.action?doctor_name=<s:property />&dept_name=<s:property value="#session.thedeptName"/>'><img src="images/doctor.jpg" width="48" height="58" alt="<s:property />（专病门诊）"></a></dt>
                            <dd class="fl">
                                <a href='OzqActionOnDuty.action?doctor_name=<s:property />&dept_name=<s:property value="#session.thedeptName"/>'><s:property /></a><br>
                                <span class="fs12">副主任医师</span>
                            </dd>
                        </dl>
                        <i class="fl fs12">擅长：</i>
                        <p class="fs12 o-hidden">从事门诊内科临床工作二十余年，对门诊内科常见病及疑难杂症临床处理具有丰富的临床经验。</p>
                    </li>
                  </s:iterator>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="footer center t_c">
    <p>客服电话 00000000&nbsp;&nbsp;&nbsp;&nbsp;报警电话 110</p>
    <p>版权所有 Copyright©2014-9999 广东医学院10级信管15班 </p>
    <s:property value="#request.todaymoring.clinicDuration"/>
</div>
</div>
<div class="login_bg absolute center"><div class="lg_bg fixed center"></div></div>
<div class="lg_cnt center fixed">
    <div class="lg_tt">
        <span>登录</span>
        <a href="javascript:void(0);" class="t_c block fr loginclose">×</a>
    </div>
    <form class="lg_form relative"  action="login.action" method="post" name="login">
        <label class="wrong clearfix"><b>×</b><span></span></label>
        <ul class="center clearfix">
            <li><span>用户名</span><input id="uid" type="text" autocomplete="off" size="35" placeholder="手机/邮箱/身份证" name="user_id"></li>
            <li><span>密码</span><input id="pwd" type="password" maxlength="20" autocomplete="off" size="35" name="pwd"></li>
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