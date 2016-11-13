$(document).ready(function(){
	$("#profPictureWrapper").click(function(){
		$("#pic").trigger("click");
	});
	
	$("#pic").change(function(){
		var data = new FormData();
		
		$.each($(this)[0].files, function(i, file){
			data.append("pic", file);
		});
		
		$.ajax({
			url:"profilePicUpdate",
			data: data,
			type:"post",
		    cache: false,
		    contentType: false,
		    processData: false,
			success: function(data){
				var host = document.location.hostname;
				$("#profPictureWrapper").html("<img id='profPicture' class='prImg' src='profileImages/" + data + "'>");
			},
			fail: function(){
				alert("다시 시도해 주십시오.");
			}
		});
	});
	
	$("#editProfile").click(function(){
		location.href = "profileEdit";
	});
	
	$("#logout").click(function(){
		location.href = "logout";
	});
});