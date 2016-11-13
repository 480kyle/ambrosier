<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
	<title>Get Your Own Wine - SRC</title>
</head>
<body>
<div class="topWrapper">
	<div class="iconWrapper">
		<img id="back" class="navicon" src="resources/icons/back.svg">
	</div>
</div>
<div class="body">
	<div class="colorHeader">
		<div class="title">
			<div class="colorLogoWrapper">
				<img class="logoColor" src="resources/icons/srcLogo.png">
			</div>
		</div>
	</div>
	<div class="regFormWrapper" id="regForm">
		<form name="regForm" action="m_update" method="post">
			<input name="m_code" type="hidden" value="${member.m_code}">
			<div class="textbox">
				<input id="userEmail" class="text" type="text" name="m_email" value="${member.m_email}" placeholder="Email" readonly="readonly">
			</div>
			<div class="textbox">
				<input id="userNick" class="text" type="text" name="m_nick" value="${member.m_nick}" placeholder="Nickname" readonly="readonly">
			</div>
			<div class="textbox">
				<input id="userPhone" class="text" type="text" name="m_phone" value="${member.m_phone}" placeholder="Phone Number(숫자만 입력)">
			</div>
			<div class="textbox textboxLarge">	
				<textarea class="textLarge" name="m_userwants" cols="50" rows="50" value="${member.m_userwants}" placeholder="자신을 표현해주세요!" style="resize:none;"></textarea>
			</div>
			<div class="submitBtn" id="submitBtn_update">수정하기</div>
		</form>
	</div>
	<div class="copyright">© 2016 AMBROSIER.COM</div>
</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/sh2encode.js"></script>
<script type="text/javascript" src="resources/js/signedinProfileEdit.js"></script>
<script type="text/javascript" src="resources/js/reply.js"></script>
</body>
</html>
