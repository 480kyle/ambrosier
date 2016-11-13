function commentClick(code){
	var host = document.location.hostname;
	switch (host)
	{
	        case "ambrosier.com":
				location.href = "/ambrosia/commentLoadMore?code=" + code; break;
	        case "localhost" :
	        	location.href = "/tasting/commentLoadMore?code=" + code; break;
	        case "192.168.0.5" :
	        	location.href = "/tasting/commentLoadMore?code=" + code; break;
	}
}

function signedinMain(){
	$(".profImg").each(function(){
		var src = $(this).attr("data-src");
		$(this).attr("src", "profileImages/" + src);
	});
	
	makeAromaLink();
	
	$(".aromaLink").on("click", function(){
		var keyword = $(this).html();
		
		switch(keyword){
		case "베리류": 
			keyword = "berries";
			break;
		case "레몬향": 
			keyword = "citrus";
			break;
		case "사과향": 
			keyword = "apple";
			break;
		case "꽃향기": 
			keyword = "floral";
			break;
		case "꿀냄새": 
			keyword = "honey";
			break;
		case "미네랄": 
			keyword = "mineral";
			break;
		case "빵냄새": 
			keyword = "bread";
			break;
		case "초콜렛": 
			keyword = "chocolate";
			break;
		case "나무향": 
			keyword = "wood";
			break;
		case "나쁜향": 
			keyword = "bad";
			break;
		}
		
		var host = document.location.hostname;
		switch (host)
		{
		        case "ambrosier.com":
					location.href = "/ambrosia/aromaLink?k=" + keyword; break;
		        case "localhost" :
		        	location.href = "/tasting/aromaLink?k=" + keyword; break;
		        case "192.168.0.5" :
		        	location.href = "/tasting/aromaLink?k=" + keyword; break;
		}
	});
//	$("#loadBtn").on("click", function(){
//		loadMore();
//	});
}

$(window).on("scroll", function() {
	var scrollHeight = $(document).height();
	var scrollPosition = $(window).height() + $(window).scrollTop();
//	console.log("scrollTop: " + $(window).scrollTop() + " / windowHeight: " + $(window).height() + " / scrollHeight: " + $(document).height());
//	console.log((scrollHeight - scrollPosition) / scrollHeight);
	if ((scrollHeight - scrollPosition) / scrollHeight === 0) {
	    // when scroll to almost bottom of the page
		loadMore();
	}
});

function loadMore(){
	$.ajax({
		url: "tnoteLoadMore",
		data: "c=" + $("#lastTnote").val(),
		success: function(datas){
			showDatas(datas)
		}
	})
}

