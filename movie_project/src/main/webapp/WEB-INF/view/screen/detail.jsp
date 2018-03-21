<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>스크린 상세 화면</h1>

<div>
	<input type="hidden" name="id" value="${screen.id }">
	<input type="text" name="no" value="${screen.no }" readonly="readonly"><br>
	<input type="text" name="theaterid" value="${theater.id }" readonly="readonly"><br>
	<input type="text" name="seats" value="${theater.seats }" readonly="readonly"><br>
	<input type="text" name="uploader" value="${theater.uploader }" readonly="readonly">
</div>

<h2><a href="/theater/edit">상영관 수정</a></h2>
<h2><a href="/theater/delete">상영관 삭제</a></h2>