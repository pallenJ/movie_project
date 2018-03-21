<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1>좌석선택하기</h1>
            <h1>movie : ${movieid}</h1>
            <h1>theater : ${theaterid}</h1>
            <h1>schedule : ${scheduleid}</h1>
                
        <form action ="<c:url value='/payment'/>" method="get">
            <input type = "hidden" name="theaterid" value="${theaterid}"><br>
            <input type = "hidden" name="movieid" value="${movieid}" ><br>
            <input type = "hidden" name="scheduleid" value="${scheduleid}" ><br>
            <input type = "text" name = "adult" placeholder="성인 몇 분" value="1"><br>
            <input type = "text" name = "child" placeholder="어린이 몇 분" value="0"><br>
            <input type = "text" name = "senior" placeholder="어르신 몇 분 " value="0"><br>
            <input type = "text" name= "seatid" placeholder="seatid" value="s0000000001"><br>
            <input type = "submit" value="다음단계">
        </form>
    </div>
</body> 
</html>