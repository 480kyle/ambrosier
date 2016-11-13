<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
<link rel="stylesheet" type="text/css" href="resources/css/signedinSearch.css">
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
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/signedinSearch.js"></script>
<script type="text/javascript" src="resources/js/reply.js"></script>
</body>
</html>