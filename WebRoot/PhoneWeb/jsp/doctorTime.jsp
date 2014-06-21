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
                            <li class="fl">
                                06-11<br>周三
                            </li>
                            <li class="fl">
                                06-12<br>周四
                            </li>
                            <li class="fl">
                                06-13<br>周五
                            </li>
                            <li class="fl holiday">
                                06-14<br>周六
                            </li>
                            <li class="fl holiday">
                                06-15<br>周日
                            </li>
                            <li class="fl">
                                06-16<br>周一
                            </li>
                            <li class="fl">
                                06-17<br>周二
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="od_cnt">
                    <ul>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                        <li class="beforenoon od_cnt_time clearfix">
                            <div class="fl">上<br>午</div>
                            <div class="fr">上<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_off">约满</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>16/21</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                    </ul>
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
