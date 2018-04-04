<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>

<html>
<head>
    <title></title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//영화관 select에 값이 들어가면 상영관 가져오기
            $('#theater').on("input", function(){
	        	//영화관 선택시 상영관 불러오는 ajax
    			$.ajax({
    				url:'${pageContext.request.contextPath}'+"/schedule/screenlist",
    				type:"post",
    				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
    				data:{
    						theaterid:$(this).val()
    				},
    				dataType:"JSON",

    				success:function(screenlist){
						$('#screen').empty();
						document.getElementById('screen').innerHTML = '';
						
						$.each(screenlist, function(index,screen){
							 var option = $("<option>"+screen.no+"</option>");
				                option = option.val(screen.id);
		            		$("#screen").append(option); 
						});    
    				}
    			});
	        	
            });
        	
        	
        	//버튼 클릭시 상영시간표 등록
            $("button").on("click", function(){
       	        //ajax이용하여 상영시간표 등록
        			$.ajax({
        				url:'${pageContext.request.contextPath}'+"/schedule/register",
        				type:"post",
        				//ajax 요청을 보내면서 결제내역 정보 데이터를 첨부
        				data:{
        						movie:$('#movie').val(),
        						theater:$('#theater').val(),
        						screen:$('#screen').val(),
        						day:$('#day').val(),
        						starttime:$('#starttime').val(),
        						endtime:$('#endtime').val(),
        						uploader:$('#uploader').val(),
        						morning:$('#morning').val(),
        						night:$('#night').val()
        				},
        				dataType:"text",

        				success:function(count){
        					alert("등록성공");
        					location.href = '${pageContext.request.contextPath}'+'/schedule';	//자바스크립트 페이지 강제이동	
        				},
       		        	error : function(xhr, status, error) {
     		                alert("등록 실패했습니다.(상영 시작시간이 종료시간보다 늦거나 상영시간이 중복됩니다.)");
       		       	    }
        			});
           
            });
        	
        	
        	
        });
    </script>
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<style>
    .jumbotron{
        margin: auto;
    }
    input{
        margin-left: 10px;
    }

</style>
</head>
<body>
    <br>
    <h3 class="text-center">상영시간표 등록하기</h3>   
    <div class="jumbotron card" style="max-width: 50rem;">
    <div class="form-group">
      <label for="movie"><strong>영화</strong></label>
      <select class="form-control" id="movie">
        <c:forEach var="movie" items="${movielist}">  
        <option value="${movie.id}">${movie.title} [${movie.director} 감독]</option>
        </c:forEach>      
      </select>
     </div> 
      <div class="form-group">
      <label for="theater"><strong>영화관</strong></label>
      <select class="form-control" id="theater">
        <c:forEach var="theater" items="${theaterlist}">      
        <option class="theaterselect" value="${theater.id}">${theater.name}</option>
        </c:forEach>    
      </select>
     </div>   
      <div class="form-group">
      <label for="screen"><strong>상영관</strong></label>
      <select class="form-control" id="screen">
<%--         <option value="${screen.id}">${screen.no}</option> --%>
      </select>
     </div>    
      <div class="form-group">  
      <label for="day"><strong>상영날짜</strong></label>
      <input type="date" id="day"><br>
       </div>   
      <div class="form-group">
      <label for="starttime"><strong>상영시작시간</strong></label>
      <input type="text" placeholder="ex)04:00" id="starttime"><br>
       </div>   
      <div class="form-group">
      <label for="endtime"><strong>상영종료시간</strong></label>
      <input type="text" placeholder="ex)06:30" id="endtime"><br>
        </div>   
      <div class="form-group">
      <label for="morning"><strong>조조할인가격</strong></label>
      <input type="text" id="morning" placeholder="ex)3000"><br>     
      </div>   
      <div class="form-group">
      <label for="night"><strong>야간할인가격</strong></label>
        <input type="text" id="night" placeholder="ex)3000"><br>
      <div class="text-center">      
       <br><button class="btn btn-info">등록하기</button>
      </div>
      <input type="hidden" value="${uploaderid}" id="uploader"><br>
    </div>	            

    </div>

          
</body>
    
    	    
    

<!-- <body> -->
<!-- 	<h1>상영시간표 등록 화면</h1> -->
<!-- 	<div> -->
<!-- 			<input type="text" id="movie" value="v0000000001" placeholder="영화id"><br> -->
<!-- 			<input type="text" id="theater" value="t0000000001" placeholder="영화관id"><br> -->
<!-- 			<input type="text" id="screen" value="c0000000001" placeholder="상영관id"><br> -->
<!-- 			<input type="date" id="day" value="2018-03-30" placeholder="상영날짜"><br> -->
<!-- 			<input type="text" id="starttime" value="" placeholder="상영시작시간  ex)13:30"><br> -->
<!-- 			<input type="text" id="endtime" value="" placeholder="상영종료시간  ex)15:30"><br> -->
<!-- 			<input type="text" id="uploader" value="m0000000001" placeholder="올린사람"><br> -->
<!-- 			<input type="text" id="morning" value=200 placeholder="조조할인 할인가격"><br> -->
<!-- 			<input type="text" id="night" value=200 placeholder="야간할인 할인가격"><br> -->
<!-- 			<button>등록</button> -->
<!-- 	</div> -->
<!-- </body>  -->
<!-- </html> -->



   
    
