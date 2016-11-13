$(document).ready(function(){
	var screenSize = $(window).width();
	var imgSize = screenSize / 3;
	
	$(".searchImg").each(function(){
		$(this).css("width", imgSize);
	});
	
	$("#keywordLink").click(function(){
		searchClick();
	});
	
	
});

$(window).on("scroll", function() {
	var scrollHeight = $(document).height();
	var scrollPosition = $(window).height() + $(window).scrollTop();
	if ((scrollHeight - scrollPosition) / scrollHeight === 0) {
	    // when scroll to almost bottom of the page
		loadMore();
	}
});

function loadMore(){
	$.ajax({
		url: "tsearchImgLoadMore",
		data: "c=" + $("#lastTnote").val(),
		success: function(datas){
			showDatas(datas)
		}
	})
}

function showDatas(datas){
	//To show datas at view
	var screenSize = $(window).width();
	var imgSize = screenSize / 3;
	
	if(datas.length === 0){
		return;
	}
	
	$("#lastTnote").val(datas[datas.length - 1].t_code);
	for(i = 0; i < datas.length; i++){
		var data = datas[i];
		var searchImgWrapper = $("<div></div>").attr({class: "searchImgWrapper", style: "width: " + imgSize + "px;"})
			.append($("<a></a>").attr("href", "tastingnote?c=" + data.t_code)
						.append($("<img/>").attr({
							class: "searchImg",
							src: "tastingImages/" + data.t_pname + ".png",
							style: "width: " + imgSize + "px;"
						}))
					);
		searchImgWrapper.appendTo($("#searchImgBox"));
	}
}

function searchClick(){
	var host = document.location.hostname;
	switch (host)
	{
	        case "ambrosier.com":
				location.href = "/ambrosia/searchPage"; break;
	        case "localhost" :
	        	location.href = "/tasting/searchPage"; break;
	        case "192.168.0.5" :
	        	location.href = "/tasting/searchPage"; break;
	}
}