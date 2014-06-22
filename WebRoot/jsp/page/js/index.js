/*nav*/
window.onscroll = function fix() {
   var nav = document.getElementById("nav"),
       header = document.getElementById("header"),
      top = header.getBoundingClientRect().top;
   if (top < 36) {
           nav.style.position = "fixed";
           nav.style.borderBottom = "1px solid #eee";
   } else {
           nav.style.position = "position";
           nav.style.borderBottom = "none";
   }
}
$(function(){
   $(".city a").mouseover(function(){
      $(".citylist").fadeIn();
   });
   $(".citylist").mouseleave(function(){
      $(".citylist").fadeOut();
   });
});

/*login*/
$(function(){
   var bodyheight = document.body.scrollHeight;
   var loginheight = document.documentElement.clientHeight;
   var lgbgheight = ( loginheight - $(".lg_bg").height() ) / 2 + "px";
   var lgcntheight = ( loginheight - $(".lg_cnt").height() ) / 2 + "px";
   $(".login_bg").height(bodyheight);
   $(".login a").click(function(){
      $(".login_bg").fadeIn();
      $(".lg_cnt").fadeIn();
      $(".lg_bg").css("margin-top",lgbgheight);
      $(".lg_cnt").css("margin-top",lgcntheight);
   });
   $(".loginclose").click(function(){
      $(".login_bg").fadeOut();
      $(".lg_cnt").fadeOut();
   });
   $(".login_btn").click(function(){
      $(".login_bg").fadeOut();
      $(".lg_cnt").fadeOut();
   });

   $(".lg_cnt li").find("input").blur(function(){
      if($("#uid").val() == ""){
         $(".wrong span").text("请输入手机号码或电子邮箱!");
         $(".wrong").fadeIn();
      }else{
         if($("#pwd").val() == ""){
            $(".wrong span").text("请输入登录密码!");
            $(".wrong").fadeIn();
         }else{
            if($("#vcc").val() == ""){
               $(".wrong span").text("请输入有效的校验码，填入右边图片中的文字!");
               $(".wrong").fadeIn();
            }
            else{
               $(".wrong").fadeOut();
            }
         }
      }
   });
});
 
/*side_login*/
$(function(){
   $(".s_l_bd li").children("input").each(function(){
      $(this).focus(function(){
         $(this).parent("li").addClass("login-li-on");
      });
      $(this).blur(function(){
         $(this).parent("li").removeClass("login-li-on");
      });
   });
});

/*hospital*/
$(function(){
   $(".hs_cnt li").each(function(){
      $(".hs_cnt li:first").addClass("hs_act");
      $(this).mouseover(function(){
         $(".hs_cnt li").removeClass("hs_act");
         $(this).addClass("hs_act");
      });
      $(this).find("dl").each(function(){
         var cnt = $(this).find("span");
         if(cnt.text().length > 11){
            var txt = cnt.text().substring(0,11) + "...";
            cnt.text(txt);
         }
      });
   });
});

/*dc_info*/
$(function(){
   
   $(".dc_tab li:first").addClass("dc_act");
   $(".dc_tabbox").show();
   
   $(".dc_info_pd").each(function(){
      if($(this).text().length > 26){
         var txt = $(this).text().substring(0,26) + "...";
         $(this).text(txt);
      }
   });
   
   $(".dc_tab li:first").addClass("dc_act");
   $(".dc_tab a").each(function(){
      $(this).click(function(){
         $(".dc_tab li").removeClass("dc_act");
         $(this).parent("li").addClass("dc_act");
         var activetab ="#" + $(this).parent("li").attr("tab");
         $(".dc_tabcnt").hide();
         $(activetab).show();
      });
   });
});

/*focus*/
$(function(){
   var time = null,
      num = 0;

   function next(){
      num = num + 1;
      if(num >= $("#fcs_tab li").length){
         num = 0;
      }
      tab();
   }

   function focustime(){
      time = setInterval(next,5000);
   }

   $("#fcs_tab li").each(function(){
      $(this).mouseover(function(){
         clearInterval(time);
         num = $(this).index();
         tab();
      });
      $(this).mouseout(function() {
         focustime();
      });
   });

   function tab(){
      var ml = 0 - num * 650 + "px";
      $("#fcs_cnt").animate({left:ml});
      $("#fcs_tab li").removeClass("fcs_on");
      $("#fcs_tab li").each(function(){
         if($(this).index() == num){
            $(this).addClass("fcs_on");
         }
      });
   }

   focustime();
});

