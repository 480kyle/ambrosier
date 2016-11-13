window.onload = function(){
	
//	var num = 3;
//	for(i = 1; i < 6; i++){
//		document.getElementById(i).src = "resources/icons/nonpref.svg"; 
//	}
//	
//	while(num > 0){
//		document.getElementById(num).src = "resources/icons/pref.svg";
//		num--;
//	}
//	
//	document.getElementById("1").onclick = function(){
//		clear(this);
//	}
//	document.getElementById("2").onclick = function(){
//		clear(this);
//	}
//	document.getElementById("3").onclick = function(){
//		clear(this);
//	}
//	document.getElementById("4").onclick = function(){
//		clear(this);
//	}
//	document.getElementById("5").onclick = function(){
//		clear(this);
//	}
	document.getElementById("submitBtn_update").onclick = function(){
		checker();
	}
//	
//	document.getElementById("userPass").onblur = function(){
//		var pwd = $(this).val();
//		var passReg = /^([a-zA-Z0-9!@#$%^&*]){7,16}$/;
//		
//		if(pwd == "" || pwd == null){
//			return;
//		}
//		
//		if(!pwd.match(passReg)){
//			alert("7 - 16자리의 영문 대소문자, 숫자를 입력해주세요.");
//			document.getElementsByClassName("textbox")[1].style.border = "1px solid red";
//			document.regForm.m_password.focus();
//			return;
//		}else{
//			document.getElementsByClassName("textbox")[1].style.border = "1px solid lightgray";
//		}
//	}
//	
//	document.getElementById("userNick").onblur = function(){
//		var nick = $(this).val();
//		var nickReg = /^[a-zA-Z0-9]{4,8}$/;
//		
//		if(nick == "" || nick == null){
//			return;
//		}
//		
//		if(!nick.match(nickReg)){
//			alert("4 - 8자리의 영문과 숫자를 입력해주세요.");
//			document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
//			document.regForm.m_nick.focus();
//			return;
//		}else{
//			document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
//		}
//		
//		$.ajax({
//			url:"userNickCheck",
//			data: "userNick=" + $(this).val(),
//			success: function(data){
////				console.log(data);
//				if(data){
//					return;
//				}else{
//					alert("이미 사용중인 별명입니다.");
//					document.regForm.m_nick.focus();
//					return;
//				}
//			},
//			fail: function(){
//				alert("다시 입력 해주세요.");
//				return;
//			}
//		});
//	}
	
	document.getElementById("userPhone").onblur = function(){
		var phone = $(this).val();
		var phoneReg = /^\d{3}\d{3,4}\d{4}$/;
		
		if(phone == "" || phone == null){
			return;
		}
		
		if(!phone.match(phoneReg)){
			alert("-를 제거한 숫자만 입력해주세요.");
			document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
			document.regForm.m_phone.focus();
			return;
		}else{
			document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
		}
	}
};

//function clear(e){
//	//alert(e.id);
//	var num = e.id;
//	for(i = 1; i < 6; i++){
//		document.getElementById(i).src = "resources/icons/nonpref.svg"; 
//	}
//	
//	while(num > 0){
//		document.getElementById(num).src = "resources/icons/pref.svg";
//		num--;
//	}
//}

function checker(){
//	var email = document.regForm.m_email.value;
//	var pwd = document.regForm.m_password.value;
//	var nick = document.regForm.m_nick.value;
//	var gender = document.regForm.m_gender.value;
//	var major = document.regForm.m_major.value;
//	var stdId = document.regForm.m_stdId.value;
	var phone = document.regForm.m_phone.value;
//	var year = document.regForm.m_year.value;
//	var month = document.regForm.m_month.value;
//	var date = document.regForm.m_date.value;
//	var preference = document.regForm.m_preference.value;
//	var activity = document.regForm.m_activity.value;
	
//	if(pwd == "" || pwd == null){
//		document.getElementsByClassName("textbox")[1].style.border = "1px solid red";
//		document.regForm.m_password.focus();
//		return;
//	}else{
//		document.getElementsByClassName("textbox")[1].style.border = "1px solid lightgray";
//	}
//	
	if(phone == "" || phone == null){
		document.getElementsByClassName("textbox")[2].style.border = "1px solid red";
		document.regForm.m_phone.focus();
		return;
	}else{
		document.getElementsByClassName("textbox")[2].style.border = "1px solid lightgray";
	}
	
	document.regForm.submit();
	
//	encode();
}
