$(document).ready(function(){
	$.ajax({
		url: "likeLoad",
		success: function(data){
			for(i = 0; i < data.length; i++){
				$("#likeImg" + data[i].l_tcode).attr("src", "resources/icons/like_actif.svg").attr("name", data[i].l_code);
			}
		}
	});
});

function likeOrUnlike(tcode){
	var likeOrNot = $("#likeImg" + tcode).attr("name");
	
	if(likeOrNot === "like"){
		like(tcode);
	}else{
		unlike(likeOrNot, tcode);
	}
}

function like(tc){
	$.ajax({
		url: "like",
		data: "tc=" + tc,
		success: function(data){
			$("#likeImg" + tc).attr("src", "resources/icons/like_actif.svg").attr("name", data);
			countLike(tc);
		}
	});
}

function unlike(lc, tc){
	$.ajax({
		url: "unlike",
		data: "lc=" + lc,
		success: function(){
			$("#likeImg" + tc).attr("src", "resources/icons/like.svg").attr("name", "like");
			countLike(tc);
		}
	});
}

function countLike(tc){
	$.ajax({
		url: "likeCount",
		data: "tc=" + tc,
		success: function(data){
			console.log(data);
			if(data === 0){
				$("#like" + tc).html("");
			}else{
				$("#like" + tc).html(data + " likes");
			}
		}
	});
}