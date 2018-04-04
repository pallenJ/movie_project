<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.min.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/_variables.scss">
<link rel="stylesheet"
	href="https://bootswatch.com/4/lumen/_bootswatch.scss">

 

<style>
li {
	width: 200px;
}
</style>
<br>
<div align="right">
<h1>${sessionScope.loginId}</h1>
	<c:choose>

		<c:when
			test="${sessionScope.loginId eq null||sessionScope.loginId eq ''}">
			<a href="<c:url value='/login'/>">로그인</a>/
	 		<a href="<c:url value='/register'/>">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value='/logout'/>">로그아웃</a>/
		<a href="<c:url value='/myinfo'/>">내정보</a>
		</c:otherwise>
	</c:choose>



</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">MOVIE IS LOVE</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation" style="">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" align="center">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/'/>">홈으로</a></li>
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">예매</a>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
					<a class="dropdown-item" href="<c:url value='/ticket'/>">예매</a>
				</div></li>
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">영화</a>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
					<a class="dropdown-item" href="<c:url value='/movie'/>">영화정보</a>
				</div></li>
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">영화관</a>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
					<a class="dropdown-item" href="<c:url value='/schedule'/>">상영시간표</a>
					<a class="dropdown-item" href="<c:url value='/theater'/>">영화관
						페이지</a> <a class="dropdown-item" href="<c:url value='/screen'/>">상영관
						페이지</a> <a class="dropdown-item" href="<c:url value='/seat'/>">좌석</a>
				</div></li>
				
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">게시판</a>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
					 <a class="dropdown-item" href="<c:url value='/notice'/>">notice</a>
					 <a class="dropdown-item" href="<c:url value='/qna'/>">QnA</a>
				</div></li>
				
				
			<c:if test="${sessionScope.loginGrade eq '관리자' or sessionScope.loginGrade eq 'admin'}">
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">관리자 페이지</a>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
					<a class="dropdown-item" href="<c:url value='/admin'/>">회원관리</a> 
				</div></li>
				
			</c:if>
		

		</ul>
		<script src="https://bootswatch.com/_vendor/jquery/dist/jquery.min.js"></script>
		<script
			src="https://bootswatch.com/_vendor/popper.js/dist/umd/popper.min.js"></script>
		<script
			src="https://bootswatch.com/_vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	</div>
</nav>