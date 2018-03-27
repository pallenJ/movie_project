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
        function createSeat(id, row, col, state){
            var c = $("<input/>").attr("type", "checkbox").attr("id", id).attr("value", id).css("display", "none");
            var l = $("<label/>").attr("for", id).css("width", row).css("height", col);
            var d = $("<div/>").addClass("block")
                                .css("margin-top", row * 20).css("margin-left", col * 20);
            d.text(col);
            
            $(".seats").append(c);
            $(".seats").append(l);
            l.append(d);
            
          	//등록된 좌석인지 아닌지
            if(state){
                c.attr("checked", "checked");
                d.css("background-color", "red").css("color", "white");
            } else {
                d.css("background-color", "white").css("color", "black");
            }
            
            d.on("click", function(){
                if(c.is(":checked")){
                    $(this).css("background-color", "white").css("color", "black");
                } else {
                    $(this).css("background-color", "red").css("color", "white");
                    
                }
            });
        }
        
        $(document).ready(function(){
        	var chk=0;
            for(var i="a".charCodeAt(0); i<="l".charCodeAt(0); i++){
                for(var j=1; j<=23; j++){
                    var id = String.fromCharCode(i)+j;
                    console.log("i :"+i);
                    console.log("j :"+j);
                    console.log(<%=request.getAttribute("seat.get().reallocation") %>);
                	console.log('${seat.get('+chk+').reallocation}');
                    if(id=='${seat.get(chk).reallocation}'){
                    	alert(id);
	                    createSeat(id, i - "a".charCodeAt(0), j, true);
	                    chk++;
	                    console.log("chk :"+chk);
	                	console.log("get(1) :"+'${seat.get(1).reallocation}');
	                	console.log("get(2) :"+'${seat.get(2).reallocation}');
                    } else {
                    	createSeat(id, i - "a".charCodeAt(0), j, false);
                    }
                    
                }
            }
            
        });
        
        function send(){
            $("input[type=checkbox]:checked").each(function (index) {
            	var i = $("<input/>").attr("type", "hidden").attr("name", "seat").attr("value", $(this).val());
            	$("#content").append(i);
            });  
        };
        
    </script>
     <div class="screen">screen</div>
     <div class="empty-row"></div>
     <div class="seats"></div>
   <!-- 
    <c:forEach var="seat" items="${seat }">
    	${seat.reallocation }
    </c:forEach>
 -->