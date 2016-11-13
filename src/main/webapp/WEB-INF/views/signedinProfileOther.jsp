<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/css/signedinProfile.css">
<link rel="stylesheet" type="text/css" href="resources/css/reply.css">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="arrive" value="null">
<input type="hidden" id="code" value="${member.m_code}">
<div class="topWrapper">
	<div class="iconWrapper">
		<img id="back" class="navicon" src="resources/icons/back.svg">
	</div>
</div>
<div class="body">
	<div class="profileInfoWrapper">
		<div class="prNick">${member.m_email}</div>
		<div class="prWrapper">
			<div class="prImgWrapper">
				<img class="prImg" src="${rootPath}/profileImages/${member.m_profile}">
			</div>
			<div class="numbersAndBtn">
				<div class="numbers">
					<div class="posts"><p id="posts" class="number"></p><p class="numText">포스트</p></div>
					<div class="followers"><p id="followers" class="number">0</p><p class="numText">팔로워</p></div>
					<div class="following"><p id="followings" class="number">0</p><p class="numText">팔로잉</p></div>
				</div>
				<div id="followBtn" name="${member.m_code}" class="followBtn">팔 로 우</div>
			</div>
		</div>
		<div class="prName">${member.m_nick}</div>
	</div>
	<div class="searchImgBox">
		<c:forEach var="datas" items="${datas}">
			<div class="searchImgWrapper">
				<a href="${rootPath}/tastingnote?c=${datas.t_code}">
					<img class="searchImg" src="${rootPath}/tastingImages/${datas.t_pname}.png">
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/otherProfile.js"></script>
<script type="text/javascript" src="resources/js/reply.js"></script>
</body>
</html>