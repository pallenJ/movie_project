<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>현재 개봉 영화 화면</h1>
<c:forEach var="list" items="${list }">
	<h2>${list.title }</h2>
</c:forEach>

<a href='<c:url value="movie/register"/>'>영화 등록</a><br>
<a href='<c:url value="movie/list"/>'>나의 영화 리스트 (영화사 입장 -> 현재 id : member11)</a>