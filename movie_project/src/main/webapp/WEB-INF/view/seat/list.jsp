<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta content-type="text/html; charset=UTF-8">
    <title>jQuery 배우기</title>
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
        function createSeat(id, row, col, state){
            var c = $("<input/>").attr("type", "checkbox").attr("id", id).attr("value", id).css("display", "none");
            var l = $("<label/>").attr("for", id).css("width", row).css("height", col);
            var d = $("<div/>").addClass("block")
                                .css("margin-top", row * 20).css("margin-left", col * 20);
            d.text(col);
            
            $(".seats").append(c);
            $(".seats").append(l);
            l.append(d);
            
            d.on("click", function(){
                if(c.is(":checked")){
                    $(this).css("background-color", "white").css("color", "black");
                } else {
                    $(this).css("background-color", "red").css("color", "white");
                    
                }
            });
        }
        
        function selectScreen(){
            //셀렉트 옵션 가져오기
            var screenselect = document.getElementById("screenselect");
                $.ajax({
                    url: window.location.href,
                    success: function(){
                    	$("#screenno").text(screenselect.options[screenselect.selectedIndex].text + "관");
                    }, 
                    error: function(){
                    	alert("실패");
                    }
                });
        }
        
        $(document).ready(function(){
            for(var i="A".charCodeAt(0); i<="L".charCodeAt(0); i++){
                for(var j=1; j<=23; j++){
                    var id = String.fromCharCode(i)+j;
                    createSeat(id, i - "A".charCodeAt(0), j, true);
                }
            }
        });
       	/*
        $("#list").submit(function(){
        	var str = "sdf";  
            $("input[type=checkbox]:checked").each(function (index) {  
                str += $(this).val() + ",";  
            });  
            $(this).submit(str);
            console.log(str);
            return true;
        });
       	*/
        
        function send(){
       		//var str = "";  
            $("input[type=checkbox]:checked").each(function (index) {
            	var i = $("<input/>").attr("type", "hidden").attr("name", "seat").attr("value", $(this).val());
            	$("#content").append(i);
                //str += $(this).val() + ",";  
            });  
        	//$("#str").attr("value", str);
        };
        
    </script>
</head>
<body>
    <h1>좌석 목록 페이지</h1>
    <h2 id="screenno"></h2>
   <div class="area">
       <div class="screen">screen</div>
       <div class="empty-row"></div>
       <div class="seats"></div>
   </div>
   <div class="empty-row"></div>
   <div class="empty-row"></div>
  <div id="content" style="text-align: center">
   	상영관 : 
   	<select id="screenselect" name="screen" onchange="selectScreen()">
   		<c:forEach var="screen" items="${screen}">
    		<option value="${screen.id }">${screen.no }</option>
   		</c:forEach>
   	</select>
	<br>
	<!-- 
   	실제위치 : <input type="text" name="reallocation"/><br>
   	서비스위치 : <input type="text" name="servicelocation"/><br>
   	좌석할인 : <input type="text" name="seatdiscount"/><br>
   	 -->
  	</div>
</body>
</html>

<h2><a href="<c:url value='/seat/register'/>">좌석 등록</a></h2>
