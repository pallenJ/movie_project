<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화관 삭제 화면 (지점입장)</h1>
<div>
	<form action="delete" method="post">
		<input type="hidden" name="theaterid" value="${theater.id }">
		<input type="password" name="managerpw"><br>
		<input type="submit" value="삭제">
	</form>
</div>