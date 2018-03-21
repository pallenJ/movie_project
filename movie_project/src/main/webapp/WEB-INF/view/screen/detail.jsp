<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>스크린 상세 화면</h1>

<div>
	<input type="hidden" name="id" value="${screen.id }">
	<input type="text" name="no" value="${screen.no }" readonly="readonly"><br>
	<input type="text" name="theaterid" value="${screen.theaterid }" readonly="readonly"><br>
	<input type="text" name="seats" value="${screen.seats }" readonly="readonly"><br>
	<input type="text" name="uploader" value="${screen.uploader }" readonly="readonly">
</div>

<h2><a href='<c:url value="/screen/edit?screenid=${screen.id }"/>'>상영관 수정</a></h2>
<h2><a href='<c:url value="/screen/delete?screenid=${screen.id }"/>'>상영관 삭제</a></h2>