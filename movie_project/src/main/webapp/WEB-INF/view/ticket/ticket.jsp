<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
  <!--반드시 있어야 할 것(jsp페이지에 이것만 추가후 디자인 시작)-->
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<!--자바스크립트로 -->   
<head>
    <style> 
        .emptysmall{
            height: 10px;
        }
        .empty-row{
            height: 50px;
        }
    </style>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function(){
        	//버튼 클릭시 결제창 출력
            $("#schedulebutton").on("click", function(){
             	var movieselect = document.getElementById("movieselect");	//select에서 선택한 값 가져오기
             	var movieselectvalue = movieselect.options[movieselect.selectedIndex].value;
//              	alert(movieselectvalue);
             	
             	var theaterselect = document.getElementById("theaterselect");	//select에서 선택한 값 가져오기
             	var theaterselectvalue = theaterselect.options[theaterselect.selectedIndex].value;
//              	alert(theaterselectvalue);

             	var dateselect = document.getElementById("dateselect");	//select에서 선택한 값 가져오기
             	var dateselectvalue = dateselect.options[dateselect.selectedIndex].value;
//              	alert(dateselectvalue);
             	
             	//상영시간표 불러오는 ajax
			    $.ajax({
					url:'${pageContext.request.contextPath}'+"/ticket/schedule",
					type:"get",
					data:{
							theaterid:theaterselectvalue,
							movieid:movieselectvalue,
							date:dateselectvalue
					},
					dataType:"json",
					success:function(schedulelist){
// 						alert(schedulelist);
						//이전 내용 삭제
						$('#scheduleselect').empty();
						document.getElementById('scheduleselect').innerHTML = '';
						
						$.each(schedulelist, function(index,schedule){
							 var option = $("<option>"+schedule.starttime+"</option>");
				                option = option.val(schedule.id);
		            		$("#scheduleselect").append(option); 
						});
					}
	            });	//ajax
				
           });	//button
        	
       });	//ready
	</script>
</head>
<body>
    <div class="empty-row"></div>
    <div class="container">
        <form action="<c:url value='/selectseat'/>" method="post">
          <fieldset>
            <div class="container">
              <h1 class="text-center">예매하기</h1>
              <!--영화선택-->    
              <label for="movieselect">영화 고르기</label> 
              <select multiple="" name="movieid" class="form-control" id="movieselect" required>
            	<c:forEach var="movie" items="${movielist}">
            		<option value="${movie.id}">${movie.title}</option>
            	</c:forEach>
              </select>

              <label for="theaterselect">영화관 고르기</label>        
              <select multiple="" name="theaterid" class="form-control" id="theaterselect" required>
            	<c:forEach var="theater" items="${theaterlist}">
            		<option value="${theater.id}">${theater.name}</option>
            	</c:forEach>
              </select>
              <label for="dateselect">관람 일자 선택하기</label>
              <select multiple="" name="date" class="form-control" id="dateselect" required>
            	<c:forEach var="date" items="${datelist}">
            		<option value="${fn:substring(date, 0, 10)}">${fn:substring(date, 0, 10)}</option>
            		
            	
            	</c:forEach>
              </select>
              <div class="emptysmall"></div>         
              <button id="schedulebutton" type="button" class="btn btn-secondary">상영시간표 조회</button>    

            <HR></HR>
                <br>
                
              <label for="scheduleselect">상영 시간 선택하기</label>        
              <select multiple="" name="scheduleid" class="form-control" id="scheduleselect" required>
              </select>

            <button type="submit" class="btn btn-secondary">자리 찜하기!</button>
            </div>
          </fieldset>
        </form>
    </div>
</body>