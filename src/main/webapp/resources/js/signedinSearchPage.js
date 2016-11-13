/**
 * 
 */
$(document).ready(function(){

	$("#recent").css("border-bottom", "2px solid rgb(150,12,63)");
	
	$(".searchCategory").click(function(){
		var str = "";
		setCategory($(this).attr("id"));
		$("#searchResultBox").html(str);
		$("#keyword").val("");
		$("#keyword").focus();
	});
	
	$("#keyword").keyup(function(){
		var keyword = $("#keyword").val();
		var category = $("#category").val();
		
		if(keyword === ""){
			return;
		}
		
		if(category === "aroma"){
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
			search(keyword, category);
		}else{
			search(keyword, category);
		}
	});
});

function setCategory(category){
	$(".searchCategory").css("border-bottom", "1px solid #f0f0f0")
	$("#" + category).css("border-bottom", "2px solid rgb(150,12,63)");
	$("#category").val(category);
}

function search(keyword, category){
	$.ajax({
		url: "search",
		data: "w=" + keyword + "&c=" + category,
		success: function(data){
			if(data.category === "recent"){
				var str = "";
				for(i=0; i < data.result.length; i++){
					str += "<div class='resultWrapper'>";
					str += "<div class='resultImgWrapper'><img class='resultImg' src='resources/icons/" + data.result[i].k_category + ".svg'></div>";
					str += "<div class='keyword'>" + data.result[i].k_keyword + "</div>";
					str += "</div>";
				}
				$("#searchResultBox").html(str);
			}else if(data.category === "people"){
				var str ="";
				for(i=0; i < data.result.length; i++){
					str += "<div class='resultWrapper profile' data-link='" + data.result[i].m_code + "'>";
					str += "<div class='resultImgWrapper'><img class='resultImg' src='profileImages/" + data.result[i].m_profile + "'></div>";
					str += "<div class='contextWrapper'>";
					str += "<div class='resultName'>" + data.result[i].m_nick + "</div>";
					str += "<div class='resultDescript'>" + data.result[i].m_userwants + "</div>";
					str += "</div>";
					str += "</div>";
				}
				$("#searchResultBox").html(str);
				$(".profile").click(function(){
					linkToProfile($(this).attr("data-link"));
				});
			}else if(data.category === "wine"){
				var str = "";
				for(i=0; i < data.result.length; i++){
					str += "<div class='resultWrapper tasting' data-link='" + data.result[i].t_code + "'>";
					str += "<div class='resultImgWrapper'><img class='resultImg' src='tastingImages/" + data.result[i].t_pname + ".png'></div>";
					str += "<div class='contextWrapper'>";
					str += "<div class='resultName'>" + data.result[i].w_name + "</div>";
					str += "<div class='resultPreference'>" + data.result[i].t_preference + "</div>";
					str += "</div>";
					str += "</div>";
				}
				$("#searchResultBox").html(str);
				$(".tasting").click(function(){
					linkToTastingnote($(this).attr("data-link"));
				});
			}else if(data.category === "aroma"){
				var str ="";
				for(i=0; i < data.result.length; i++){
					str += "<div class='resultWrapper tasting' data-link='" + data.result[i].t_code + "'>";
					str += "<div class='resultImgWrapper'><img class='resultImg' src='tastingImages/" + data.result[i].t_pname + ".png'></div>";
					str += "<div class='contextWrapper'>";
					str += "<div class='resultName'>" + data.result[i].w_name + "</div>";
					str += "<div class='resultPreference'>" + data.result[i].t_preference + "</div>";
					str += "</div>";
					str += "</div>";
				}
				$("#searchResultBox").html(str);
				$(".tasting").click(function(){
					linkToTastingnote($(this).attr("data-link"));
				});
			}
		}
	});
}

function linkToProfile(code){
	location.href = "otherProfile?c=" + code;
}

function linkToTastingnote(code){
	location.href = "tastingnote?c=" + code;
}