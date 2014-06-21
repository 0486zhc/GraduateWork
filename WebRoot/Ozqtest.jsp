<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Ozqtest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
	<!--
	.STYLE1 {
		font-size: 12px
	}
	-->
	</style>
	
  </head>
  
  <body>
  	
    <form name="form1" action="jsp/page/OzqAction12">
	<table width="517"  border="1"  cellpadding="1" cellspacing="0" bordercolor="#00AAD5" bgcolor="#EFEFEF">
 	 <tr>
  	  <td height="30"><div align="center" class="STYLE1">1</div></td>
 	   <td><div align="center" class="STYLE1">2</div></td>
 	   <td><div align="center" class="STYLE1">3</div></td>
 	   <td><div align="center" class="STYLE1">4</div></td>
 	   <td><div align="center" class="STYLE1">5</div></td>
	 </tr>
  
  
  <s:iterator value="#request.OutpDoctorRegist">
  	<tr>
    <td height="35" bgcolor="#FFFFFF"><div align="center">*</div></td>
    <td bgcolor="#FFFFFF"><div align="center"><s:property value="doctorNo"/></div></td>
    <td bgcolor="#FFFFFF"><div align="center"><s:property value="counselDate"/></div></td>
    <td bgcolor="#FFFFFF"><div align="center"><s:property value="doctor"/></div></td>
    <td bgcolor="#FFFFFF"><div align="center"><s:property value="roomCode"/></div></td>
  </tr>
  
  </s:iterator>
</table>
<input type="submit" value="点击">
</form>
  </body>
</html>
