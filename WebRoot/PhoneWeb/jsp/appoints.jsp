<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>
	东莞市人民医院
</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<link href="<%=basePath %>PhoneWeb/WebTwo/styles/bootstrap.min.css" rel="stylesheet" />
<link href="<%=basePath %>PhoneWeb/WebTwo/styles/NewGlobal.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>PhoneWeb/WebTwo/Scripts/zepto.js"></script>
</head>

<s:action name="appoint_findDept" executeResult="true">
	<s:param name = "dept" value="depts"></s:param>
</s:action>

<body >
	<div class="header">
		<a href="<%=basePath %>PhoneWeb/index.jsp" class="home"> <span
			class="header-icon header-icon-home"></span> <span
			class="header-name">主页</span> </a>
		<div class="title" id="titleString">查询挂号</div>
		<a href="javascript:history.go(-1);" class="back"> <span
			class="header-icon header-icon-return"></span> <span
			class="header-name">返回</span> </a>
	</div>


	<div class="container hotellistbg">
		<ul class="unstyled hotellist">
			<div align="center">
		<s:property value="mess"/>
	</div>
		<s:iterator value="%{appointsList}" var="app" >
			<li><img
					class="hotelimg fl"
					src="<%=basePath %>PhoneWeb/upload/img/xctxwlb/20131029/doctor.jpg" />
					<div class="inlinea">
<!-- 							<h3><s:property value="%{clinicLabel}" /></h3> -->
							<h3><s:property value="#app.clinicLabel" /></h3>
							<p>预约类型：<s:property value="#app.identity" /></p>
							<p>预约时间：<s:property value="#app.visitTimeAppted" /> <s:property value="#app.regTimePoint" /></p>
							<p><br/></p>
					</div>
					<ul class="unstyled"> 
					<li></li>
					<li><a href="appointment_cancle?mess=<s:property value="#app.regTimePoint"/>?doctorNo=<s:property value="#app.preRegistDoctor"/>" class="order">取消预约</a>
					</li><li>
						

					</li> 
					</ul>
		</s:iterator>
		
		
		</ul>
	</div>


	<div class="footer">
		<div class="gezifooter">

			<a href="<%=basePath%>PhoneWeb/WebTwo/login.jsp" class="ui-link">立即登陆</a> <font color="#878787">|</font>
			<a href="<%=basePath%>PhoneWeb/WebTwo/register.jsp" class="ui-link">免费注册</a> <font color="#878787">|</font>


			<a href="<%=basePath %>jsp/page/login.jsp" class="ui-link">电脑版</a>
		</div>
		<div class="gezifooter">
			<p style="color:#bbb;"> &copy; 版权所有 2012-2014</p>
		</div>
	</div>

</body>
</html>
