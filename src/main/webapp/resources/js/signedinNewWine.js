/**
 * 
 */
$(document).ready(function(){
	$("#submitBtn_wineInfo").on("click", function(){
		$("#wineInfoForm").attr("action", "w_update");
		document.wineInfo.submit();
	});
});