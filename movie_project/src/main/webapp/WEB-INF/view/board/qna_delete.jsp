<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>

<!-- font awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css" media="screen"
	title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="css/style.css" media="screen"
	title="no title" charset="utf-8">



</head>
<body>
<br><br><br>
<h3 align="center">본인 확인을 위해 한번더 비밀 번호를 입력해 주세요</h3>
<div align="center" class="col-lg-6"  style="float: none; margin: 0 auto; position: relative; top: 10%; left:15%">
	<form action="<c:url value='/qnadelete'></c:url>" method="post" class="form-inline form-group">
  	
      	<input type="hidden" id="no" name="no" value="${requestScope.no}">
        <span class="input-group-btn">
    	<label class="sr-only" for="pw">pw</label>
    	<input type="password" class="form-control" id="pw" name="pw" placeholder="Password" required>
        <button class="btn btn-success" type="submit">입력</button>
        </span>
 <%--        <br><br><br><br>
  		<h4><a href='<c:url value="/home"></c:url>'>홈으로</a>&nbsp;&nbsp;&nbsp;
  		<a href="javascript:history.back();">취소</a></h4> --%>
	</form>
	
    

</div>

<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>