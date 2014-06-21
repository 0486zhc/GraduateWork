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
    <div class="pst fl fs12"><a href="index.html">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="">东莞市妇幼保健院</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="specialty.jsp">产科</a>&nbsp;&nbsp;>&nbsp;&nbsp;钟灵（专病门诊）</div>
    <div class="clear"></div>
	<div class="sp_cnt clearfix">
        <div class="aside fl fs12">
            <div class="aside_cnt clearfix">
                <div class="ordernum">已预约<b>631</b>&nbsp;人</div>
                <div class="dpt_dpt card">
                    <div class="dpt_img">
                        <img src="images/doctor.jpg" alt="刘浩斌" title="刘浩斌" width="150" height="200">
                    </div>
                    <dl class="dpt_info">
                        <dt><s:property value="#request.doctorname"/></dt>
                        <dd>
                            <b>副主任医师</b>
                            <p>科室：<a href="specialty.jsp"><s:property value="#request.deptname"/></a></p>
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
        <div class="sp_main fr">
            <div class="orderdata dc_od fl">
                <div class="od_tt">
                    <div class="od_prev fl dc_od_tt_btn t_c"></div>
                    <div class="od_next fr dc_od_tt_btn t_c"></div>
                    <div class="timetable fl">
                        <ul>
                            <li class="fl" id='date1'>
                             	${date1 }<br>${day1 }
                            </li>
                            <li class="fl" id='date2'>
                             	${date2 }<br>${day2 }
                            </li>
                            <li class="fl" id='date3'>
                             	${date3 }<br>${day3 }
                            </li>
                            <li class="fl" id='date4'>
                            	${date4 }<br>${day4 }
                            </li>
                            <li class="fl" id='date5'>
                            	${date5 }<br>${day5 }
                            </li>
                            <li class="fl" id='date6'>
                            	${date6 }<br>${day6 }
                            </li>
                            <li class="fl" id='date7'>
                            	${date7 }<br>${day7 }
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="od_cnt">
                    <ul>
                        <li class="beforenoon dc_od_cnt_li od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <s:if test="#request.todaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.todaymoring.limitNumApp != 0">
                            		<s:if test="#request.todaymoring.registApped != #request.todaymoring.limitNumApp">
                            			<s:iterator value="#request.todaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.twodaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.twodaymoring.limitNumApp != 0">
                            		<s:if test="#request.twodaymoring.registApped != #request.twodaymoring.limitNumApp">
                            			<s:iterator value="#request.twodaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.threedaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.threedaymoring.limitNumApp != 0">
                            		<s:if test="#request.threedaymoring.registApped != #request.threedaymoring.limitNumApp">
                            			<s:iterator value="#request.threedaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fourdaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.fourdaymoring.limitNumApp != 0">
                            		<s:if test="#request.fourdaymoring.registApped != #request.fourdaymoring.limitNumApp">
                            			<s:iterator value="#request.fourdaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fivedaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.fivedaymoring.limitNumApp != 0">
                            		<s:if test="#request.fivedaymoring.registApped != #request.fivedaymoring.limitNumApp">
                            			<s:iterator value="#request.fivedaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sixdaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.sixdaymoring.limitNumApp != 0">
                            		<s:if test="#request.sixdaymoring.registApped != #request.sixdaymoring.limitNumApp">
                            			<s:iterator value="#request.sixdaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sevendaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.sevendaymoring.limitNumApp != 0">
                            		<s:if test="#request.sevendaymoring.registApped != #request.sevendaymoring.limitNumApp">
                            			<s:iterator value="#request.sevendaymoring">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                        </li>
                        <li class="beforenoon dc_od_cnt_li od_cnt_time clearfix">
                            <div class="fl">中<br>午</div>
                            <div class="fr">中<br>午</div>
                            <s:if test="#request.todaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.todaynoon.limitNumApp != 0">
                            		<s:if test="#request.todaynoon.registApped != #request.todaynoon.limitNumApp">
                            			<s:iterator value="#request.todaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.twodaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.twodaynoon.limitNumApp != 0">
                            		<s:if test="#request.twodaynoon.registApped != #request.twodaynoon.limitNumApp">
                            			<s:iterator value="#request.twodaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.threedaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.threedaynoon.limitNumApp != 0">
                            		<s:if test="#request.threedaynoon.registApped != #request.threedaynoon.limitNumApp">
                            			<s:iterator value="#request.threedaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fourdaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.fourdaynoon.limitNumApp != 0">
                            		<s:if test="#request.fourdaynoon.registApped != #request.fourdaynoon.limitNumApp">
                            			<s:iterator value="#request.fourdaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fivedaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.fivedaynoon.limitNumApp != 0">
                            		<s:if test="#request.fivedaynoon.registApped != #request.fivedaynoon.limitNumApp">
                            			<s:iterator value="#request.fivedaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sixdaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.sixdaynoon.limitNumApp != 0">
                            		<s:if test="#request.sixdaynoon.registApped != #request.sixdaynoon.limitNumApp">
                            			<s:iterator value="#request.sixdaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sevendaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.sevendaynoon.limitNumApp != 0">
                            		<s:if test="#request.sevendaynoon.registApped != #request.sevendaynoon.limitNumApp">
                            			<s:iterator value="#request.sevendaynoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                        </li>
                        <li class="afternoon dc_od_cnt_li od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <s:if test="#request.todayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.todayafternoon.limitNumApp != 0">
                            		<s:if test="#request.todayafternoon.registApped != #request.todayafternoon.limitNumApp">
                            			<s:iterator value="#request.todayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.twodayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.twodayafternoon.limitNumApp != 0">
                            		<s:if test="#request.twodayafternoon.registApped != #request.twodayafternoon.limitNumApp">
                            			<s:iterator value="#request.twodayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.threedayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.threedayafternoon.limitNumApp != 0">
                            		<s:if test="#request.threedayafternoon.registApped != #request.threedayafternoon.limitNumApp">
                            			<s:iterator value="#request.threedayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fourdayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.fourdayafternoon.limitNumApp != 0">
                            		<s:if test="#request.fourdayafternoon.registApped != #request.fourdayafternoon.limitNumApp">
                            			<s:iterator value="#request.fourdayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fivedayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.fivedayafternoon.limitNumApp != 0">
                            		<s:if test="#request.fivedayafternoon.registApped != #request.fivedayafternoon.limitNumApp">
                            			<s:iterator value="#request.fivedayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sixdayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.sixdayafternoon.limitNumApp != 0">
                            		<s:if test="#request.sixdayafternoon.registApped != #request.sixdayafternoon.limitNumApp">
                            			<s:iterator value="#request.sixdayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sevendayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.sevendayafternoon.limitNumApp != 0">
                            		<s:if test="#request.sevendayafternoon.registApped != #request.sevendayafternoon.limitNumApp">
                            			<s:iterator value="#request.sevendayafternoon">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                        </li>
                        <li class="beforenoon dc_od_cnt_li od_cnt_time clearfix">
                            <div class="fl">晚<br>上</div>
                            <div class="fr">晚<br>上</div>
                            <s:if test="#request.todaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.todaynight.limitNumApp != 0">
                            		<s:if test="#request.todaynight.registApped != #request.todaynight.limitNumApp">
                            			<s:iterator value="#request.todaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.twodaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.twodaynight.limitNumApp != 0">
                            		<s:if test="#request.twodaynight.registApped != #request.twodaynight.limitNumApp">
                            			<s:iterator value="#request.twodaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.threedaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.threedaynight.limitNumApp != 0">
                            		<s:if test="#request.threedaynight.registApped != #request.threedaynight.limitNumApp">
                            			<s:iterator value="#request.threedaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fourdaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.fourdaynight.limitNumApp != 0">
                            		<s:if test="#request.fourdaynight.registApped != #request.fourdaynight.limitNumApp">
                            			<s:iterator value="#request.fourdaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.fivedaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.fivedaynight.limitNumApp != 0">
                            		<s:if test="#request.fivedaynight.registApped != #request.fivedaynight.limitNumApp">
                            			<s:iterator value="#request.fivedaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sixdaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.sixdaynight.limitNumApp != 0">
                            		<s:if test="#request.sixdaynight.registApped != #request.sixdaynight.limitNumApp">
                            			<s:iterator value="#request.sixdaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                            <s:if test="#request.sevendaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.sevendaynight.limitNumApp != 0">
                            		<s:if test="#request.sevendaynight.registApped != #request.sevendaynight.limitNumApp">
                            			<s:iterator value="#request.sevendaynight">
                            				<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
                            			</s:iterator>
                            		</s:if>
                            		<s:else>
                            			<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            		</s:else>
                            	</s:if>
                            	<s:else>
                            		<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            	</s:else>
                            </s:if>
                            <s:else>
                            	<a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            </s:else>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="bar_middle fl">（ 今日 <strong>18:00</strong> 开始可预约至<strong> ${date7 } </strong>号源，<strong>16:00</strong> 截止<strong> ${date1 } </strong>号源的预约 ）</div>
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
                    <li class="fl">
                        <dl class="clearfix">
                            <dt class="fl"><a href="doctor.jsp"><img src="images/doctor.jpg" width="48" height="58" alt="刘浩斌（专病门诊）"></a></dt>
                            <dd class="fl">
                                <a href="doctor1105.jsp">廖志坚</a><br>
                                <span class="fs12">副主任医师</span>
                            </dd>
                        </dl>
                        <i class="fl fs12">擅长：</i>
                        <p class="fs12 o-hidden">从事门诊内科临床工作二十余年，对门诊内科常见病及疑难杂症临床处理具有丰富的临床经验。</p>
                    </li>
                    <li class="fl">
                        <dl class="clearfix">
                            <dt class="fl"><a href="doctor.jsp"><img src="images/doctor.jpg" width="48" height="58" alt="刘浩斌（专病门诊）"></a></dt>
                            <dd class="fl">
                                <a href="doctor.jsp">陈维东</a><br>
                                <span class="fs12">副主任医师</span>
                            </dd>
                        </dl>
                        <i class="fl fs12">擅长：</i>
                        <p class="fs12 o-hidden">从事门诊内科临床工作二十余年，对门诊内科常见病及疑难杂症临床处理具有丰富的临床经验。</p>
                    </li>
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