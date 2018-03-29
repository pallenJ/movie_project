<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
    
        <!-- 자바스크립트 작성 공간 -->
    <style>
        div{
            border:1px solid black;
        }
    </style>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//버튼 클릭시 결제창 출력
            $("#schedulebutton").on("click", function(){
             	var adult = document.getElementById("adult");	//select에서 선택한 값 가져오기
              	alert(adult);
				
            });	//button
        	
       });	//ready
	</script> 

</head>
<body>
    <div>
    	
        <h1>좌석선택하기</h1>
            <h1>movie : ${movieid}</h1>
            <h1>theater : ${theaterid}</h1>
            <h1>schedule : ${scheduleid}</h1>

        <form id="target" action ="<c:url value='/payment'/>" method="get">
            <input type = "text" name = "adult" placeholder="성인 몇 분" value="1"><br>
            <input type = "text" name = "child" placeholder="어린이 몇 분" value="0"><br>
            <input type = "text" name = "senior" placeholder="어르신 몇 분 " value="0"><br>
            <input type = "hidden" name="theaterid" value="${theaterid}"><br>
            <input type = "hidden" name="movieid" value="${movieid}" ><br>
            <input type = "hidden" name="scheduleid" value="${scheduleid}" ><br>
            <input type = "submit" value="다음단계"><br><br>
        	<input type="checkbox" name="ck" value="s0000000001">a1
			<input type="checkbox" name="ck" value="s0000000002">a2
			<input type="checkbox" name="ck" value="s0000000003">a3
			<input type="checkbox" name="ck" value="s0000000004">a4
			<input type="checkbox" name="ck" value="s0000000001">a5
        </form>

    </div>
</body> 
</html>