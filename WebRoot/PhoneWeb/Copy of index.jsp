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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>东莞市人民医院</title>
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="wiying/Tpl/Wap/wiying/Index/E-xinan/default/index.css" />
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/jquery.js"></script>
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/jquery-1.2.6.pack.js"></script>
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/g.base.js"></script>
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/iscroll.js"></script>
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/alert.js"></script>
<script type="text/javascript"
	src="wiying/Tpl/Wap/wiying/common/common.js"></script>
<script type="text/javascript">
	var myScroll;
	function loaded() {
		myScroll = new iScroll(
				'wrapper',
				{
					snap : true,
					momentum : false,
					hScrollbar : false,
					onScrollEnd : function() {
						document.querySelector('#indicator > li.active').className = '';
						document.querySelector('#indicator > li:nth-child('
								+ (this.currPageX + 1) + ')').className = 'active';
					}
				});
	}
	document.addEventListener('DOMContentLoaded', loaded, false);
</script>
</head>

<body>
	<header>
		<div class="banner">
			<div id="wrapper" style="overflow: hidden; ">
				<div id="scroller">
					<ul id="thelist">
						<li><p></p>
							<a href="#"><img
								src="upload/img/xctxwlb/20131029/1.jpg" />
						</a>
						</li>
						<li><p></p>
							<a href="#"><img
								src="upload/img/xctxwlb/20131029/2.jpg" />
						</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="nav">
			<div id="prev" onclick="javascript:myScroll.scrollToPage('prev', 0);"></div>
			<ul id="indicator">
				<li class="active"></li>
				<li></li>
			</ul>
			<div id="next"
				onclick="javascript:myScroll.scrollToPage('next', 0, 400, 2);"></div>
		</div>
		<div class="clr"></div>
	</header>
	<script>
		var count = document.getElementById("thelist").getElementsByTagName(
				"img").length;
		for (i = 0; i < count; i++) {
			document.getElementById("thelist").getElementsByTagName("img")
					.item(i).style.cssText = " width:"
					+ document.body.clientWidth + "px";
		}
		document.getElementById("scroller").style.cssText = " width:"
				+ document.body.clientWidth * count + "px";
		setInterval(function() {
			myScroll.scrollToPage('next', 0, 400, count);
		}, 3500);
		window.onresize = function() {
			for (i = 0; i < count; i++) {
				document.getElementById("thelist").getElementsByTagName("img")
						.item(i).style.cssText = " width:"
						+ document.body.clientWidth + "px";
			}
			document.getElementById("scroller").style.cssText = " width:"
					+ document.body.clientWidth * count + "px";
		};
	</script>
	<div class="main">
		<div>
			<a
				href=" ">
				<p class="img"
					style="background:url(./upload/img/icon/yuyue.png) no-repeat; background-size:contain;"></p>
				<p class="text">预约挂号</p> </a>
		</div>
		<div>
			<a
				href=" ">
				<p class="img"
					style="background:url(./upload/img/icon/1383014031703.png) center no-repeat; background-size:contain;"></p>
				<p class="text">科室专家</p> </a>
			 <a
				href="">
				<p class="img"
					style="background:url(./upload/img/icon/13830140513607.png) center no-repeat; background-size:contain;"></p>
				<p class="text">查询挂号</p> </a>
		</div>
		<div>
			<a
				href="../PhoneWeb/jsp/HospitalIntroduction.jsp">
				<p class="img"
					style="background:url(./upload/img/icon/13830140766638.png) center no-repeat; background-size:contain;"></p>
				<p class="text">医院简介</p> </a>
			 <a
				href="../PhoneWeb/jsp/traffic.jsp">
				<p class="img"
					style="background:url(./upload/img/icon/13830141096885.png) center no-repeat; background-size:contain;"></p>
				<p class="text">交通指南</p> </a>
		</div>
		<div>
			<a
				href="../PhoneWeb/jsp/advice.jsp">
				<p class="img"
					style="background:url(./upload/img/icon/13830141383823.png) center no-repeat; background-size:contain;"></p>
				<p class="text">服务建议</p> </a> <a
				href="./WebTwo/login.jsp">
				<p class="img"
					style="background:url(./upload/img/icon/13830141579551.png) center no-repeat; background-size:contain;"></p>
				<p class="text">我的信息</p> </a>
		</div>
	</div>
	<div class="footer">
		<p class="footer-top">&COPY;<s:property value="mess" />：您好！</p>
		<p class="footer-bottom" data-role="none">
			 <a href="index.html">首页</a> <a
				href="zhengwen.jsp">正文页</a> <a href="liebiao.jsp">列表页</a>
		</p>
	</div>
</body>
</html>