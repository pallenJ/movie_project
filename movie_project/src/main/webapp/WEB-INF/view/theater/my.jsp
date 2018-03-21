<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>나의 영화관 화면 (지점입장)</h1>
<div>
	<h2>${theater.name }</h2>
	<input type="hidden" name="theaterid" value="${theater.id }">
	<input type="text" name="name" value="${theater.name }" readonly="readonly"><br>
	<input type="text" name="region" value="${theater.region }" readonly="readonly"><br>
	<input type="text" name="address" value="${theater.address }" readonly="readonly"><br>
	<input type="text" name="tel" value="${theater.tel }" readonly="readonly"><br>
</div>

<h3><a href='<c:url value="/theater/edit"/>'>영화관 수정</a></h3>
<h3><a href='<c:url value="/theater/delete"/>'>영화관 삭제</a></h3>