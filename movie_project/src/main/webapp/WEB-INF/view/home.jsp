<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>환영합니다</h1>
	<div align="right">
	 <a href="<c:url value='/login'/>">로그인</a>/
	 <a href="<c:url value='/register'/>">회원가입</a>/
	 <br>
	 <a href="<c:url value='/logout'/>">로그아웃</a>/
	 <a href="<c:url value='/myinfo'/>">내정보</a>/
	</div>
	
	<h1><a href="<c:url value='/ticket'/>">예매 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/movie'/>">영화 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/theater'/>">영화관 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/screen'/>">스크린 페이지로 이동</a></h1>
</body>
</html>