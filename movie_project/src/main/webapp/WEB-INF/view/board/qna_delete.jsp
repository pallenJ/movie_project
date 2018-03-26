<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>로그인</title>

	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<div align="center" style="position: relative;top: 20%;">
<h1> 비밀번호 입력 </h1>
</div>

</head>
<body>
<div align="center" style="position: relative;top: 30%;">
	<form action="<c:url value='/qnadelete'></c:url>" method="post" class="form-inline form-group">
  
      	<input type="hidden" name="no" value="${requestScope.no}">
        <span class="input-group-btn">
    	<label class="sr-only" for="pw">pw</label>
    	<input type="password" class="form-control" id="pw" name="pw" placeholder="Password" required>
        <button class="btn btn-success">입력</button>
        </span>
  
	</form>
	
    

</div>
</body>
</html>