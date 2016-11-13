$(document).ready(function(){
	var screenSize = $(window).width();
	var imgSize = screenSize / 3;
	var searchImg = document.getElementsByClassName("searchImg");
	var searchImgWrapper = document.getElementsByClassName("searchImgWrapper");
	
	var code = $("#code").val();

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
		url: "followingCheck",
		data: "fl=" + code,
		success: function(data){
			if(data){
				$("#followBtn").attr("name", "unfollow").attr("class", "unfollowBtn").html("팔 로 잉");
			}
		}
	});
	
	$("#followBtn").click(function(){
		var followOrUnfollow = $(this).attr("name");
		
		if(followOrUnfollow === "unfollow"){
			$.ajax({
				url: "unfollow",
				data: "fl=" + code,
				success: function(){
					$("#followBtn").attr("name", code).attr("class", "followBtn").html("팔 로 우");
				}
			});
		}else{
			$.ajax({
				url: "follow",
				data: "fl=" + code,
				success: function(){
					$("#followBtn").attr("name", "unfollow").attr("class", "unfollowBtn").html("팔 로 잉");
				}
			});
		}
		
	});
});