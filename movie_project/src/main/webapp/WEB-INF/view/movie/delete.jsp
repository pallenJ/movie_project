<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화 삭제 화면</h1>
<div>
	<form action="delete" method="post">
		<input type="hidden" name="movieid" value=${movieid }>
		<input type="password" name="uploaderpw"> 
		<input type="submit" value="삭제">
	</form>
</div>	