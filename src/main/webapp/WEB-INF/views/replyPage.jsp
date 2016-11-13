<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
<link rel="stylesheet" type="text/css" href="resources/css/reply.css">
<title>Insert title here</title>
</head>
<body>
<div class="topWrapper">
	<div class="iconWrapper">
		<img id="back" class="navicon" src="resources/icons/back.svg">
	</div>
</div>
<div class="body">
	<div id="commentLoad">
		<c:forEach var="reply" items="${reply}">
			<div class="commentInfo">
				<div class="profImgWrapper">
					<img class="profImg" src="${pageContext.request.contextPath}/profileImages/${reply.m_profile}">
				</div>
					<div class="memberId">${reply.r_mnick}</div>
					<div class="comment">${reply.r_comment}</div>
			</div>
		</c:forEach>
	</div>
	<div class="addComment">
		<div class="textbox">
			<input id="commentBox" name="${code}" class="text" type="text" placeholder="댓글 달기..." autofocus>
			<div id="commentPost" class="commentPostBtn">등록</div>
		</div>
	</div>
</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/reply.js"></script>
</body>
</html>