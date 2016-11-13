$(document).ready(function(){
	$("#commentPost").click(function(){
		var comment = $("#commentBox").val();
		var code = $("#commentBox").attr("name");

		if(comment == null || comment == ""){
			return;
		}
		
		$.ajax({
			url: "commentIns",
			method: "post",
			data: {"comment": comment, "code": code},
			dataType:"json",
			success: function(reply){
//				console.log(reply);
				var str = "";
				for(i = 0; i < reply.length; i++){
					str += "<div class='commentInfo'>"
					str += "<div class='profImgWrapper'>"
					str += "<img class='profImg' src='profileImages/" + reply[i].m_profile + "'>"
					str += "</div>&nbsp;"
					str += "<div class='memberId'>" + reply[i].r_mnick + "</div>&nbsp;"
					str += "<div class='comment'>" + reply[i].r_comment + "</div>"
					str += "</div>";
				}
				$("#commentLoad").html(str);
				$("#commentBox").val("");
			}
		});
	});
	
	$("#commentPostTasting").click(function(){
		var comment = $("#commentBox").val();
		var code = $("#commentBox").attr("name");

		if(comment == null || comment == ""){
			return;
		}
		
		$.ajax({
			url: "commentIns",
			method: "post",
			data: {"comment": comment, "code": code},
			dataType:"json",
			success: function(reply){
//				console.log(reply);
				var str = "";

				for(i = 0; i < reply.length; i++){
					str += "<div class='commentInfo'>";
					str += "<div class='memberId'>" + reply[i].r_mnick + "</div>&nbsp;";
					str += "<div class='comment'>" + reply[i].r_comment + "</div>";
					str += "</div>";
				}
				
				$("#commentLoad").html(str);
				$("#commentBox").val("");
			}
		});
	});
	
	$("#back").click(function(){
//		if(document.referrer){
//			var loca = document.referrer;
//			window.locaiton = loca;
//		}else{
//			window.history.back();
//		}
		window.history.back();
	});
});

function commentLoad(code){
	$.ajax({
		url: "commentLoadMore",
		data: "t_code=" + code,
		success: function(reply){
			console.log(reply);
			for(i = 0; i < reply.length; i++){
				var str = "<div class='commentInfo'>"
				+ "<div class='memberId'>" + reply[i].r_mnick + "</div>"
				+ "<div class='comment'>" + reply[i].r_comment + "</div>"
				+ "</div>";
			}
			$("#commentLoad").html(str);
		},
		fail: function(){
			$("#commentLoad").html("댓글 로딩 실패");
		}
	});
}