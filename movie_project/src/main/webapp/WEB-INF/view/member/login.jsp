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


</head>
<body>

<div align="center">
	<br><br><br><br><br>
	<h1>Sign in</h1><br>
	<form class="form-inline" action="login" method="post">
  
  	<div class="form-group">
    	
    	<label class="sr-only" for="id">id</label>
    	<input type="text" class="form-control" name="id" placeholder="Enter Id" required>
    	
  	</div>
  
  	<br>
  
  	<div class="form-group">
    	<label class="sr-only" for="pw">pw</label>
    	<input type="password" class="form-control" name="pw" placeholder="Password" required>
  	</div>
 
  
  	<br><br>
  	<button type="submit" class="btn btn-default" style="width:15%; height:50px;">Sign in</button>
  	<br>
   <!--  <label>
      <input type="checkbox"> Remember me
    </label> -->
    <br>
	</form>
	
    <form action="register">
    <hr style="width: 30%">
    <button type="submit" class="btn btn-primary btn-lg" style="width:22%; height: 70px;">Sign up now!</button>
    </form>

</div>
</body>
</html>