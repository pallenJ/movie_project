<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
<head>
	<title></title>

<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">

</head>
<body>
<br>
<div class="jumbotron">  
    <h3 class="text-center">${loginId}님이 업로드한 상영시간표</h3>

    <div class="text-right">
        <a href="<c:url value='/schedule/register'/>"><button type="button" class="btn btn-primary text-right btn-sm">
            상영시간표 등록</button></a>
    </div>     
    <div>
        <table class="table table-hover">
      <thead>
        <tr>    <tr>
          <th scope="col">날짜</th>
          <th scope="col">영화이름</th>
          <th scope="col">상영관</th>
          <th scope="col">시작시간</th>
          <th scope="col">종료시간</th>
          <th scope="col">수정</th>
          <th scope="col">삭제</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="schedule" items="${schedulelist}">
        <tr class="table">
          <th scope="row">${fn:substring(schedule.day, 0, 10)}</th>
          <td>${schedule.movietitle}</td>    
          <td>${schedule.screenno}</td>
          <td>${schedule.starttime}</td>
          <td>${schedule.endtime}</td>
          <td><a href='<c:url value="/schedule/edit?scheduleid=${schedule.id }"/>'>수정</a></td>
          <td><a href='<c:url value="/schedule/delete?scheduleid=${schedule.id }"/>'>삭제</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>

</body>
</html>