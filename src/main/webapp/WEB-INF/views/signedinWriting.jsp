<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
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
	<form name="tastingnote" action="t_share" enctype="multipart/form-data" method="post">
		<div id="cancelAndNextBox" class="cancelAndNextWrapper">
			<div class="cancelAndNext">
				<a id="cancel">다시찍기</a><a id="next"></a>
			</div>
		</div>
<%-- 		<div class="dateAndTime">
			<select class="selectSmall selectYear" name="t_year">
				<option>연도</option>
				<c:forEach begin="0" end="50" var="t_year">
					<option value="${2010 - t_year}">${2010 - t_year}년</option>
				</c:forEach>
			</select>
			<select class="selectSmall selectMonth" name="t_month">
				<option>월</option>
				<c:forEach begin="1" end="12" var="t_month">
					<option value="${t_month}">${t_month}월</option>
				</c:forEach>
			</select>
				<c:if test="${b_month}"></c:if>
			<select class="selectSmall selectDate" name="t_date">
				<option>일</option>
				<c:forEach begin="1" end="31" var="t_date">
					<option value="${t_date}">${t_date}일</option>
				</c:forEach>
			</select>
		</div> --%>
		<div class="tastingFormWrapper">
		<section id="stepOne">
			<div class="tastingCamWrapper">
				<div class="tastingCam"><img id="previewUpload" src=""></div>
			</div>
			<div id="fileInputWrapper" class="camera">
				<input id="winePicture" name="t_picture" type="file" accept="image/*">
			</div>
		</section>
		<section id="stepTwo">
			<div class="textbox">
				<input id="wineName" name="t_wname" type="text" placeholder="와인이름" autocomplete="off">
			</div>
			<div id="wineNameSearchResult" class="searchResult">
				<!-- <div id="newWine" class="newWine"><p class="plus">+</p><p class="plusComment">새로운 와인 첫등록하기</p></div> -->
			</div>
			<input id="wineCode" name="t_wcode" type="hidden" value="0">
			<div class="textbox">
				<input id="wineVintage" name="t_vintage" type="number" placeholder="생산년도">
			</div>
			<div class="textbox">
				<input id="wineCategory" name="t_category" type="text" placeholder="와인분류" readonly="readonly">
			</div>
			<!-- <div class="selectionbox">
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
			</div> -->
			<!-- <div class="selectionbox">
				<select id="wineVariety" name="t_variety"></select>
			</div> -->
		</section>
		<section id="stepThree">
<!-- 		
			<div class="colorPicker">
				
			</div>
			<div class="deepness">
				<input id="colorDeepness" name="t_deep" type="range">
			</div>
