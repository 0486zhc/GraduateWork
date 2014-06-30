<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>东莞市人民医院</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<link href="<%=basePath%>PhoneWeb/WebTwo/styles/specialty.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>PhoneWeb/WebTwo/styles/bootstrap.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>PhoneWeb/WebTwo/styles/NewGlobal.css"
	rel="stylesheet" />
<link href="<%=basePath%>PhoneWeb/WebTwo/styles/My.css"
	rel="stylesheet" />
	
<script type="text/javascript"
	src="<%=basePath%>PhoneWeb/WebTwo/Scripts/zepto.js"></script>
	
	
</head>

<s:action name="appoint_findDept" executeResult="true">
	<s:param name="dept" value="depts"></s:param>
</s:action>

<body>
	<div class="header">
		<a href="<%=basePath%>PhoneWeb/index.jsp" class="home"> <span
			class="header-icon header-icon-home"></span> <span
			class="header-name">主页</span> </a>
		<div class="title" id="titleString">医生时间</div>
		<a href="javascript:history.go(-1);" class="back"> <span
			class="header-icon header-icon-return"></span> <span
			class="header-name">返回</span> </a>
	</div>


<!-- 	<div class="container hotellistbg"> -->
<!-- 		<ul class="unstyled hotellist"> -->
<!-- begin ===== -->
		<div id="wrap" class="center">
			<div class="orderdata">
                <div class="od_tt">
                    <div class="od_prev fl od_tt_btn t_c"></div>
                    <div class="od_next fr od_tt_btn t_c"></div>
                    <div class="timetable fl">
                        <ul>
                             <li class="fl" id='date1'>
                             	${date2 }<br>${day2 }
                            </li>
                            <li class="fl" id='date2'>
                             	${date3 }<br>${day3 }
                            </li>
                            <li class="fl" id='date3'>
                            	${date4 }<br>${day4 }
                            </li>
                            <li class="fl" id='date4'>
                            	${date5 }<br>${day5 }
                            </li>
                            <li class="fl" id='date5'>
                            	${date6 }<br>${day6 }
                            </li>
                            <li class="fl" id='date6'>
                            	${date7 }<br>${day7 }
                            </li>
                            <li class="fl" id='date7'>
                             	${date8 }<br>${day8 }
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="od_cnt">
<!--  ===========================                   -->
				<ul>
                        <li class="beforenoon dc_od_cnt_li od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <s:if test="#request.twodaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.twodaymoring.limitNumApp != 0">
                            		<s:if test="#request.twodaymoring.registApped != #request.twodaymoring.limitNumApp">
                            			<s:iterator value="#request.twodaymoring">
                            				<a href='appointment_appointTimes?mess2=<s:property value="#request.twoday.doctorNo"/>&date=<s:property value="#request.date2"/>&mess=<s:property value="#request.twodaymoring.clinicDuration"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.threeday.doctorNo"/>&counsel_date=<s:property value="#request.date3"/>&clinic_duration=<s:property value="#request.threedaymoring.clinicDuration"/>&queue_name=<s:property value="#request.threedaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.fourday.doctorNo"/>&counsel_date=<s:property value="#request.date4"/>&clinic_duration=<s:property value="#request.fourdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.fourdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.fiveday.doctorNo"/>&counsel_date=<s:property value="#request.date5"/>&clinic_duration=<s:property value="#request.fivedaymoring.clinicDuration"/>&queue_name=<s:property value="#request.fivedaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.sixday.doctorNo"/>&counsel_date=<s:property value="#request.date6"/>&clinic_duration=<s:property value="#request.sixdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.sixdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.sevenday.doctorNo"/>&counsel_date=<s:property value="#request.date7"/>&clinic_duration=<s:property value="#request.sevendaymoring.clinicDuration"/>&queue_name=<s:property value="#request.sevendaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            <s:if test="#request.eightdaymoring.clinicDuration == '上午'">
                            	<s:if test="#request.eightdaymoring.limitNumApp != 0">
                            		<s:if test="#request.eightdaymoring.registApped != #request.eightdaymoring.limitNumApp">
                            			<s:iterator value="#request.eightdaymoring">
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            <s:if test="#request.twodaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.twodaynoon.limitNumApp != 0">
                            		<s:if test="#request.twodaynoon.registApped != #request.twodaynoon.limitNumApp">
                            			<s:iterator value="#request.twodaynoon">
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            			<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_off">约满</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.eightday.doctorNo"/>&counsel_date=<s:property value="#request.date8"/>&clinic_duration=<s:property value="#request.eightdaymoring.clinicDuration"/>&queue_name=<s:property value="#request.eightdaymoring.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            <s:if test="#request.eightdaynoon.clinicDuration == '急诊中午'">
                            	<s:if test="#request.eightdaynoon.limitNumApp != 0">
                            		<s:if test="#request.eightdaynoon.registApped != #request.eightdaynoon.limitNumApp">
                            			<s:iterator value="#request.eightdaynoon">
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
                            <s:if test="#request.eightdayafternoon.clinicDuration == '下午'">
                            	<s:if test="#request.eightdayafternoon.limitNumApp != 0">
                            		<s:if test="#request.eightdayafternoon.registApped != #request.eightdayafternoon.limitNumApp">
                            			<s:iterator value="#request.eightdayafternoon">
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
                            <s:if test="#request.twodaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.twodaynight.limitNumApp != 0">
                            		<s:if test="#request.twodaynight.registApped != #request.twodaynight.limitNumApp">
                            			<s:iterator value="#request.twodaynight">
                            				<a href='OzqActionRegistTime.action?doctor_no=<s:property value="#request.twoday.doctorNo"/>&counsel_date=<s:property value="#request.date2"/>&clinic_duration=<s:property value="#request.twodaynight.clinicDuration"/>&queue_name=<s:property value="#request.twodaynight.queueName"/>' class="fl t_c block fs12 od_btn order_access">预约<br>(<s:property value="registApped"/>/<s:property value="limitNumApp"/>)</a>
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
                            <s:if test="#request.eightdaynight.clinicDuration == '急诊晚上'">
                            	<s:if test="#request.eightdaynight.limitNumApp != 0">
                            		<s:if test="#request.eightdaynight.registApped != #request.eightdaynight.limitNumApp">
                            			<s:iterator value="#request.eightdaynight">
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
						    
<!-- ==================================== -->
                </div>
            </div>
</div>
<!-- end ===== -->
<!-- 		</ul> -->
<!-- 	</div> -->


	<div class="footer">
		<div class="gezifooter">

			<a href="<%=basePath%>PhoneWeb/WebTwo/login.jsp" class="ui-link">立即登陆</a> <font color="#878787">|</font>
			<a href="<%=basePath%>PhoneWeb/WebTwo/register.jsp" class="ui-link">免费注册</a> <font color="#878787">|</font>


			<a href="<%=basePath %>jsp/page/login.jsp" class="ui-link">电脑版</a>
		</div>
		<div class="gezifooter">
			<p style="color:#bbb;">&copy; 版权所有 2012-2014</p>
		</div>
	</div>

</body>
</html>
