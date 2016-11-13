<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="ambrosier_top.jsp" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/signedinMain.css">
<title>Insert title here</title>
</head>
<body>
<div id="body" class="body">
	<c:forEach var="datas" items="${tastingDatas}" varStatus="status">
	<c:if test="${status.last}">
		<input id="lastTnote" type="hidden" value="${datas.t_code}">
	</c:if>
		<div class="post">
			<div class="topInfoBar">
				<a href="${rootPath}/otherProfile?c=${datas.m_code}">
					<div class="profImgWrapper">
						<%-- <img class="profImg" data-src="${datas.m_profile}" src="${rootPath}/profileImages/${datas.m_profile}"> --%>
						<img class="profImg" data-src="${datas.m_profile}">
					</div>
					<div class="memberNick">${datas.m_nick}</div>
				</a>
				<div class="regTime">${datas.t_dateandtime}</div>
			</div>
			<div class="tastingnotePicWrapper">
				<img class="tastingnotePic" src="${rootPath}/tastingImages/${datas.t_pname}.png">
			</div>
			<div class="bottomInfoBar">
				<c:choose>
					<c:when test="${datas.t_like != 0}">
						<div id="like${datas.t_code}" class="likes">${datas.t_like} 좋아요</div>
					</c:when>
					<c:when test="${datas.t_like == 0}">
						<div id="like${datas.t_code}" class="likes"></div>
					</c:when>
				</c:choose>
				<div class="comments">
					<div class="commentInfo">
						<c:choose>
							<c:when test="${!empty datas.t_aromas}">
								<%-- <div class="memberId">아로마: </div>
								<div class="aromas">${datas.t_aromas}</div> --%>
								<div class="aromas" data-aromas="${datas.t_aromas}"></div>
							</c:when>
						</c:choose>
					</div>
					<div id="commentLoad${datas.t_code}">
						<c:if test="${fn:length(datas.reply) > 0}">
							<c:forEach var="reply" items="${datas.reply}" end="1">
								<div class="commentInfo">
									<div class="memberId">${reply.r_mnick}</div>
									<div class="comment">${reply.r_comment}</div>
								</div>
							</c:forEach>
							<c:if test="${fn:length(datas.reply) > 3}">
								<div id="commentMore" class="commentMore"><a class="comment commentMoreLink" onclick="commentClick(${datas.t_code})">${fn:length(datas.reply) - 2}개의 댓글 더보기</a></div>
							</c:if>
						</c:if>
					</div>
				</div>
				<div class="addComment">
					<div class="likeImgWrapper">
						<img id="likeImg${datas.t_code}" name="like" class="likeImg" src="resources/icons/like.svg" onclick="likeOrUnlike(${datas.t_code})">
					</div>
					<div class="textbox">
						<input id="commentBox${datas.t_code}" class="text" type="text" placeholder="댓글 달기..." onfocus="commentClick(${datas.t_code})">
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<!-- <div class="loadBtnWrapper">
	<div id="loadBtn" class="loadBtn">더 보기</div>
</div> -->
<script type="text/javascript" src="resources/js/signedinMain.js"></script>
<script type="text/javascript" src="resources/js/like.js"></script>
</body>
</html>