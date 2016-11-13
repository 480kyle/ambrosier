<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/signedinWriting.css">
</head>
<body>
<div class="colorHeader">
	<div class="title">
		<div class="colorLogoWrapper">
			<img class="logoColor" src="resources/icons/srcLogo.png">
		</div>
	</div>
</div>
<div class="noteWrapper">
	<form id="wineInfoForm" name="wineInfo" method="post">
		<div class="tastingFormWrapper">
		<section id="stepTwo">
			<input id="wineCode" type="hidden" name="w_code" value="${wineCode}">
			<div class="textbox">
				<input id="wineName" name="w_name" type="text" value="${wineName}" readonly="readonly" autocomplete="off">
			</div>
			<div class="textbox">
				<input id="wineVintage" name="w_vintage" type="number" placeholder="생산년도">
			</div>
			<div class="selectionbox">
				<select class="selectLarge" id="wineCategory" name="t_category">
					<option>와인분류</option>
					<option>Red</option>
					<option>Rose</option>
					<option>White</option>
					<option>Sparkling</option>
					<option>Champagne</option>
					<option>Dessert</option>
					<option>Fortified</option>
				</select>
			</div>
			<div class="textbox">
				<input id="wineVarieties" name="w_varieties" type="text" placeholder="품종">
			</div>
			<div class="textbox">
				<input id="wineRegion" name="w_region" type="text" placeholder="생산국가">
			</div><div class="textbox">
				<input id="wineMaker" name="w_maker" type="text" placeholder="생산자">
			</div>
			<div class="textbox">
				<input id="wineImporter" name="w_importer" type="text" placeholder="수입회사">
			</div>
		</section>
		<div class="submitBtn" id="submitBtn_wineInfo">와인 정보 입력</div>
		</div>
	</form>
</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/signedinNewWine.js"></script>
</body>
</html>