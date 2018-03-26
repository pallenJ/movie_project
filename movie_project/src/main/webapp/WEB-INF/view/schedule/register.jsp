<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//버튼 클릭시 상영시간표 등록
            $("button").on("click", function(){
            		alert("버튼클릭");
       	        //ajax이용하여 상영시간표 등록
        			$.ajax({
        				url:"http://localhost:8080/movie_project/schedule/register",
        				type:"post",
        				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
        				data:{
        						movie:$('#movie').val(),
        						theater:$('#theater').val(),
        						screen:$('#screen').val(),
        						day:$('#day').val(),
        						starttime:$('#starttime').val(),
        						endtime:$('#endtime').val(),
        						uploader:$('#uploader').val(),
        						morning:$('#morning').val(),
        						night:$('#night').val()
        				},
        				dataType:"text",

        				success:function(count){
        					alert("등록성공");
        					location.href = 'http://localhost:8080/movie_project/schedule/list';	//자바스크립트 페이지 강제이동	
        				},
       		        	error : function(xhr, status, error) {
     		                alert("등록 실패했습니다.(상영 시작시간이 종료시간보다 늦거나 상영시간이 중복됩니다.)");
       		       	    }
        			});
           
            });
        });
    </script>

<body>
	<h1>상영시간표 등록 화면</h1>
	<div>
			<input type="text" id="movie" value="v0000000001" placeholder="영화id"><br>
			<input type="text" id="theater" value="t0000000001" placeholder="영화관id"><br>
			<input type="text" id="screen" value="c0000000001" placeholder="상영관id"><br>
			<input type="date" id="day" value="2018-03-30" placeholder="상영날짜"><br>
			<input type="text" id="starttime" value="" placeholder="상영시작시간  ex)13:30"><br>
			<input type="text" id="endtime" value="" placeholder="상영종료시간  ex)15:30"><br>
			<input type="text" id="uploader" value="m0000000001" placeholder="올린사람"><br>
			<input type="text" id="morning" value=200 placeholder="조조할인 할인가격"><br>
			<input type="text" id="night" value=200 placeholder="야간할인 할인가격"><br>
			<button>등록</button>
	</div>
</body> 
</html>



   
    
