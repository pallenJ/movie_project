<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>스크린 수정 화면</h1>
<div>
	<form action="edit" method="post">
		<input type="hidden" name="id" value="${screen.id }">
		<input type="text" name="no" value="${screen.no }"><br>
		<input type="text" name="theaterid" value="${screen.theaterid }" readonly="readonly"><br>
		<input type="text" name="seats" value="${screen.seats }"><br>
		<input type="text" name="uploader" value="${screen.uploader }" readonly="readonly"><br>
		<input type="submit" value="등록">
	</form>
</div>