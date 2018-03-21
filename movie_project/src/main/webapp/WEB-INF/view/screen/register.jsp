<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>스크린 등록 화면</h1>
<div>
	<form action="register" method="post">
		<input type="text" name="no" placeholder="상영관번호"><br>
		<input type="text" name="theater" placeholder="지점명"><br>
		<input type="text" name="seats" placeholder="좌석수"><br>
		<input type="text" name="uploader" value="${sessionScope.id }" readonly="readonly"><br>
		<input type="submit" value="등록">
	</form>
</div>