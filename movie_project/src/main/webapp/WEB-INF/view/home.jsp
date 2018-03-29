<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Insert title here</title>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
</head>
<body>
	<c:if test="${re_login_home}">
		<script type="text/javascript">
			alert('로그인 성공');
			location.href='home';
		</script>
	</c:if>
	<h1>환영합니다</h1> 
	<div align="right">
	
	
	 
	
	 
	</div>
	
	<h1><a href="<c:url value='/qna'/>">Q&A 게시판 이동</a></h1>
	<h1><a href="<c:url value='/notice'/>">Noitce 게시판 이동</a></h1><br><br>
	<h1><a href="<c:url value='/schedule'/>">상영시간표 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/ticket'/>">예매 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/movie'/>">영화 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/theater'/>">영화관 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/screen'/>">스크린 페이지로 이동</a></h1>
	<h1><a href="<c:url value='/seat'/>">좌석 페이지로 이동</a></h1>
</body>
</html>