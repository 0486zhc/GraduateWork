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
    <div id="doctor_tab_view" class="dc_tabbox">
            <div class="dc_tabcnt" id="tab6">
                <ul>
                  <s:iterator value="#request.DoctorNametab6">
                    <li>
                        <div class="dc_info">
                            <dl>
                                <dt>
                                    <a href="doctor.jsp" class="dc_info_pic fl block o-hidden"><img src="images/doctor.jpg" width="72" height="auto"  alt=""></a>
                                   	<div class="dc_info_name fl fs18"><s:property /></div>
                                    <span class="dc_info_pst fl fs12">副主任医师</span>
                                </dt>
                                <dd>
                                    <div class="dc_info_hs">
                                        <a href="">东莞市人民医院</a><br>
                                        <a href="specialty.jsp" class="fs12">内科</a>
                                    </div>
                                    <p class="dc_info_pd fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                                </dd>
                            </dl>
                        </div>
                        <div class="dc_icon">
                            <a href="doctor.jsp"><i></i>预约挂号</a>
                        </div>
                    </li>
                  </s:iterator>
                </ul>
            </div>
    </div>
  </body>
</html>
