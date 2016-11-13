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
	<div class="searchBar">
		<div class="searchIconWrapper">
			<img class="searchIcon" src="resources/icons/search.svg">
		</div>
		<div class="textbox">
			<input id="keyword" class="text" type="text" placeholder="검색" autocomplete="off" autofocus>
		</div>
		<input id="category" type="hidden" value="recent">
	</div>
	<div class="font">
		<div id="recent" class="searchCategory">최근</div>
		<div id="people" class="searchCategory">사람</div>
		<div id="wine" class="searchCategory">와인</div>
		<div id="aroma" class="searchCategory">아로마</div>
	</div>
	<div id="searchResultBox" class="searchImgBox">
		<c:forEach var="datas" items="${datas}">
			<div class="resultWrapper">
				<div class="iconWrapper"><img class="icon" src="resources/icons/${datas.k_category}.svg"></div>
				<div class="keyword">${datas.k_keyword}</div>
			</div>
		</c:forEach>
	</div>
</div>
<script type="text/javascript" src="resources/js/signedinSearch.js"></script>
<script type="text/javascript" src="resources/js/signedinSearchPage.js"></script>
</body>
</html>