<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <!--반드시 있어야 할 것(jsp페이지에 이것만 추가후 디자인 시작)-->
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<!--자바스크립트로 -->   
<head>
   <style>
  		<!-- 좌석 디자인 -->
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
	    
  		<!-- 기타 디자인 -->
	    .emptysmall{
            height: 10px;
        }
        .empty-row{
            height: 50px;
        }
        #mantotal{
            height:20px;
        }
    </style>

    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
            $("#man").on("click", function(){
                //인원수 계산
             	var adult = document.getElementById("adult").value;	//select에서 선택한 값 가져오기
                var child = document.getElementById("child").value;	//select에서 선택한 값 가져오기
                var senior = document.getElementById("senior").value;	//select에서 선택한 값 가져오기
                var total = Number(adult)+Number(child)+Number(senior);
              	alert(total);
                if(total>8){
                    alert("8명을 초과할 수 없습니다.");
                    $("#mantotal").html("");
                }else{
                    $("#mantotal").html("<input value="+total+">");
                }
                
            });	//button

            

            
            
        	
       });	//ready
	</script> 

</head>




<body>
	<h3>${seatlist}</h3>
    <div class="empty-row"></div>
    <div class="form-group">
        <form action ="<c:url value='/payment'/>" method="get">
          <fieldset>
            <div class="container">
              <h1 class="text-center">좌석 선택하기</h1>
              <!--인원선택-->    
              <div class="form-group">
                  <label class="col-form-label" for="adult">성인</label>
                  <input type="text" class="form-control" placeholder="인원수 입력 ex) 3" id="adult">
                  <label class="col-form-label" for="child">어린이</label>
                  <input type="text" class="form-control" placeholder="인원수 입력 ex) 3" id="child">
                  <label class="col-form-label" for="senior">어르신</label>
                  <input type="text" class="form-control" placeholder="인원수 입력 ex) 3" id="senior">
                  <div id="mantotal"></div>
                </div>
              <button type="button" class="btn btn-info" id="man">인원 선택 완료</button>
                <input type = "hidden" name="theaterid" value="${theaterid}"><br>
                <input type = "hidden" name="movieid" value="${movieid}" ><br>
                <input type = "hidden" name="scheduleid" value="${scheduleid}" ><br>
              <br>
                
               <!-- 좌석 뿌려주기 -->
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
				   

              
              
              
              
               <button type="submit" class="btn btn-info">다음 단계로 </button>
            </div>
            
            
          </fieldset>
        </form>
    </div>
</body>

</html>





