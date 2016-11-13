<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="ambrosier_top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/signedinSearch.css">
<title>Insert title here</title>
</head>
<body>
<div class="body">
	<div class="searchBar" id="keywordLink">
		<div class="searchIconWrapper">
			<img class="searchIcon" src="resources/icons/search.svg">
		</div>
		<div class="textbox">
			<input class="text" type="text" placeholder="검색" disabled="disabled">
		</div>
	</div>
	<div id="searchResult" class="searchResultWrapper"></div>
	<div class="font">새로운 소식</div>
	<div id="searchImgBox" class="searchImgBox">
		<c:forEach var="datas" items="${datas}" varStatus="status">
			<c:if test="${status.last}">
				<input id="lastTnote" type="hidden" value="${datas.t_code}">
			</c:if>
			<div class="searchImgWrapper">
				<a href="${pageContext.request.contextPath}/tastingnote?c=${datas.t_code}">
					<img class="searchImg" src="${pageContext.request.contextPath}/tastingImages/${datas.t_pname}.png">
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<script type="text/javascript" src="resources/js/signedinSearch.js"></script>
</body>
</html>