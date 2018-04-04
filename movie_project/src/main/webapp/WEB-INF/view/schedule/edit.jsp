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
    <h3 class="text-center">상영시간표 수정하기</h3>   
    <div class="jumbotron card" style="max-width: 50rem;">
    
    <form action='<c:url value="/schedule/edit"/>' method="post">
        
    <div class="form-group">
      <label for="movie"><strong>영화</strong></label>
      <select class="form-control" id="movie" name="movie">
        <c:forEach var="movie" items="${movielist}">      
            <c:choose> 
            <c:when test="${movie.id eq schedule.movie}"><option value="${movie.id}" selected>${movie.title}</option></c:when>
            <c:otherwise><option value="${movie.id}">${movie.title}</option></c:otherwise>
            </c:choose>  
        </c:forEach>      
      </select>
     </div> 
        
      <div class="form-group">
      <label for="theater"><strong>영화관</strong></label>
      <select class="form-control" id="theater" name="theater">
        <c:forEach var="theater" items="${theaterlist}"> 
        	 <!-- 목록에서 선택한 항목은 기본으로 선택된 상태-->     
            <c:choose>
            <c:when test="${theater.id eq schedule.theater}"><option value="${theater.id}" selected>${theater.name}</option></c:when>
            <c:otherwise><option value="${theater.id}">${theater.name}</option></c:otherwise>
            </c:choose>
        </c:forEach>    
      </select>
     </div>   
        
      <div class="form-group">
      <label for="screen"><strong>상영관</strong></label>
      <select class="form-control" id="screen" name="screen">
        <c:forEach var="screen" items="${screenlist}">
            <c:choose> 
            <c:when test="${screen.id eq schedule.screen}"><option value="${screen.id}" selected>${screen.no}</option></c:when>
            <c:otherwise><option value="${screen.id}" selected>${screen.no}</option></c:otherwise>
            </c:choose>
        </c:forEach>
      </select>
     </div>    
        
      <div class="form-group">  
      <label for="day"><strong>상영날짜</strong></label>
      <input type="date" id="day" name="day" value="${schedule.day}"><br>
       </div>  
    <!--
    날짜가 문제다
<script>
document.getElementById('now_date').valueAsDate = new Date();
</script>



    -->    
        
      <div class="form-group">
      <label for="starttime"><strong>상영시작시간</strong></label>
      <input type="text" value = "${schedule.starttime}" placeholder="ex)04:00" name="starttime" id="starttime"><br>
       </div>   
      <div class="form-group">
      <label for="endtime"><strong>상영종료시간</strong></label>
      <input type="text" value = "${schedule.endtime}"  placeholder="ex)06:30" name="endtime" id="endtime"><br>
        </div>   
      <div class="form-group">
      <label for="morning"><strong>조조할인가격</strong></label>
      <input type="text" value = "${schedule.morning}" name="morning" id="morning" placeholder="ex)3000"><br>     
      </div>   
      <div class="form-group">
      <label for="night"><strong>야간할인가격</strong></label>
        <input type="text" value = "${schedule.night}" name="night" id="night" placeholder="ex)3000"><br>
      <div class="text-center">      
       <br><button type="submit" class="btn btn-info">수정하기</button>
      </div>
      <input type="hidden" value="${schedule.uploader}" name="uploader"><br>
      <input type="hidden" value="${schedule.id}" name="id"><br>

    </div>	
        
	</form>    
        
        
        
        
        
    </div>


          
</body>
    
    	
