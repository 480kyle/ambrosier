/**
 * 
 */
window.onload = function(){
	var wineCode = 0;
	
	document.getElementById("winePicture").onchange = function(){
		readURL(this);
		document.getElementById("fileInputWrapper").style.display = "none";
		document.getElementById("cancelAndNextBox").style.display = "block";
	};
	document.getElementById("cancel").onclick = function(){
		document.getElementById("fileInputWrapper").style.display = "block";
		document.getElementById("previewUpload").style.display = "none";
		document.getElementById("cancelAndNextBox").style.display = "none";
	}
	
	$("#wineName").keyup(function(){
		var keyword = $(this).val();
		wineNameSearch(keyword);
	});
	
	var browserName  = navigator.appName;
	var nAgt = navigator.userAgent;
	var verOffset = nAgt.indexOf("Chrome");
	
	console.log(verOffset);
	if(verOffset != -1){
		document.styleSheets[0].insertRule("input[type=range]::-webkit-slider-thumb{width:62px; height:62px;}",0);
		document.getElementById("wineBody").onchange = function(){
			var size = 17 + (parseInt(this.value) * 15);
			//console.log(size);
			document.styleSheets[0].addRule("input[type=range]#wineBody::-webkit-slider-thumb", "width:" + size + "px; height:" + size + "px;");
		}
		document.getElementById("wineAcidity").onchange = function(){
			var size = 17 + (parseInt(this.value) * 15);
			//console.log(size);
			document.styleSheets[0].addRule("input[type=range]#wineAcidity::-webkit-slider-thumb", "width:" + size + "px; height:" + size + "px;");
		}
		document.getElementById("wineSweetness").onchange = function(){
			var size = 17 + (parseInt(this.value) * 15);
			//console.log(size);
			document.styleSheets[0].addRule("input[type=range]#wineSweetness::-webkit-slider-thumb", "width:" + size + "px; height:" + size + "px;");
		}
	}
	
	document.getElementById("berries").onclick = function(){
		if(this.checked){
			document.getElementById("berryIcon").setAttribute("src","resources/icons/berry_actif.svg");
			document.getElementById("berryTag").style.color = "black";
		}else{
			document.getElementById("berryIcon").setAttribute("src","resources/icons/berry.svg");
			document.getElementById("berryTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("citrus").onclick = function(){
		if(this.checked){
			document.getElementById("citrusIcon").setAttribute("src","resources/icons/citrus_actif.svg");
			document.getElementById("citrusTag").style.color = "black";
		}else{
			document.getElementById("citrusIcon").setAttribute("src","resources/icons/citrus.svg");
			document.getElementById("citrusTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("apple").onclick = function(){
		if(this.checked){
			document.getElementById("appleIcon").setAttribute("src","resources/icons/apple_actif.svg");
			document.getElementById("appleTag").style.color = "black";
		}else{
			document.getElementById("appleIcon").setAttribute("src","resources/icons/apple.svg");
			document.getElementById("appleTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("mineral").onclick = function(){
		if(this.checked){
			document.getElementById("mineralIcon").setAttribute("src","resources/icons/mineral_actif.svg");
			document.getElementById("mineralTag").style.color = "black";
		}else{
			document.getElementById("mineralIcon").setAttribute("src","resources/icons/mineral.svg");
			document.getElementById("mineralTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("floral").onclick = function(){
		if(this.checked){
			document.getElementById("floralIcon").setAttribute("src","resources/icons/floral_actif.svg");
			document.getElementById("floralTag").style.color = "black";
		}else{
			document.getElementById("floralIcon").setAttribute("src","resources/icons/floral.svg");
			document.getElementById("floralTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("honey").onclick = function(){
		if(this.checked){
			document.getElementById("honeyIcon").setAttribute("src","resources/icons/honey_actif.svg");
			document.getElementById("honeyTag").style.color = "black";
		}else{
			document.getElementById("honeyIcon").setAttribute("src","resources/icons/honey.svg");
			document.getElementById("honeyTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("bread").onclick = function(){
		if(this.checked){
			document.getElementById("breadIcon").setAttribute("src","resources/icons/bread_actif.svg");
			document.getElementById("breadTag").style.color = "black";
		}else{
			document.getElementById("breadIcon").setAttribute("src","resources/icons/bread.svg");
			document.getElementById("breadTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("chocolate").onclick = function(){
		if(this.checked){
			document.getElementById("chocolateIcon").setAttribute("src","resources/icons/chocolate_actif.svg");
			document.getElementById("chocolateTag").style.color = "black";
		}else{
			document.getElementById("chocolateIcon").setAttribute("src","resources/icons/chocolate.svg");
			document.getElementById("chocolateTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("wood").onclick = function(){
		if(this.checked){
			document.getElementById("woodIcon").setAttribute("src","resources/icons/wood_actif.svg");
			document.getElementById("woodTag").style.color = "black";
		}else{
			document.getElementById("woodIcon").setAttribute("src","resources/icons/wood.svg");
			document.getElementById("woodTag").style.color = "#d0d0d0";
		}
	}
	document.getElementById("bad").onclick = function(){
		if(this.checked){
			document.getElementById("badIcon").setAttribute("src","resources/icons/bad_actif.svg");
			document.getElementById("badTag").style.color = "black";
		}else{
			document.getElementById("badIcon").setAttribute("src","resources/icons/bad.svg");
			document.getElementById("badTag").style.color = "#d0d0d0";
		}
	}

	document.getElementById("1").onclick = function(){
		clear(this);
	}
	document.getElementById("2").onclick = function(){
		clear(this);
	}
	document.getElementById("3").onclick = function(){
		clear(this);
	}
	document.getElementById("4").onclick = function(){
		clear(this);
	}
	document.getElementById("5").onclick = function(){
		clear(this);
	}
	
	document.getElementById("submitBtn_tastingnote").onclick = function(){
		if($("#winePicture").val() == "" || $("#winePicture").val() == null){
			alert("사진을 넣어주세요.");
			return;
		}
		if($("wineName").val() === ""){
			alert("와인 이름을 입력해주세요.");
			return;
		}
		if($("wineVintage").val() === ""){
			alert("생산년도가 없으면 nv를 입력해주세요.");
			return;
		}
//		if($("#wineCategory").val() === ""){
//			alert("와인 종류를 골라주세요.");
//			return;
//		}
		if($("[name=t_aromas]:checked").length === 0){
			alert("와인 향을 골라주세요.");
			return;
		}
		if($("#winePrice").val() === ""){
			alert("구입가격을 입력해주세요.");
			return;
		}
		document.tastingnote.submit();
	}
	
	document.getElementById("submitBtn_main").onclick = function(){
		location.href = "target?go=home";
	}
	
	$("#wineName").click(function(){
		var readOnly = $(this).attr("readonly");
		if(readOnly === "readonly"){
			$(this).removeAttr("readonly");
			$("#wineCode").val(0);
			$("#wineName").val("");
			$("#wineVintage").val("");
			$("#wineCategory").val("");
		}
	});
	
	$(".body").click(function(){
		$("#wineNameSearchResult").css("display", "none");
	});
}

function clear(e){
	var num = e.id;
	for(i = 1; i < 6; i++){
		document.getElementById(i).src = "resources/icons/nonpref.svg"; 
	}
	
	while(num > 0){
		document.getElementById(num).src = "resources/icons/pref.svg";
		num--;
	}
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function(e) {
        	document.getElementById("previewUpload").setAttribute("src", e.target.result);
        	document.getElementById("previewUpload").style.display = "block";
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function wineNameSearch(keyword){
	if(keyword === "") return;
	$.ajax({
		url: "searchWineNameWhenTasting",
		data: "k=" + keyword,
		success: function(data){
			if(data == ""){
				$("#wineNameSearchResult").css("display", "none");
				return;
			}
			var str = "";
			str += "<div class='resultWrapper'>";
			$.each(data, function(i, data){
//				str += "<div id='" + data.w_code + "' name='" + data.w_name + "' class='result' onclick='wnFunc(" + data.w_code + ")'>" + data.w_name + "</div>";
				str += "<div id='" + data.w_code + "' name='" + data.w_name + "-" + data.w_vintage + "-" + data.w_category + "' class='result'>" + data.w_name + data.w_vintage + "</div>";
//				str += data.w_name + " ";
			});
			str += "</div>";
			$("#wineNameSearchResult").html(str);
			$("#wineNameSearchResult").css("display", "block");
			$(".result").click(function(){

			});
			$(".result").click(function(){
				wnFunc($(this).attr("id"));
			});
//			var results = $(".result")
//			for(i = 0; i < results.length; i++){
//				
//				results[i].addEventListener("click", function(event){
//					$("#wineName").val(event.srcElement.getAttribute("name"));
//				});
//			}
		}
	});
}

function wnFunc(code){
	var wcode = code;
	var str = $("#" + code).attr("name").split("-");
	var wname = str[0];
	var wvintage = str[1];
	var wcategory = str[2];
	
	$("#wineCode").val(wcode);
	$("#wineName").val(wname);
	$("#wineVintage").val(wvintage);
	$("#wineCategory").val(wcategory);
	$("#wineName").attr("readonly", "readonly");
	$("#wineVintage").attr("readonly", "readonly");
	
	$("#wineNameSearchResult").css("display", "none");
}