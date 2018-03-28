<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jQuery 배우기</title>
    <style>
        .empty-row{
            height: 20px;
        }
        .screen{
        	margin: auto;
            background-color: dimgray;
            border: 1px solid dimgray;
            color: white;
            text-align: center;
            font-size: 20px;
            width: 750px;
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
        .seat-wrap{
	        border: 1px dotted black;
            width: 750px;
            height: 350px;
            margin: auto;
	    }
	    .seat{
	        border:1px solid black;
	        display:inline-block;
	        width:25px;
	        height:25px;
	    }
    </style>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        function seatlist(screenid){
        	$.ajax({
        		type: 'POST',
	       		url: "http://localhost:8080/movie_project/seat/list",
        		data: {screenid:screenselect.options[screenselect.selectedIndex].value},
        		dataType: "json", 
        		success: function(data){
        			for(var r=0; r<=11; r++){
        				for(var c=1; c<=23; c++){
        					var id = "#" + String.fromCharCode(r+97) + c;
        					$(id).css("background-color", "white").css("color", "black");
      							
        				}
        			}
        			//data에 들어있는 정보를 검사하여
                    //해당하는 id를 가진 자리를 표시
                    $.each(data, function(i, d){
                        var id = "#" + d.reallocation;
                        $(id).css("background-color", "red").css("color", "white");
                    });
        		}
        	});
        }
        
        $(document).ready(function(){
        	seatlist(screenselect.options[screenselect.selectedIndex].value);
        	
        	$("#screenselect").on("input", function(event){
                seatlist($(this).val())
            });
        });
        
        
    </script>
</head>
<body>
    <h1>좌석 목록 페이지</h1>
    <h2 id="screenno"></h2>
    <div class="screen">screen</div>
    <div class="empty-row"></div>
	<div class="seat-wrap">
		<c:forEach var="r" begin="0" end="11">
		    <c:forEach var="c" begin="1" end="23">
		        <div class="seat" id="&#${r+97};${c}">
		            &#${r+97};${c}
		        </div>
		    </c:forEach>
		    <br>
		</c:forEach>
	</div>
   <div class="empty-row"></div>
   <div class="empty-row"></div>
  <div id="content" style="text-align: center">
   	상영관 : 
   	<select id="screenselect" name="screen">
   		<c:forEach var="screen" items="${screen}">
    		<option value="${screen.id }">${screen.no }</option>
   		</c:forEach>
   	</select>
	<br>
	<div id="content"></div>
	<!-- 
   	실제위치 : <input type="text" name="reallocation"/><br>
   	서비스위치 : <input type="text" name="servicelocation"/><br>
   	좌석할인 : <input type="text" name="seatdiscount"/><br>
   	 -->
  	</div>
<h2><a href="<c:url value='/seat/register'/>">좌석 등록</a></h2>
</body>
</html>

