$(document).ready(function(){
	var code = $("#code").val();
	
	$.ajax({
		url: "followers",
		data: "c=" + code,
		success: function(data){
			$("#followers").html(data.followers);
			$("#followings").html(data.followings);
		}
	});
});