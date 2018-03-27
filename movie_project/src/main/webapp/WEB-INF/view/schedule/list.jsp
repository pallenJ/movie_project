<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>${sessionScope.loginid}씨가 올린 상영시간표</h1>
<h1>${schedulelist}</h1>
<div>
	<c:forEach var="schedule" items="${schedulelist}">
		<h2>날짜 : ${fn:substring(schedule.day, 0, 10)}</h2>
		<h2>영화이름 : ${schedule.movietitle}</h2>
		<h2>몇관 : ${schedule.screenno}</h2>
		<h2>시작시간: ${schedule.starttime}</h2>
		<h2>좌석수 : ${schedule.seats}</h2>
		<h1><a href="info?scheduleid=${schedule.id}">상세보기</a></h1>
		<hr>
	</c:forEach>
</div>

		