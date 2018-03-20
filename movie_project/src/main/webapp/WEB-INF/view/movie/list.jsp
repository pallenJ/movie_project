<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>영화 목록 화면 (영화사 입장)</h1>
<div>
	<form action="list" method="post">
		<input type="text" name="uploaderid" placeholder="영화사">
		<input type="submit" value="검색">
	</form>
</div>
<div>
	<c:forEach var="list" items="${list }">
		<h2><a href="info?movieid=${list.id }">${list.title }</a></h2>
	</c:forEach>
</div>