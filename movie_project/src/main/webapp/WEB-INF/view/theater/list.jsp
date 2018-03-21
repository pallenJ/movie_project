<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>영화관 목록 화면</h1>
<div>
	<c:forEach var="list" items="${list }">
		<h2><a href='<c:url value="/theater/detail?theaterid=${list.id }"/>'>${list.name }</a></h2>	
	</c:forEach>
</div>
<h3><a href='<c:url value="/theater/register" />'>영화관 등록</a></h2>
<h3><a href='<c:url value="/theater/my" />'>나의 영화관 조회 (지점 입장)</a></h2>