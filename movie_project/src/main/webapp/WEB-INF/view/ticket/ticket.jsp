<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script>
        $(document).ready(function(){
        	
        	//버튼 클릭시 결제창 출력
            $("button").on("click", function(){
            	    alert("버튼클릭");
                    var tag=$("<h3>append 태그</h3>");
                    $("#target").append(tag);   
            });
         });
    </script>

<body>
    <div>
        <h1>예매하기</h1>
        <form action ="<c:url value='/selectseat'/>" method="post">
            <input type = "text" name="date" placeholder="날짜 ex) 2018-03-03" value="2018-03-03"><br>
            <input type = "text" name="theaterid" placeholder="영화관id" value="t0000000001"><br>
            <input type = "text" name="movieid" placeholder="영화id" value="v0000000001"><br>
            <input type = "text" name="scheduleid" placeholder="상영시간표id" value="s0000000001"><br>
            <input type = "submit" value="예매하기">
        </form>
            <button>영화선택완료</button><br>
            <span id="target"></span>
    </div>
</body> 
</html>