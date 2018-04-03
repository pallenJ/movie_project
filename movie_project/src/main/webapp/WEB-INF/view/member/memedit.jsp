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
    
    
    <div align="center"> <h1> 회원정보수정</h1> </div><hr>
  </head>
  <body>
       
    <div align="center">
      <form action="memedit" method="post">
      <!-- Table -->
      <table class="table table-bordered" align="center"  style="position: relative; width: 400px; top:30px">
        
        <tbody>
         
          <tr>
            <th scope="row" colspan="40%">회원번호</th>
            <td>
            ${memInfo.no}
            <input type="hidden" id="no" name="no" value="${memInfo.no}">
            
            </td>
          </tr>
          
          <tr>
            <th scope="row" colspan="40%">아이디</th>
            <td>${memInfo.id}</td>
          </tr>
         
         <tr>
            <th scope="row" colspan="40%">생년월일</th>
            <td>
           ${memInfo.birth}
            </td>
         </tr>
         
        <tr>
            <th scope="row" colspan="40%">이메일</th>
            
            <td>
            <input type="email" class="form-control" id="email" name="email" 
            value="${memInfo.email}" required>
            </td>
          </tr>
          
         <tr>
            <th scope="row" colspan="40%">전화번호</th>
            <td>
            <input type="text" class="form-control" id="phone" name="phone" 
            value="${memInfo.phone}" required>
            </td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">회원등급</th>
            <td>
            <input type="text" class="form-control" id="grade" name="grade" 
            value="${memInfo.grade}" required>
            </td>
         </tr>
         
         <tr>
            <th scope="row" colspan="40%">포인트</th>
            <td>
            <input type="number" class="form-control" id="point" name="point" 
            value="${memInfo.point}" required>
            </td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">가입일</th>
            <td>${memInfo.reg}</td>
         </tr>
         
           
        </tbody>
        
      </table>
      <br><br>
   	<button type="submit" class="btn btn-primary" style="width: 100px">회원 수정</button>&nbsp;&nbsp;&nbsp;
   	<button type="button" onClick="history.back();" class="btn btn-warning"  style="width: 100px">취소</button>
      </form>	
      <br> <hr>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
  </body>
</html>
