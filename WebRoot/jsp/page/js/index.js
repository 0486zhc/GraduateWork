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
			var activetab = "#" + $(this).parent("li").attr("tab");
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
			focustime()
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
			}else{
				$(this).siblings("label").hide();
			}
		});
	});
});

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
