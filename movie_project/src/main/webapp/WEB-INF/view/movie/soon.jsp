<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>개봉 예정 영화 화면</h1>
<h2><a href='<c:url value="/movie/now"/>'>현재 개봉 영화 화면</a> / <a href='<c:url value="/movie/soon"/>'>개봉 예정 영화 화면</a></h2>
<c:forEach var="list" items="${list }">
	<h3><a href='<c:url value="/movie/info?movieid=${list.id }"/>'>${list.title }</a></h3>
</c:forEach>

<h4><a href='<c:url value="/movie/register"/>'>영화 등록</a><br></h4>
<h4><a href='<c:url value="/movie/list"/>'>나의 영화 리스트 (영화사 입장)</a></h4>