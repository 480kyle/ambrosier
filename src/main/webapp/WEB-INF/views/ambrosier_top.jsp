<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/init.css">
<link rel="stylesheet" type="text/css" href="resources/css/top.css">
<div class="topWrapper">
	<div class="iconWrapper" id="home"><img class="navicon" id="homeIcon" src="resources/icons/home.svg"></div>
	<div class="iconWrapper" id="search"><img class="navicon" id="searchIcon" src="resources/icons/search.svg"></div>
	<div class="iconWrapper" id="writing"><img class="navicon" id="writingIcon" src="resources/icons/writing.svg"></div>
	<div class="iconWrapper" id="alarm"><img class="navicon" id="alarmIcon" src="resources/icons/alarm.svg"><div id="alarmCount" class="alarmCount"></div></div>
	<div class="iconWrapper" id="profile"><img class="navicon" id="profileIcon" src="resources/icons/profile.svg"></div>
</div>
<input type="hidden" id="arrive" value="${arrive}">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/ambrosier_top.js"></script>