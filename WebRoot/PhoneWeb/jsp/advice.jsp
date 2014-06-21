<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>东莞市人民医院</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<link href="<%=basePath %>PhoneWeb/WebTwo/styles/bootstrap.min.css" rel="stylesheet" />
<link href="<%=basePath %>PhoneWeb/WebTwo/styles/NewGlobal.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>PhoneWeb/WebTwo/Scripts/zepto.js"></script>
</head>
<body>
	<div class="header">
		<a href="<%=basePath %>PhoneWeb/index.jsp" class="home"> <span
			class="header-icon header-icon-home"></span> <span
			class="header-name">主页</span> </a>
		<div class="title" id="titleString">服务建议</div>
		<a href="javascript:history.go(-1);" class="back"> <span
			class="header-icon header-icon-return"></span> <span
			class="header-name">返回</span> </a>
	</div>


	<div class="container width80 pt20">
		<form name="advice" method="post"
			action="user_advice"
			id="advice" class="form-horizontal">
			<div>
				<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET"
					value="" /> <input type="hidden" name="__EVENTARGUMENT"
					id="__EVENTARGUMENT" value="" /> <input type="hidden"
					name="__VIEWSTATE" id="__VIEWSTATE"
					value="/wEPDwUKLTE4MTUwOTMzMA9kFgJmD2QWAgIBD2QWAgIBD2QWAgILDxYCHgRocmVmBSwvUmVnLmFzcHg/UmV0dXJuVXJsPSUyZk1lbWJlciUyZkRlZmF1bHQuYXNweGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFJmN0bDAwJENvbnRlbnRQbGFjZUhvbGRlcjEkY2JTYXZlQ29va2ll5P758eqt18XT06y04yVxkKJyzYw=" />
			</div>

			<script type="text/javascript">
				//         
				var theForm = document.forms['aspnetForm'];
				if (!theForm) {
					theForm = document.aspnetForm;
				}
				function __doPostBack(eventTarget, eventArgument) {
					if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
						theForm.__EVENTTARGET.value = eventTarget;
						theForm.__EVENTARGUMENT.value = eventArgument;
						theForm.submit();
					}
				}
				//
			</script>


			<div>
				<p style="text-align: center;">
				<strong>我的留言</strong>
			</p>
				<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
					value="/wEWBQLZmqilDgLJ4fq4BwL90KKTCAKqkJ77CQKI+JrmBdPJophKZ3je4aKMtEkXL+P8oASc" />
			</div>
			<div class="control-group" align="center">
<!-- 				<input name="userName" type="text" -->
<!-- 					id="ctl00_ContentPlaceHolder1_txtUserName" class="input width100 " -->
<!-- 					style="background: none repeat scroll 0 0 #F9F9F9;padding: 8px 0px 8px 4px" -->
<!-- 					placeholder="请输入  身份证 / 诊疗卡号" /> -->
					<textarea  rows="10" cols="100" placeholder="请输入您的留言内容 ！" name="advice.content" ></textarea>
			</div>

			<div class="control-group">
				<span class="red"></span>
			</div>
			<div class="control-group">
				<button onclick="__doPostBack('ctl00$ContentPlaceHolder1$btnOK','')"
					id="ctl00_ContentPlaceHolder1_btnOK"
					class="btn-large green button width100">立即提交</button>
			</div>
			<div class="control-group">
				还没账号？<a href="register.jsp"
					id="ctl00_ContentPlaceHolder1_RegBtn">立即免费注册</a>
			</div>
			<div align="center">
				<p><s:property value="mess"/></p>
			</div>
<!-- 			<div class="control-group"> -->
<!-- 				或者使用合作账号一键登录：<br /> <a class="servIco ico_qq" href="qlogin.aspx"></a> -->
<!-- 				<a class="servIco ico_sina" href="default.htm"></a> -->
<!-- 			</div> -->
		</form>
	</div>


	<div class="footer">
		<div class="gezifooter">

			<a href="login.aspx" class="ui-link">立即登陆</a> <font color="#878787">|</font>
			<a href="reg.aspx" class="ui-link">免费注册</a> <font color="#878787">|</font>


			<a href="../www.gridinn.com/@display=pc" class="ui-link">电脑版</a>
		</div>
		<div class="gezifooter">
			<p style="color:#bbb;"> &copy; 版权所有 2012-2014</p>
		</div>
	</div>

</body>
</html>
