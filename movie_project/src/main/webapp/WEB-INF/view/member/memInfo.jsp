<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
  <head> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>내정보</title>

    <!-- Bootstrap -->
    <jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <div align="center"> <h1> 회원정보</h1> </div><hr>
  </head>
  <body>
       
    <div align="center">
      	
      <!-- Table -->
      <table class="table table-bordered" align="center"  style="position: relative; width: 400px; top:30px">
        
        <tbody>
         
          <tr>
            <th scope="row" colspan="40%">아이디</th>
            <td>${memInfo.id}</td>
          </tr>
        
         
         <tr>
            <th scope="row" colspan="40%">생년월일</th>
            <td>${memInfo.birth}</td>
         </tr>
         
        <tr>
            <th scope="row" colspan="40%">이메일</th>
            <td>${memInfo.email}</td>
          </tr>
          
         <tr>
            <th scope="row" colspan="40%">전화번호</th>
            <td>${memInfo.phone}</td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">회원등급</th>
            <td>${memInfo.grade}</td>
         </tr>
         
         <tr>
            <th scope="row" colspan="40%">포인트</th>
            <td>${memInfo.point}</td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">가입일</th>
            <td>${memInfo.reg}</td>
         </tr>
         
           
        </tbody>
        
      </table>
      <br> <hr>
	<form action='memEdit'>
	<input type="hidden" name="no" value="${memInfo.no}">
   	<button type="submit" class="btn btn-primary" style="width: 100px">회원 수정</button>&nbsp;&nbsp;&nbsp;
   	<button type="button" onClick="history.back();" class="btn btn-warning"  style="width: 100px">취소</button>
	</form>    
    
    
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
  </body>
</html>
