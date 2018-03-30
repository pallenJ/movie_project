<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>영화 상세 조회 화면</h1>
<div>
	<h2>영화 아이디 : ${movie.id }</h2>
	<h2>영화 제목 : ${movie.title }</h2>
	<h2>영화 개봉일 : ${fn:substring(movie.open, 0, 10) }</h2>
	<h2>영화 줄거리 : ${movie.story }</h2>
	<div>
        <img src="${pageContext.request.contextPath}/image/${movie.poster}" style="margin: 20px; width: 200px; height:280px;"><br>
    </div>
</div>
<h3><a href='<c:url value="/movie/edit?movieid=${movie.id }"/>'>영화 수정</a></h3>
<h3><a href='<c:url value="/movie/delete?movieid=${movie.id }"/>'>영화 삭제</a></h3>