function showDatas(datas){
	
	if(datas.length === 0){
		$("#loadBtn").css("display", "none");
		return;
	}
	
	
	$("#lastTnote").val(datas[datas.length - 1].t_code);
	for(i = 0; i < datas.length; i++){
		var data = datas[i];
		var post = $("<div></div>").attr("class","post");
		var topInfoBar = $("<div></div>").attr("class", "topInfoBar");
		var tastingnotePicWrapper = $("<div></div>").attr("class", "tastingnotePicWrapper");
		var bottomInfoBar = $("<div></div>").attr("class", "bottomInfoBar");
		
		topInfoBar.append($("<a></a>").attr("href", "otherProfile?c=" + data.m_code)
				.append($("<div></div>").attr("class", "profImgWrapper")
						.append($("<img/>").attr({class: "profImg", src : "profileImages/" + data.m_profile}))
				)
				.append($("<div></div>").attr("class", "memberNick").append(data.m_nick))
		)
		.append($("<div></div>").attr("class", "regTime").append(data.t_dateandtime));
		
		tastingnotePicWrapper.append($("<img/>").attr({class: "tastingnotePic", src: "tastingImages/" + data.t_pname + ".png"}));
		
		if(data.t_like > 0){
			bottomInfoBar.append($("<div></div>").attr({id: "like" + data.t_code, class: "likes"})
					.append(data.t_like + "좋아요")
			);
		}else{
			bottomInfoBar.append($("<div></div>").attr({id: "like" + data.t_code, class: "likes"}));
		}
		
		var comments = $("<div></div>").attr("class", "comments");
		var commentInfo = $("<div></div>").attr("class", "commentInfo");
		var commentLoad = $("<div></div>").attr("class", "commentLoad" + data.t_code);
		var addComment = $("<div></div>").attr("class", "addComment");
		
		if(data.t_aromas.length > 0){
			commentInfo.append(
					$("<div></div>").attr({
						class: "aromas",
						"data-aromas": data.t_aromas
					})
			);
		}
		
		
		if(data.reply.length > 2){
			for(j = 0; j < 2; j++){
				commentLoad.append(
						$("<div></div>").attr("class", "commentInfo")
						.append($("<div></div").attr("class", "memberId")
								.append(data.reply[j].r_mnick)
						)
						.append(
								$("<div></div>").attr("class", "comment")
								.append(data.reply[j].r_comment)
						)
				);
			}
			commentLoad.append(
					$("<div></div>").attr({
						id: "commentMore",
						class: "commentMore"
					})
					.append(
							$("<a></a>").attr({
								class: "comment commentMoreLink",
								onclick: "commentClick(" + data.t_code + ")"
							})
							.append((data.reply.length - 2) + "개의 댓글 더보기")
					)
			);
		}
		
		comments.append(commentInfo);
		comments.append(commentLoad);
		
		comments.appendTo(bottomInfoBar);
		
		addComment.append(
				$("<div></div>").attr("class", "likeImgWrapper")
				.append($("<img/>").attr({
					id: "likeImg" + data.t_code,
					name: "like",
					class: "likeImg",
					src: "resources/icons/like.svg",
					onclick: "likeOrUnlike(" + data.t_code + ")"
				}))
		);
		
		addComment.append(
				$("<div></div>").attr("class", "textbox")
				.append($("<input/>").attr({
					id: "commentBox" + data.t_code,
					class: "text",
					placeholder: "댓글 달기...",
					onfocus: "commentClick(" + data.t_code + ")"
				}))
		);
		
		addComment.appendTo(bottomInfoBar);
		
		topInfoBar.appendTo(post);
		tastingnotePicWrapper.appendTo(post);
		bottomInfoBar.appendTo(post);
		
		post.appendTo("#body");
		makeAromaLink();
	}
}

function makeAromaLink(){
	$(".aromas").each(function(){
		var div = $(this);
		var aromas = div.attr("data-aromas")
		var aroma = aromas.split(",");
		
		if(div.html()){
			return;
		};
		
		for(k = 0; k < aroma.length; k++){
			switch(aroma[k]){
			case "berries": 
				aroma[k] = "베리류";
				break;
			case "citrus": 
				aroma[k] = "레몬향";
				break;
			case "apple": 
				aroma[k] = "사과향";
				break;
			case "floral": 
				aroma[k] = "꽃향기";
				break;
			case "honey": 
				aroma[k] = "꿀냄새";
				break;
			case "mineral": 
				aroma[k] = "미네랄";
				break;
			case "bread": 
				aroma[k] = "빵냄새";
				break;
			case "chocolate": 
				aroma[k] = "초콜렛";
				break;
			case "wood": 
				aroma[k] = "나무향";
				break;
			case "bad": 
				aroma[k] = "나쁜향";
				break;
			}
			
			var aromaLink = $("<a></a>").attr("class", "aromaLink").append(aroma[k]);
			div.append(aromaLink);
		}
	});
}

//$(".post").scroll(function() {
//	  var elem = $(".post");
//
//	  if ( elem[0].scrollHeight - elem.scrollTop() == elem.outerHeight())
//	    {
//	        alert("End of Yellow");
//	    }
//});
//
//$(window).scroll(function(){
//    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
//        alert('End of Window');
//    }
//});