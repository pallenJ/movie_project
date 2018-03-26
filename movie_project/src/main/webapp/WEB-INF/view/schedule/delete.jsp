<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//버튼 클릭시 상영시간표 삭제
            $("button").on("click", function(){
            		alert("버튼클릭");
        			$.ajax({
        				url:"http://localhost:8080/movie_project/schedule/delete",
        				type:"post",
        				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
        				data:{
        						scheduleid:$('#scheduleid').val(),
        						password:$('#password').val(),
        				},
        				dataType:"text",

        				success:function(count){
        					alert("삭제성공");
        					location.href = 'http://localhost:8080/movie_project/schedule/list';	//자바스크립트 페이지 강제이동	
        				},
       		        	error : function(xhr, status, error) {
     		                alert("비밀번호가 맞지 않습니다.");
       		       	    }
        			});
           
            });
        });
    </script>



<h1>계정확인</h1>
<div>
		비밀번호 입력
		<input id="scheduleid" type="text" value="${param.scheduleid}">
		<input id="password" type="password">
		<button>삭제</button>
</div>