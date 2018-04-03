<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>좌석 등록</title>
    <style>
        .empty-row{
            height: 20px;
        }
        .area{
            width: 80%;
            margin: auto;
        }
        .seatarea{
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
        
        $(document).ready(function(){
            for(var i="a".charCodeAt(0); i<="l".charCodeAt(0); i++){
                for(var j=1; j<=23; j++){
                    var id = String.fromCharCode(i)+j;
                    createSeat(id, i - "a".charCodeAt(0), j, true);
                }
            }
             
        });
       	
        $("#list").submit(function(){
        	var str = "";  
            $("input[type=checkbox]:checked").each(function (index) {  
                str += $(this).val() + ",";  
            });  
            $(this).submit(str);
            console.log(str);
            return true;
        });
       	
        
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
    <div class="empty-row"></div>
    <div class="empty-row"></div>
    <div class="area">
        <div class="empty-row"></div>
        <form action="register" method="post" onsubmit="return send()">
            <div class="seatarea">
                <div class="screen">screen</div>
                <div class="empty-row"></div>
                <div class="seats"></div>
            </div>
            <div class="empty-row"></div>
            <div class="empty-row"></div>
           <div id="content" style="text-align: center">
                상영관 : 
                <select name="screen">
                    <c:forEach var="screen" items="${screen}">
                        <option value="${screen.id }">${screen.no }</option>
                    </c:forEach>
                </select>
                <br><br>
                <input type="submit" value="등록">
            </div>
        </form>
        <div class="empty-row"></div>
    </div>
</body>
</html>