/*regist*/
$(function(){
   $(".rg_cnt li").find("input").each(function(){
      $(this).blur(function(){
         if($(this).val() == ""){
            $(this).siblings("label").fadeIn();
            document.getElementById("commit").disabled=true;
         }else{
            $(this).siblings("label").hide();
            document.getElementById("commit").disabled=false;
         }
      });
   });
});

$(function(){
   
      $("#commit").click(function(){
         $(".rg_cnt li").find("input").each(function(){
            if($(this).val() == ""){
            $(this).siblings("label").fadeIn();
            return false;
         }else{
            $("#regist").submit();
            $(this).siblings("label").hide();
            document.getElementById("commit").disabled=false;
         }});
         
      });
});

$(function(){
   var mess;
      $("#uid").blur(function(){
         if(!IdCardValidate($("#uid").val())){
            $(this).siblings("label").fadeIn();
            $(this).siblings("b").hide();
            document.getElementById("commit").disabled=true;
         }else{
            checkUserName($("#uid").val());
            if(mess == "error"){
               $(this).siblings("b").fadeIn();
               $(this).siblings("label").hide();
               document.getElementById("commit").disabled=true;
               }else{
                  $(this).siblings("label").hide();
                  $(this).siblings("b").hide();
                  document.getElementById("commit").disabled=false;
               }
         }
            
         });
      function checkUserName(userId) {
         //1.创建xmlHttpRequest对象.
         var xmlHttp;
         try {// Firefox, Opera 8.0+, Safari
            xmlHttp = new XMLHttpRequest();
         } catch (e) {// Internet Explorer 
            try {
               xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
               try {
                  xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
               } catch (e) {
                  return false;
               }
            }
         }
         //2.这是回调函数
         xmlHttp.onreadystatechange = function() {       
            if (xmlHttp.readyState == 4) { //服务器响应完毕     
               if(xmlHttp.status==200){ //是否正常响应
                  mess = xmlHttp.responseText; //获得服务器响应的文本
                  return mess;
               }
            }
         }
             //3. 拼装URL
             var url = "checkId.action";
             url = url + "?user_id=" + userId;
            //4. 打开连接
            xmlHttp.open("POST",url,false);
            //5. 发送请求
            xmlHttp.send();
      }
});



/*IdCardValidate 身份证校验*/
var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子   
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];            // 身份证验证位值.10代表X   
function IdCardValidate(idCard) { 
  idCard = trim(idCard.replace(/ /g, ""));               //去掉字符串头尾空格                     
  if (idCard.length == 15) {   
      return isValidityBrithBy15IdCard(idCard);       //进行15位身份证的验证    
  } else if (idCard.length == 18) {   
      var a_idCard = idCard.split("");                // 得到身份证数组   
      if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
          return true;   
      }else {
          
          return false;   
      }   
  } else { 
      return false;   
  }   
}   

/* 判断身份证号码为18位时最后的验证位是否正确  
@param a_idCard 身份证号码数组  */

function isTrueValidateCodeBy18IdCard(a_idCard) {   
  var sum = 0;                             // 声明加权求和变量   
  if (a_idCard[17].toLowerCase() == 'x') {   
      a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作   
  }   
  for ( var i = 0; i < 17; i++) {   
      sum += Wi[i] * a_idCard[i];            // 加权求和   
  }   
  valCodePosition = sum % 11;                // 得到验证码所位置   
  if (a_idCard[17] == ValideCode[valCodePosition]) {   
      return true;   
  } else {   
      return false;   
  }   
}   

/*验证18位数身份证号码中的生日是否是有效生日  
@param idCard 18位书身份证字符串  */