-->
			<div class="wineBody">
				<div class="label">바디감</div>
				<div class="labelLeft">1</div><div class="labelMiddle">3</div><div class="labelRight">5</div>
				<input id="wineBody" name="t_body" min="1" max="5" type="range">
			</div>
			<div class="wineAcidity">
				<div class="label">산도</div>
				<div class="labelLeft">1</div><div class="labelMiddle">3</div><div class="labelRight">5</div>
				<input id="wineAcidity" name="t_acidity" min="1" max="5" type="range">
			</div>
			<div class="wineSweetness">
				<div class="label">당도</div>
				<div class="labelLeft">1</div><div class="labelMiddle">3</div><div class="labelRight">5</div>
				<input id="wineSweetness" name="t_sweetness" min="1" max="5" type="range">
			</div>
			<div class="wineAromas">
				<div class="label aromaLabel">아로마</div>
				<div class="checkboxWrapper">
					<div class="aromaWrapper">
						<input id="berries" name="t_aromas" type="checkbox" value="berries">
							<label for="berries">
								<div id="berryWrapper" class="labelWrapper">
									<img id="berryIcon" class="aromaIcon" src="resources/icons/berry.svg">
									<p id="berryTag" class="aromaTag">베리류</p>
								</div>
							</label>
						<input id="citrus" name="t_aromas" type="checkbox" value="citrus">
							<label for="citrus">
								<div id="citrusWrapper" class="labelWrapper">
									<img id="citrusIcon" class="aromaIcon" src="resources/icons/citrus.svg">
									<p id="citrusTag" class="aromaTag">레몬향</p>
								</div>
							</label>
						<input id="apple" name="t_aromas" type="checkbox" value="apple">
							<label for="apple">
								<div id="appleWrapper" class="labelWrapper">
									<img id="appleIcon" class="aromaIcon" src="resources/icons/apple.svg">
									<p id="appleTag" class="aromaTag">사과향</p>
								</div>
							</label>
						<input id="floral" name="t_aromas" type="checkbox" value="floral">
							<label for="floral">
								<div id="floralWrapper" class="labelWrapper">
									<img id="floralIcon" class="aromaIcon" src="resources/icons/floral.svg">
									<p id="floralTag" class="aromaTag">꽃향기</p>
								</div>
							</label>
						<input id="honey" name="t_aromas" type="checkbox" value="honey">
							<label for="honey">
								<div id="honeyWrapper" class="labelWrapper">
									<img id="honeyIcon" class="aromaIcon" src="resources/icons/honey.svg">
									<p id="honeyTag" class="aromaTag">꿀냄새</p>
								</div>
							</label>
					</div>
					<div class="aromaWrapper">
						<input id="mineral" name="t_aromas" type="checkbox" value="mineral">
							<label for="mineral">
								<div id="mineralWrapper" class="labelWrapper">
									<img id="mineralIcon" class="aromaIcon" src="resources/icons/mineral.svg">
									<p id="mineralTag" class="aromaTag">미네랄</p>
								</div>
							</label>
						<input id="bread" name="t_aromas" type="checkbox" value="bread">
							<label for="bread">
								<div id="breadWrapper" class="labelWrapper">
									<img id="breadIcon" class="aromaIcon" src="resources/icons/bread.svg">
									<p id="breadTag" class="aromaTag">빵냄새</p>
								</div>
							</label>
						<input id="chocolate" name="t_aromas" type="checkbox" value="chocolate">
							<label for="chocolate">
								<div id="chocolateWrapper" class="labelWrapper">
									<img id="chocolateIcon" class="aromaIcon" src="resources/icons/chocolate.svg">
									<p id="chocolateTag" class="aromaTag">초콜릿</p>
								</div>
							</label>
						<input id="wood" name="t_aromas" type="checkbox" value="wood">
							<label for="wood">
								<div id="woodWrapper" class="labelWrapper">
									<img id="woodIcon" class="aromaIcon" src="resources/icons/wood.svg">
									<p id="woodTag" class="aromaTag">나무향</p>
								</div>
							</label>
						<input id="bad" name="t_aromas" type="checkbox" value="bad">
							<label for="bad">
								<div id="badWrapper" class="labelWrapper">
									<img id="badIcon" class="aromaIcon" src="resources/icons/bad.svg">
									<p id="badTag" class="aromaTag">나쁜향</p>
								</div>
							</label>
					</div>
				</div>
			</div>
			<div class="label">점수</div>
			<div class="prefIcons">
				<input type="radio" name="t_preference" id="pre1" value="1" checked="checked"><label for="pre1"><img class="prefIcon" id="1" src="resources/icons/pref.svg"></label>
				<input type="radio" name="t_preference" id="pre2" value="2"><label for="pre2"><img class="prefIcon" id="2" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="t_preference" id="pre3" value="3"><label for="pre3"><img class="prefIcon" id="3" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="t_preference" id="pre4" value="4"><label for="pre4"><img class="prefIcon" id="4" src="resources/icons/nonpref.svg"></label>
				<input type="radio" name="t_preference" id="pre5" value="5"><label for="pre5"><img class="prefIcon" id="5" src="resources/icons/nonpref.svg"></label>
			</div>
			<div class="textbox">
				<input id="winePrice" name="t_price" type="number" placeholder="와인 가격">
			</div>
			<div class="textarea">
				<textarea id="wineComment" name="t_comment" placeholder="와인에 대한 느낌"></textarea>
			</div>
			<div class="submitBtnSmall btnLeft" id="submitBtn_main">메인으로</div><div class="submitBtnSmall btnRight" id="submitBtn_tastingnote">공유하기</div>
		</section>
		</div>
	</form>
</div>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/signedinWriting.js"></script>
</body>
</html>