<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화관 등록 화면</h1>
<div>
	<form action="register" method="post">
		<input type="text" name="name" placeholder="지점명"><br>
		<input type="text" name="region" placeholder="지역"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="text" name="tel" placeholder="전화번호"><br>
		<input type="text" name="manager" value="${session.id }"><br>
		<input type="submit" value="등록">
	</form>
</div>

<h2>${session.id }</h2>