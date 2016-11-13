$(document).ready(function(){
	var home = document.getElementsByClassName("navicon")[0];
	var search = document.getElementsByClassName("navicon")[1];
	var writing = document.getElementsByClassName("navicon")[2];
	var alarm = document.getElementsByClassName("navicon")[3];
	var profile = document.getElementsByClassName("navicon")[4];
	var arrive = document.getElementById("arrive").value;
	
	document.getElementById(arrive + "Icon").setAttribute("src", "resources/icons/" + arrive + "_actif.svg");
	
	if(arrive === "home"){
		bindClickToTopButtons();
		signedinMain();
//		console.log(bindClickToTopButtons().done);
//		.done(function(){
//			alert("aa");
//			signedinMain();
//		});
	}else{
		bindClickToTopButtons();
	}
	
//	var screenSize = screen.width;
	var screenSize = $(window).width();
	var imgSize = screenSize / 3;
	var searchImg = document.getElementsByClassName("searchImg");
	var searchImgWrapper = document.getElementsByClassName("searchImgWrapper");
	
	for(i = 0; i < searchImg.length; i++){
		searchImg[i].style.width = imgSize + "px";
		searchImgWrapper[i].style.width = imgSize + "px";
	}
	
	if(searchImg.length === 0){
		$("#posts").html(0);
	}else{
		$("#posts").html(searchImg.length);
	}
	
	$.ajax({
		url: "alarmCount",
		success: function(data){
			if(data === 0){
				$("#alarmCount").css("display", "none");
			}else{
				$("#alarmCount").css("display", "inline-block");
				$("#alarmCount").html(data);
			}
		}
	});
});

function bindClickToTopButtons(){
	var def = $.Deferred();
	
	document.getElementById("home").onclick = function(){
		//alert(home.getAttribute("id") + "_actif");
		home.setAttribute("src", "resources/icons/home_actif.svg");
		search.setAttribute("src", "resources/icons/search.svg");
		writing.setAttribute("src", "resources/icons/writing.svg");
		alarm.setAttribute("src", "resources/icons/alarm.svg");
		profile.setAttribute("src", "resources/icons/profile.svg");
		location.href = "target?go=home";
	}
	
	document.getElementById("search").onclick = function(){
		//alert("search");
		search.setAttribute("src", "resources/icons/search_actif.svg");
		home.setAttribute("src", "resources/icons/home.svg");
		writing.setAttribute("src", "resources/icons/writing.svg");
		alarm.setAttribute("src", "resources/icons/alarm.svg");
		profile.setAttribute("src", "resources/icons/profile.svg");
		location.href = "target?go=search";
	}
	
	document.getElementById("writing").onclick = function(){
		//alert("writing");
		writing.setAttribute("src", "resources/icons/writing_actif.svg");
		search.setAttribute("src", "resources/icons/search.svg");
		home.setAttribute("src", "resources/icons/home.svg");
		alarm.setAttribute("src", "resources/icons/alarm.svg");
		profile.setAttribute("src", "resources/icons/profile.svg");
		location.href = "target?go=writing";
	}
	
	document.getElementById("alarm").onclick = function(){
		//alert("alarm");
		alarm.setAttribute("src", "resources/icons/alarm_actif.svg");
		search.setAttribute("src", "resources/icons/search.svg");
		writing.setAttribute("src", "resources/icons/writing.svg");
		home.setAttribute("src", "resources/icons/home.svg");
		profile.setAttribute("src", "resources/icons/profile.svg");
		location.href = "target?go=alarm";
	}
	
	document.getElementById("profile").onclick = function(){
		//alert("profile");
		profile.setAttribute("src", "resources/icons/profile_actif.svg");
		search.setAttribute("src", "resources/icons/search.svg");
		writing.setAttribute("src", "resources/icons/writing.svg");
		alarm.setAttribute("src", "resources/icons/alarm.svg");
		home.setAttribute("src", "resources/icons/home.svg");
		location.href = "target?go=profile";
	}
	
	return def.promise();
}