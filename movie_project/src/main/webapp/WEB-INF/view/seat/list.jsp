<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
<head>
    <title>좌석 목록</title>
    <style>
        .empty-row{
            height: 50px;
        }
        .area{
            margin: auto;
            text-align: center;
            width: 80%;
        }
        .content{
            margin: auto;
            text-align: left;
            padding: 50px;
            width: 90%;
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
            font-size: 8pt;
        }
        .seat-wrap{
            width: 750px;
            height: 350px;
            margin: auto;
	    }
	    .seat{
	        border:1px solid black;
	        display:inline-block;
	        width:28px;
	        height:28px;
	    }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        function seatlist(screenid){
        	$.ajax({
        		type: 'POST',
	       		url: '${pageContext.request.contextPath}'+"/seat/list",
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
    <div class="empty-row"></div>
    <div class="area">
        <div class="text-right" style="margin-right: 20px;">
            <a href="<c:url value='/seat/register'/>" class="btn btn-outline-secondary">좌석 등록</a>
        </div>
        <div class="content">
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
            <div style="text-align: center;">
                상영관 
                <select id="screenselect" name="screen">
                    <c:forEach var="screen" items="${screen}">
                        <option value="${screen.id }">${screen.no }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
   <div class="empty-row"></div>
</body>
</html>

