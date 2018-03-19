<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1>예매하기</h1>
        <form action ="<c:url value='/selectseat'/>" method="post">
            <input type = "text" name="date" placeholder="날짜 ex) 2018-03-03"><br>
            <input type = "text" name="theaterid" placeholder="영화관id"><br>
            <input type = "text" name="movieid" placeholder="영화id"><br>
            <input type = "text" name="scheduleid" placeholder="상영시간표id"><br>
            <input type = "submit" value="예매하기">
        </form>
    </div>
</body> 
</html>