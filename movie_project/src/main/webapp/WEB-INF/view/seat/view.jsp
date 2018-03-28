<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <style>
        .empty-row{
            height: 20px;
        }
        .area{
            border: 1px dotted black;
            width: 600px;
            height: 400px;
            margin: auto;
        }
        .screen{
            background-color: dimgray;
            border: 1px solid dimgray;
            color: white;
            text-align: center;
            font-size: 20px;
            width: 600px;
            height: 35px;
        }
        .seats{
            padding-top: 30px;
            border: 1px solid black;
            width: 500px;
            height: 280px;
            margin: auto;
        }
        .block{
            width:20px;
            height:20px;
            border:0.5px solid black;
            display: inline-block;
            position: absolute;
            overflow: hidden;
            text-align: center;
            font-size: 10pt;
        }
    </style>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        });
        
    </script>
    
     <div class="screen">screen</div>
     <div class="empty-row"></div>
     <div class="seats"></div>
   <!-- 
    <c:forEach var="seat" items="${seat }">
    	${seat.reallocation }
    </c:forEach>
 -->