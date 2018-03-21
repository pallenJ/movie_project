<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>상영관 목록 화면</h1>
<div>
	<c:forEach var="list" items="${list }">
		<h2><a href='<c:url value="/screen/detail?screenid=${list.id }"/>'>${list.no } 관<br></a></h2>
	</c:forEach>
</div>
<h3><a href='<c:url value="/screen/register"/>'>스크린 등록</a></h2>
