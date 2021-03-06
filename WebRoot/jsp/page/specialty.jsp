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
<link href="css/specialty.css" rel="stylesheet" type="text/css">
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
                <li><a href="exit.action">注销</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="header w960 center" id="header">
    <dl class="logo fl">
        <dt><img src="images/logo.jpg" width="50" height="50" alt=""></dt>
        <dd>
            <span class="fs12 block">广东医学院</span>
            <p class="fs18 block">某群坑货的预约挂号平台</p>
        </dd>
    </dl>
    <div class="search fr">
        <input type="text" id="search_key" class="fl fs16" autocomplete="off" placeholder="请输入您想搜索的基佬或炮友名称">
        <input type="submit" value="搜索" id="search_btn" class="fl fs18 t_c">
    </div>
</div>
<div class="content w960 center clearfix">
    <div class="pst fl fs12"><a href="index.html">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="">东莞市妇幼保健院</a>&nbsp;&nbsp;>&nbsp;&nbsp;产科</div>
    <div class="clear"></div>
	<div class="sp_cnt clearfix">
        <div class="aside fl fs12">
            <div class="aside_cnt clearfix">
                <div class="ordernum">已预约<b>631</b>&nbsp;人</div>
                <div class="dpt_dpt card">
                    <div class="dpt_img">
                        <img src="images/sample.jpg" alt="内科" title="内科" width="180" height="132">
                    </div>
                    <dl class="dpt_info">
                        <dt>产科</dt>
                        <dd>
                            <span>普通科室</span>
                            <a href="">东莞市妇幼保健院</a>
                        </dd>
                    </dl>
                </div>
                <div class="dpt_pd card">
                    <span>科室介绍</span>
                    <p class="o-hidden">东莞市妇幼保健院是全市唯一的市属妇幼保健机构，也是全市母婴保健技术服务指导中心，承担着全市广大妇女儿童的医疗保健任务。五十多年来积累的这里丰富经验，使之成为东莞市在妇女儿觉得童领域中，开展以保健服务、疾病治疗、科学研究、基础教学为一体的具有保健特色的机构。产科拥有多名著名妇产科专家，主任医师三名：隗伏冰主任医师，李小霞主任医师，代柄梅主任医师。产科是我院开设的重点专科，拥有一支业务水平较高的产科专业队伍，不但担负着临床、医疗、培养产科高级人才和科学研究工作，还承担着全市各镇重症孕产妇抢救的指导工作及各镇产科医务人员专业知识和技能培训，还拥有一支技术过硬的护理队伍，能为产妇和患者提供全方位，全过程的温馨服务。科室配有先进的仪器设备，引进了德国胎儿中央监控系统，脐血流波行测定仪，三维/四维彩超，母婴心电监护仪等，对每例住院孕产妇实行全程监护，我院产房还开展了实行一对一周密服务、温馨待产、陪护助产、无痛分娩、婴儿泳疗、产后康复指导、VIP专车免费接送、产后母亲和婴儿访视等温馨个性化的服务。</p>
                    <div class="fr">
                        <a class="slidedown" href="javascript:void(0);">▼展开</a>
                        <a class="slideup" href="javascript:void(0);">▲收缩</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="sp_main fr">
            <div class="doctors fl">
                <div class="dct_tt t_c fs18">科室专家</div>
                <ul class="dct_cnt">
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt><a href="" target="_blank" class="fl"><img src="images/doctor.jpg" width="48" height="58" alt=""></a></dt>
                            <dd class="fl">
                                <a href="" target="_blank" class="fl block">刘浩斌（专病门诊）</a><br>
                                <span class="fs12 block">主任医师</span>
                                <b class="fl">擅长：</b><p class="fs12">从事内科临床工作十多年，积累丰富的内科疾病诊治经验，从事内分泌专科临床工作多年，对糖尿病、甲亢、痛风、继发性高血压、垂体及肾上腺等内分泌疾病有丰富的诊治经验。</p>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="orderdata fl">
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
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
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                        </li>
                        <li class="afternoon od_cnt_time clearfix">
                            <div class="fl">下<br>午</div>
                            <div class="fr">下<br>午</div>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_out">已过期</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_access">预约<br>(16/21)</a>
                            <a href="javascript:void(0);" class="fl t_c block fs12 od_btn order_null"></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="bar_middle fl">（ 今日 <strong>18:00</strong> 开始可预约至<strong> 06 月 19 日</strong>号源，<strong>16:00</strong> 截止<strong> 06 月 12 日</strong>号源的预约 ）</div>
            <div class="dpt_page fl t_c">
                <a class="inline-block t_c page_on" href="javascript:void(0);">1</a>
                <a class="inline-block t_c" href="javascript:void(0);">2</a>
            </div>
        </div>
    </div>
</div>
<div class="footer center t_c">
    <p>客服电话 110&nbsp;&nbsp;&nbsp;&nbsp;报警电话 110</p>
    <p>版权所有 Copyright©2014-9999 我什么都不知道 All rights reserved</p>
</div>
</div>
<div class="login_bg absolute center"><div class="lg_bg fixed center"></div></div>
<div class="lg_cnt center fixed">
    <div class="lg_tt">
        <span>登录</span>
        <a href="javascript:void(0);" class="t_c block fr loginclose">×</a>
    </div>
    <form class="lg_form relative" action="login.action" method="post" name="login">
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
        <input type="pwd" class="login_btn center t_c" value="登录">
    </form>
</div>

</body>
</html>