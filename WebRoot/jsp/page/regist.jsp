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
<link href="css/regist.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.lazyload.1.8.4.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
    $("img").lazyload({
        effect: "fadeIn"
    });
});

function onlyNum()
{
if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
//考虑小键盘上的数字键
event.returnvalue=false;
}

</script>
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
        <input type="text" id="search_key" class="fl fs16" autocomplete="off" placeholder="请输入您想搜索的内容">
        <input type="submit" value="搜索" id="search_btn" class="fl fs18 t_c">
    </div>
</div>
<div class="content">
	<div class="cnt w960 center clearfix" style="height:500px;background:#FFF;">
		<div class="rg_tt"><span>注册新帐号</span></div>
		<form class="rg_cnt fl" action="regist.action" method="post" name="regist">
			<p>请填写以下账号信息</p>
			<ul>
				<li>
					<span>手机号</span>
					<input type="text" value="" placeholder="请输入您的手机号码" maxlength="11" onkeydown="onlyNum();" name="phoneNum">
					<label for="">手机号码不能为空</label>
				</li>
				<li>
					<span>用户密码</span>
					<input type="password" value="" placeholder="请输入8-20位登录密码"  maxlength="20" name="pwd">
					<label for="">密码不能为空</label>
				</li>
				<li>
					<span>真实姓名</span>
					<input type="text" value="" placeholder="为了成功就诊，请正确填写" name="user_name">
					<label for="">姓名不能为空</label>
				</li>
				<li>
					<span>身份证</span>
					<input type="text" value="" placeholder="为了成功就诊，请正确填写" maxlength="18" name="user_id">
					<label for="">身份证不能为空</label>
				</li>
			</ul>
			<input type="submit" value="同意协议并注册">
		</form>
		<div class="rg_side fr">
			<div class="qst rg_sd">
				<b class="fs12">如果您有疑问？</b>
				<span class="fs12">请拨打全国免费客服热线</span>
				<p class="fs18">110</p>
			</div>
			<div class="tip rg_sd">
				<p class="fs12">如果您曾经已通过电话或在医院现场成功预约，您可以在就医160网站通过 账号激活 或 找回密码 完成相应步骤，即可登录。</p>
			</div>
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
    <form class="lg_form relative">
        <label class="wrong clearfix"><b>×</b><span></span></label>
        <ul class="center clearfix">
            <li><span>用户名</span><input id="uid" type="text" autocomplete="off" size="35" placeholder="手机/邮箱/身份证"></li>
            <li><span>密码</span><input id="pwd" type="password" maxlength="20" autocomplete="off" size="35"></li>
            <li>
                <span>验证码</span><input id="vcc" type="text" maxlength="4" size="9">
                <img alt="验证码" class="vccode fl" src="images/code1.png" width="70" height="36" style="cursor:pointer;">
                <a href="javascript:void(0);" class="changecode">看不清换一张</a>
            </li>
        </ul>
        <input type="button" class="login_btn center t_c" value="登录">
    </form>
</div>

</body>
</html>