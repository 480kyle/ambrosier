<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="ambrosier_top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/signedinAlarm.css">
<title>Insert title here</title>
</head>
<body>
<div class="body">
	<c:forEach var="alarm" items="${alarm}">
		<c:choose>
			<c:when test="${alarm_event eq 'follow'}">
				<a href="otherProfile?c=${alarm.al_tcode}">
			</c:when>
			<c:otherwise>
				<a href="tastingnote?c=${alarm.al_tcode}">
			</c:otherwise>
		</c:choose>
		<div class="alarmWrapper">
			<div class="profImgWrapper">
				<img class="profImg" src="profileImages/${alarm.m_profile}">
			</div>
			<div class="comment">
				<div class="nickName">${alarm.al_from_mnick}</div>님이
				<div class="content">
					<c:choose>
						<c:when test="${alarm.al_event eq 'commented'}">
							게시물에 <b>댓글</b>을 남겼습니다.
						</c:when>
						<c:when test="${alarm.al_event eq 'like'}">
							게시물을 좋아합니다.
						</c:when>
						<c:when test="${alarm.al_event eq 'follow'}">
							<b>팔로잉</b>하고 있습니다.
						</c:when>
					</c:choose>
				</div>
			</div>
			<div class="time">${alarm.al_timeAgo}</div>
			<input type="hidden" value="${alarm.al_read}">
		</div>
		<%-- <div>${alarm.al_to_mnick}</div>
		<div>${alarm.al_event}</div>
		<div>${alarm.al_from_mnick}</div>
		<div>${alarm.al_dateandtime}</div>
		<div>${alarm.al_tcode}</div> --%>
	</a>
	</c:forEach>
</div>
</body>
</html>