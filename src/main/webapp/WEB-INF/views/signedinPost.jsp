<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
<link rel="stylesheet" type="text/css" href="${rootPath}/resources/css/signedinMain.css">
<link rel="stylesheet" type="text/css" href="${rootPath}/resources/css/reply.css">
</head>
<body>
<input type="hidden" id="rootPath" value="${rootPath}">
<div class="topWrapper">
	<div class="iconWrapper">
		<img id="back" class="navicon" src="${rootPath}/resources/icons/back.svg">
	</div>
</div>
	<div class="body">
		<div class="post">
			<div class="topInfoBar">
				<a href="${pageContext.request.contextPath}/otherProfile?c=${data.m_code}">
					<div class="profImgWrapper">
						<img class="profImg" src="${rootPath}/profileImages/${data.m_profile}">
					</div>
					<div class="memberNick">${data.m_nick}</div>
				</a>
				<div class="regTime">${data.t_dateandtime}</div>
			</div>
			<div class="tastingnotePicWrapper">
				<img class="tastingnotePic" src="${rootPath}/tastingImages/${data.t_pname}.png">
			</div>
			<div class="bottomInfoBar">
				<c:choose>
					<c:when test="${data.t_like != 0}">
						<div id="like${data.t_code}" class="likes">${data.t_like} likes</div>
					</c:when>
					<c:when test="${data.t_like == 0}">
						<div id="like${data.t_code}" class="likes"></div>
					</c:when>
				</c:choose>
				<div class="comments">
					<div class="commentInfo">
						<c:choose>
							<c:when test="${!empty data.t_aromas}">
								<div class="memberId">아로마: </div>
								<div class="aromas">${data.t_aromas}</div>
							</c:when>
						</c:choose>
					</div>
					<div id="commentLoad">
						<c:forEach var="reply" items="${data.reply}">
							<div class="commentInfo">
								<div class="memberId">${reply.r_mnick}</div>
								<div class="comment">${reply.r_comment}</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="addComment">
					<div class="likeImgWrapper">
						<img id="likeImg${data.t_code}" name="like" class="likeImg" src="resources/icons/like.svg" onclick="likeOrUnlike(${data.t_code})">
					</div>
					<div class="textbox">
						<input id="commentBox" name="${code}" class="text" type="text" placeholder="댓글 달기...">
						<div id="commentPostTasting" class="commentPostBtn">등록</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/reply.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/like.js"></script>
</body>
</html>