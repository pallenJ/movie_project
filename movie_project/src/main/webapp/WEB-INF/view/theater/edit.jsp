<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화관 수정 화면 (지점입장)</h1>
<div>
	<h2>${theater.name }</h2>
	<form action="edit" method="post">
		<input type="hidden" name="id" value="${theater.id}">
		<input type="text" name="name" value="${theater.name }"><br>
		<input type="text" name="region" value="${theater.region }"><br>
		<input type="text" name="address" value="${theater.address }"><br>
		<input type="text" name="tel" value="${theater.tel }"><br>
		<input type="hidden" name="manager" value="${theater.manager}">
		<input type="submit" value="수정">
	</form>
</div>