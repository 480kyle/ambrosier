window.onload = function(){
	
	document.getElementById("signinForm").style.display = "block";
	document.getElementById("signupPage").style.display = "block";
	document.getElementById("regForm").style.display = "none";
	document.getElementById("loginPage").style.display = "none";
	
	document.getElementById("f_signinBtn").onclick = function(){
		alert("테스트 중입니다ㅠㅠ");
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
	document.getElementById("submitBtn_join").onclick = function(){
		checker();
	}
	document.getElementById("submitBtn_signin").onclick = function(){
		if($("#signinID").val() == null || $("#signinID").val() == ""){
			alert("이메일을 입력해주세요.");
			return;
		}
		
		if($("#signinPW").val() == null || $("#signinPW").val() == ""){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
		$("#tout:first-child div").css("display", "block");
		$("#regForm").css("opacity", "0");
		$("#signinForm").css("opacity", "0");
		signinEncode();
	}
	document.getElementById("loginLink").onclick = function(){
		document.getElementById("regForm").style.display = "none";
		document.getElementById("loginPage").style.display = "none";
		document.getElementById("signinForm").style.display = "block";
		document.getElementById("signupPage").style.display = "block";
		
	}
	document.getElementById("signupLink").onclick = function(){
		document.getElementById("signinForm").style.display = "none";
		document.getElementById("signupPage").style.display = "none";
		document.getElementById("regForm").style.display = "block";
		document.getElementById("loginPage").style.display = "block";
	}
	
	document.getElementById("userEmail").onblur = function(){
		var email = $(this).val();
		var emailReg = /^[0-9a-zA-Z][_0-9a-zA-Z\-_.]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		
		if(email == "" || email == null){
			return;
		}
		
		if(!email.match(emailReg)){
			alert("이메일을 정확히 입력해주세요.");
			document.getElementsByClassName("textbox")[0].style.border = "1px solid red";
			document.regForm.m_email.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[0].style.border = "1px solid lightgray";
		}
		
		$.ajax({
			url:"userIdCheck",
			data: "userId=" + $(this).val(),
			success: function(data){
				if(data){
					return;
				}else{
					alert("이미 사용중인 이메일입니다.");
					document.regForm.m_email.focus();
					return;
				}
			},
			fail: function(){
				console.log("fail");
				return;
			}
		});
	}
	
	document.getElementById("userPass").onblur = function(){
		var pwd = $(this).val();
		var passReg = /^([a-zA-Z0-9!@#$%^&*]){7,16}$/;
		
		if(pwd == "" || pwd == null){
			return;
		}
		
		if(!pwd.match(passReg)){
			alert("7 - 16자리의 영문 대소문자, 숫자를 입력해주세요.");
			document.getElementsByClassName("textbox")[1].style.border = "1px solid red";
			document.regForm.m_password.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[1].style.border = "1px solid lightgray";
		}
	}
	
	document.getElementById("userNick").onblur = function(){
		var nick = $(this).val();
		var nickReg = /^[a-zA-Z0-9]{4,8}$/;
		
		if(nick == "" || nick == null){
			return;
		}
		
		if(!nick.match(nickReg)){
			alert("4 - 8자리의 영문과 숫자를 입력해주세요.");
			document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
			document.regForm.m_nick.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
		}
		
		$.ajax({
			url:"userNickCheck",
			data: "userNick=" + $(this).val(),
			success: function(data){
//				console.log(data);
				if(data){
					return;
				}else{
					alert("이미 사용중인 별명입니다.");
					document.regForm.m_nick.focus();
					return;
				}
			},
			fail: function(){
				alert("다시 입력 해주세요.");
				return;
			}
		});
	}
	
	document.getElementById("userStdId").onblur = function(){
		var stdId = $(this).val();
		var stdIdReg = /^\d{8}$/;
		
		if(stdId == "" || stdId == null){
			return;
		}
		
		if(!stdId.match(stdIdReg)){
			alert("8자리 숫자를 입력해주세요.");
			document.getElementsByClassName("textbox")[3].style.border = "1px solid red";
			document.regForm.m_stdId.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[3].style.border = "1px solid lightgray";
		}
	}
	
	document.getElementById("userPhone").onblur = function(){
		var phone = $(this).val();
		var phoneReg = /^\d{3}\d{3,4}\d{4}$/;
		
		if(phone == "" || phone == null){
			return;
		}
		
		if(!phone.match(phoneReg)){
			alert("-를 제거한 숫자만 입력해주세요.");
			document.getElementsByClassName("textbox")[4].style.border = "1px solid red";
			document.regForm.m_phone.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[4].style.border = "1px solid lightgray";
		}
	}
};

function clear(e){
	//alert(e.id);
	var num = e.id;
	for(i = 1; i < 6; i++){
		document.getElementById(i).src = "resources/icons/nonpref.svg"; 
	}
	
	while(num > 0){
		document.getElementById(num).src = "resources/icons/pref.svg";
		num--;
	}
}

//function regChecker(){
//	var email = document.regForm.m_email.value;
//	var pwd = document.regForm.m_password.value;
//	var nick = document.regForm.m_nick.value;
//	var gender = document.regForm.m_gender.value;
//	var major = document.regForm.m_major.value;
//	var stdId = document.regForm.m_stdId.value;
//	var phone = document.regForm.m_phone.value;
//	var year = document.regForm.m_year.value;
//	var month = document.regForm.m_month.value;
//	var date = document.regForm.m_date.value;
//	var preference = document.regForm.m_preference.value;
//	var activity = document.regForm.m_activity.value;
//	
//	var emailReg = /^[0-9a-zA-Z][_0-9a-zA-Z\-_.]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
//	var passReg = /^([a-zA-Z0-9!@#$%^&*]){7,16}$/;
//	var nickReg = /^[a-zA-Z0-9]{4,8}$/;
//	var stdIdReg = /^\d{8}$/;
//	var phoneReg = /^\d{3}\d{3,4}\d{4}$/;
//	
//	var checkSuccess = false;
//	
//	if(!email.match(emailReg)){
//		alert("이메일을 정확히 입력해주세요.");
//		document.getElementsByClassName("textbox")[0].style.border = "1px solid red";
//		document.regForm.m_email.focus();
//		return checkSuccess;
//	}else{
//		document.getElementsByClassName("textbox")[0].style.border = "1px solid lightgray";
//		checkSuccess = true;
//	}
//
//	if(!pwd.match(passReg)){
//		alert("7 - 16자리의 영문 대소문자, 숫자를 입력해주세요.");
//		document.getElementsByClassName("textbox")[1].style.border = "1px solid red";
//		document.regForm.m_password.focus();
//		return checkSuccess;
//	}else{
//		document.getElementsByClassName("textbox")[1].style.border = "1px solid lightgray";
//		checkSuccess = true;
//	}
//	
//	if(!nick.match(nickReg)){
//		alert("4 - 8자리의 영문과 숫자를 입력해주세요.");
//		document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
//		document.regForm.m_nick.focus();
//		return checkSuccess;
//	}else{
//		document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
//		checkSuccess = true;
//	}
//	
//	if(!stdId.match(stdIdReg)){
//		alert("8자리 숫자만 입력해주세요.");
//		document.getElementsByClassName("textbox")[3].style.border = "1px solid red";
//		document.regForm.m_stdId.focus();
//		return checkSuccess;
//	}else{
//		document.getElementsByClassName("textbox")[3].style.border = "1px solid lightgray";
//		checkSuccess = true;
//	}
//	
//	if(!phone.match(phoneReg)){
//		alert("-를 제거한 숫자만 입력해주세요.");
//		document.getElementsByClassName("textbox")[4].style.border = "1px solid red";
//		document.regForm.m_phone.focus();
//		return checkSuccess;
//	}else{
//		document.getElementsByClassName("textbox")[4].style.border = "1px solid lightgray";
//		checkSuccess = true;
//	}
//	
//	return checkSuccess;
//}

function checker(){
	var email = document.regForm.m_email.value;
	var pwd = document.regForm.m_password.value;
	var nick = document.regForm.m_nick.value;
	var gender = document.regForm.m_gender.value;
	var major = document.regForm.m_major.value;
	var stdId = document.regForm.m_stdId.value;
	var phone = document.regForm.m_phone.value;
	var year = document.regForm.m_year.value;
	var month = document.regForm.m_month.value;
	var date = document.regForm.m_date.value;
	var preference = document.regForm.m_preference.value;
	
	if(email == "" || email == null){
		document.getElementsByClassName("textbox")[0].style.border = "1px solid red";
		document.regForm.m_email.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[0].style.border = "1px solid lightgray";
	}
	
	if(pwd == "" || pwd == null){
		document.getElementsByClassName("textbox")[1].style.border = "1px solid red";
		document.regForm.m_password.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[1].style.border = "1px solid lightgray";
	}
	
	if(nick == "" || nick == null){
		document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
		document.regForm.m_nick.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
	}
	
	if(major == "전공"){
		alert("전공을 선택하세요.");
		return;
	}
	
	if(stdId == "" || stdId == null){
		document.getElementsByClassName("textbox")[3].style.border = "1px solid red";
		document.regForm.m_stdId.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[3].style.border = "1px solid lightgray";
	}
	
	if(phone == "" || phone == null){
		document.getElementsByClassName("textbox")[4].style.border = "1px solid red";
		document.regForm.m_phone.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[4].style.border = "1px solid lightgray";
	}
	
	if(year == "생년"){
		alert("생년을 선택해주세요.");
		return;
	}else if(month == "월"){
		alert("월을 선택해주세요.");
		return;
	}else if(date == "일"){
		alert("생일을 선택해주세요.");
		return;
	}
	
	$("#tout:first-child div").css("display", "block");
	$("#regForm").css("opacity", "0");
	$("#signinForm").css("opacity", "0");
	encode();
}
