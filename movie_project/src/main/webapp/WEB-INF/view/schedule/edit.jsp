<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>
<h1>상영시간표 수정</h1>
<div>
	<form action='<c:url value="/schedule/edit"/>' method="post">
		<input name="id" type="hidden" value="${schedule.id}">
		<input type="text" name= movie value="${schedule.movie}">
		<input type="text" name= theater value="${schedule.theater}">
		<input type="text" name= screen value="${schedule.screen}">
		<input type="text" name= day value="${fn:substring(schedule.day, 0, 10)}">
		<input type="text" name= starttime value="${schedule.starttime}">
		<input type="text" name= endtime value="${schedule.endtime}">
		<input type="text" name= morning value="${schedule.morning}">
		<input type="text" name= night value=" ${schedule.night}">
		<input type = "submit" value="수정하기">
	</form>
</div>
</body>

