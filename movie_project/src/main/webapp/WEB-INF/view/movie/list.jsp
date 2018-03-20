<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>영화 목록 화면 (영화사 입장)</h1>
<c:forEach var="list" items="${list }">
	<h2>${list.title }</h2>
</c:forEach>