function isValidityBrithBy18IdCard(idCard18){   
  var year =  idCard18.substring(6,10);   
  var month = idCard18.substring(10,12);   
  var day = idCard18.substring(12,14);   
  var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
  // 这里用getFullYear()获取年份，避免千年虫问题   
  if(temp_date.getFullYear()!=parseFloat(year)   
        ||temp_date.getMonth()!=parseFloat(month)-1   
        ||temp_date.getDate()!=parseFloat(day)){   
          return false;   
  }else{   
      return true;   
  }   
}   

/*验证15位数身份证号码中的生日是否是有效生日  
 @param idCard15 15位书身份证字符串 */

function isValidityBrithBy15IdCard(idCard15){   
    var year =  idCard15.substring(6,8);   
    var month = idCard15.substring(8,10);   
    var day = idCard15.substring(10,12);   
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
    // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
    if(temp_date.getYear()!=parseFloat(year)   
            ||temp_date.getMonth()!=parseFloat(month)-1   
            ||temp_date.getDate()!=parseFloat(day)){   
              return false;   
      }else{   
          return true;   
      }   
}   
/*去掉字符串头尾空格 */
function trim(str) {   
  return str.replace(/(^\s*)|(\s*$)/g, "");   
} 


/*specialty*/
$(function(){
   $(".dct_cnt p").each(function(){
      if($(this).text().length > 22){
         var txt = $(this).text().substring(0,22) + "...";
         $(this).text(txt);
      }
   });
   var mh = $(".sp_cnt").height();
   $(".slidedown").click(function(){
      $(".dpt_pd p").css("height","100%");
      $(".slidedown").toggle();
      $(".slideup").toggle();
      var ah = $(".aside_cnt").height();
      if(ah > mh) {
         $(".aside").height(ah);
      }
   });
   $(".slideup").click(function(){
      $(".dpt_pd p").css("height","165px");
      $(".slidedown").toggle();
      $(".slideup").toggle();
      var ah = $(".aside_cnt").height();
      if(ah < mh) {
         $(".aside").height(mh);
      }
   });
});


$(function(){
   window.onload = function(){
      var mh = $(".sp_cnt").height(),
         ah = $(".aside_cnt").height();
      if(ah < mh) {
         $(".aside").height(mh);
      }else{
         $(".aside").height(ah);
      }
   }
});

$(function () {  
     var $day = $("#_birthday"),  
        $month = $("#_birthmonth"),  
        $year = $("#_birthyear");  
  
   /*出始化年*/
    var dDate = new Date(),  
        dCurYear = dDate.getFullYear(),  
        str = "";  
    for (var i = dCurYear - 100; i < dCurYear + 1; i++) {  
        if (i == dCurYear) {  
            str = "<option value=" + i + " selected=true>" + i + "</option>";  
        } else {  
            str = "<option value=" + i + ">" + i + "</option>";  
        }  
        $year.append(str);
    }  
  
    /*出始化月*/ 
    for (var i = 1; i <= 12; i++) {  
        if (i == (dDate.getMonth() + 1)) {  
            str = "<option value=" + i + " selected=true>" + i + "</option>";  
        } else {  
            str = "<option value=" + i + ">" + i + "</option>";  
        }  
        $month.append(str);  
    } 

   /*调用函数出始化日*/ 
    TUpdateCal($year.val(), $month.val());  
    $("#_birthyear,#_birthmonth").bind("change", function(){  
        TUpdateCal($year.val(),$month.val());  
    });  
}); 

/*根据年月获取当月最大天数*/  
function TGetDaysInMonth(iMonth, iYear) {  
    var dPrevDate = new Date(iYear, iMonth, 0);  
    return dPrevDate.getDate();  
}  
  
function TUpdateCal(iYear, iMonth) {  
    var dDate = new Date(),  
        daysInMonth = TGetDaysInMonth(iMonth, iYear),  
        str = "";  
  
    $("#_birthday").empty();  
  
    for (var d = 1; d <= parseInt(daysInMonth); d++) {  
        if (d == dDate.getDate()) {  
            str = "<option value=" + d + " selected=true>" + d + "</option>";  
        } else {  
            str = "<option value=" + d + ">" + d + "</option>";  
        }  
        $("#_birthday").append(str);  
    }  
} 