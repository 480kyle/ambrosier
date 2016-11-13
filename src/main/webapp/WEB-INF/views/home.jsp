<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
	<title>Get Your Own Wine - SRC</title>
</head>
<body>
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '{your-app-id}',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div id="status">
</div>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.7&appId=1194800360541248";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<div id="tout">
  <div>
    <div>
      <div>
      </div>
    </div>
  </div>
</div>
<div class="colorHeader">
	<div class="title">
		<div class="colorLogoWrapper">
			<img class="logoColor" src="resources/icons/srcLogo.png">
		</div>
	</div>
</div>
<div class="infoComment">
	<h3>와인의 향기를 친구와 나누세요.</h3>
</div>
<div class="regFormWrapper" id="regForm">
	<div class="f_signinWrapper">
		<div id="f_signinBtn" class="f_signinBtn">
			<div class="fbBtnContent"><img class="facebookIcon" src="resources/icons/facebook.svg"></div>
			<div class="fbBtnContent">페이스북으로 로그인 하기</div>
		</div>
	</div>
	<div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false"></div>
	<div class="or">
		<div class="divLine"></div>
		<div class="divText">또는</div>
		<div class="divLine"></div>
	</div>
	<form id="regForm" name="regForm" action="m_join" method="post">
		<div class="textbox">
			<input id="userEmail" class="text" type="text" name="m_email" placeholder="Email">
		</div>
		<div class="textbox">
			<input id="userPass" class="text" type="password" name="m_password" placeholder="Password">
		</div>
		<div class="textbox">
			<input id="userNick" class="text" type="text" name="m_nick" placeholder="Nickname">
		</div>
		<div class="genderWrapper">
			<div class="genMale"><input type="radio" name="m_gender" id="male" value="1" checked="checked"><label class="genLabel maleLabel" for="male">남자</label></div>
			<div class="genFemale"><input type="radio" name="m_gender" id="female" value="2"><label class="genLabel femaleLabel" for="female">여자</label></div>
		</div>
		<div class="majorWrapper">
			<select class="selectLarge" name="m_major">
				<option>전공</option>
				<option>건축학부</option>
				<option>경영학부</option>
				<option>경제학과</option>
				<option>국어국문학과</option>
				<option>국제무역학과</option>
				<option>국제법무학과</option>
				<option>글로벌미디어학부</option>
				<option>글로벌통상학과</option>
				<option>금융경제학과</option>
				<option>금융학부</option>
				<option>기계공학과</option>
				<option>기독교학과</option>
				<option>독어독문학과</option>
				<option>문예창작전공</option>
				<option>물리학과</option>
				<option>법학과</option>
				<option>벤처경영학과</option>
				<option>벤처중소기업학과</option>
				<option>불어불문학과</option>
				<option>사학과</option>
				<option>사회복지학부</option>
				<option>산업정보시스템공학과</option>
				<option>소프트웨어학부</option>
				<option>수학과</option>
				<option>스마트시스템소프트웨어학과</option>
				<option>언론홍보학과</option>
				<option>영어영문학과</option>
				<option>영화예술전공</option>
				<option>유기신소재파이버공학과</option>
				<option>의생명시스템학부</option>
				<option>일어일문학과</option>
				<option>전기공학부</option>
				<option>전자정보공학부</option>
				<option>정보사회학과</option>
				<option>정보통계보험수리학과</option>
				<option>정치외교학과</option>
				<option>중어중문학과</option>
				<option>철학과</option>
				<option>컴퓨터학부</option>
				<option>평생교육학과</option>
				<option>행정학부</option>
				<option>화학공학과</option>
				<option>화학과</option>
				<option>회계학과</option>
				<option>Other</option>
			</select>
		</div>
		<div class="textbox">
			<input id="userStdId" class="text" type="number" name="m_stdId" placeholder="Student ID">
		</div>
		<div class="textbox">
			<input id="userPhone" class="text" type="text" name="m_phone" placeholder="Phone Number(숫자만 입력)">
		</div>
		<select class="selectSmall selectYear" name="m_year">
			<option>생년</option>
			<c:forEach begin="0" end="50" var="b_year">
				<option value="${2010 - b_year}">${2010 - b_year}년</option>
			</c:forEach>
		</select>
		<select class="selectSmall selectMonth" name="m_month">
			<option>월</option>
			<c:forEach begin="1" end="12" var="b_month">
				<option value="${b_month}">${b_month}월</option>
			</c:forEach>
		</select>
			<%-- <c:if test="${b_month}"></c:if> --%>
		<select class="selectSmall selectDate" name="m_date">
			<option>일</option>
			<c:forEach begin="1" end="31" var="b_date">
				<option value="${b_date}">${b_date}일</option>
			</c:forEach>
		</select>
		<div class="preference">
			<div class="title">
				<span class="text">와인을 얼마나 좋아하세요?</span>
			</div>
			<div class="prefIcons">
				<input type="radio" name="m_preference" id="pre1" value="1"><label for="pre1"><img class="prefIcon" id="1" src="resources/icons/pref.svg"></label>
				<input type="radio" name="m_preference" id="pre2" value="2"><label for="pre2"><img class="prefIcon" id="2" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="m_preference" id="pre3" value="3" checked="checked"><label for="pre3"><img class="prefIcon" id="3" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="m_preference" id="pre4" value="4"><label for="pre4"><img class="prefIcon" id="4" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="m_preference" id="pre5" value="5"><label for="pre5"><img class="prefIcon" id="5" src="resources/icons/nonpref.svg"></label>
			</div>
		</div>
		<div class="textbox textboxLarge">	
			<textarea class="textLarge" name="m_userwants" cols="50" rows="50" placeholder="자신을 표현해주세요!" style="resize:none;"></textarea>
		</div>
		<div class="submitBtn" id="submitBtn_join">가입하기</div>
		<div class="agreeAndPrivate">가입하면 Ambrosia.com의 <a href="agr">약관</a> 및 <a href="prv">개인정보취급방침</a>에 동의하게 됩니다.</div>
	</form>
</div>
<div class="regFormWrapper" id="signinForm">
	<form id="signinForm" name="signinForm" action="m_signin" method="post">
		<div class="textbox">
			<input id="signinID" class="text" type="text" name="m_email" placeholder="Email">
		</div>
		<div class="textbox">
			<input id="signinPW" class="text" type="password" name="m_password" placeholder="Password">
		</div>
		<div class="submitBtn" id="submitBtn_signin">로그인하기</div>
	</form>
</div>
<div class="loginPage" id="loginPage">계정이 있으신가요? <a class="loginLink" id="loginLink">로그인</a></div>
<div class="signupPage" id="signupPage">계정이 없으신가요? <a class="signupLink" id="signupLink">가입하기</a></div>
<div class="copyright">© 2016 AMBROSIER.COM</div>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/sh2encode.js"></script>
<script type="text/javascript" src="resources/js/home.js"></script>
</body>
</html>
