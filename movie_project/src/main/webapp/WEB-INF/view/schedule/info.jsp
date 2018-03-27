<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>상영시간표 상세 조회 화면</h1>
<div>
	<h1>ㄹㅇ : ${schedule}</h1>
	<h2>영화id : ${schedule.movie}</h2>
	<h2>영화제목 : ${schedule.movietitle}</h2>
	<h2>theaterid : ${schedule.theater}</h2>
	<h2>screenid : ${schedule.screen}</h2>
	<h2>day : ${schedule.day}</h2>
	<h2>starttime : ${schedule.starttime}</h2>
	<h2>endtime : ${schedule.endtime}</h2>
	<h2>morning : ${schedule.morning}</h2>
	<h2>night : ${schedule.night}</h2>
</div>
<h3><a href='<c:url value="/schedule/edit?scheduleid=${schedule.id }"/>'>상영시간표 수정</a></h3>
<h3><a href='<c:url value="/schedule/delete?scheduleid=${schedule.id }"/>'>상영시간표 삭제</a></h3>
<h3><a href='<c:url value="/schedule/list"/>'>목록으로</a></h3>
