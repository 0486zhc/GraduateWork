<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head runat="server">
  <title></title>
   
     <link href="css/regist.css" rel="stylesheet" type="text/css">
     <script language="javascript" type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
     <script type="text/javascript" src="js/jquery.lazyload.1.8.4.min.js"></script>
     <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?&v=1.3"></script>
    
</head>
<body>
   <div class="rg_map fl">
       <span> 地址：</span>
       <input id="txtSearch" type="text" />
        <input type="button" value="搜索" onclick="search()" />
   </div> 	
    <div style="width: 800px; height: 600px; border: 1px solid gray;" id="container">
    </div>
</body>
<script type="text/javascript">
    function $(id) {
        return document.getElementById(id); //定义$
    }
    var map = new BMap.Map("container"); //创建地图
    map.centerAndZoom(new BMap.Point(116.330599, 39.95536), 10); //初始化地图


    map.enableScrollWheelZoom();  // 开启鼠标滚轮缩放    
    map.enableKeyboard();         // 开启键盘控制    
    map.enableContinuousZoom();   // 开启连续缩放效果    
    map.enableInertialDragging(); // 开启惯性拖拽效果  

    map.addControl(new BMap.NavigationControl()); //添加标准地图控件(左上角的放大缩小左右拖拽控件)  
    map.addControl(new BMap.ScaleControl());      //添加比例尺控件(左下角显示的比例尺控件)  
    map.addControl(new BMap.OverviewMapControl()); // 缩略图控件  
    map.addControl(new BMap.MapTypeControl());

    var city = new BMap.LocalSearch(map, { renderOptions: { map: map, autoViewport: true} }); //地图显示到查询结果处

    function search() {
        var s = $("txtSearch").value;
        city.search(s); //查找城市
    }
</script>
</html>