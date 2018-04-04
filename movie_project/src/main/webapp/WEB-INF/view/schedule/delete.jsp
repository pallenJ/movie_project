<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//버튼 클릭시 상영시간표 삭제
            $("button").on("click", function(){
        			$.ajax({
        				url:'${pageContext.request.contextPath}'+"/schedule/delete",
        				type:"post",
        				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
        				data:{
        						scheduleid:$('#scheduleid').val(),
        						password:$('#password').val(),
        				},
        				dataType:"text",
        				success:function(count){
        					alert("삭제성공");
        					location.href = '${pageContext.request.contextPath}'+'/schedule';	//자바스크립트 페이지 강제이동	
        				},
       		        	error : function(xhr, status, error) {
     		                alert("비밀번호가 맞지 않습니다.");
       		       	    }
        			});
            });
        });
    </script>
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<style>

</style>
</head>
<body>
<div class="box">
		<br>
		<h1>계정확인</h1>
		<label><strong>비밀번호 입력</strong></label>  
		<input id="scheduleid" type="hidden" value="${param.scheduleid}">
		<input id="password" type="password">
		<button class="btn btn-info">삭제</button>
</div>
</body>