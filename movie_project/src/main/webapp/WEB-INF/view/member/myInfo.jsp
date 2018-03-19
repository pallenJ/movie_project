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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
	<!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <!-- font awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="css/style.css" media="screen" title="no title" charset="utf-8">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <div align="center"> <h1> 내정보</h1> </div><hr>
  </head>
  <body>
   <form action="">
       
    <div align="center">
      <!-- Table -->
      <table class="table table-bordered" align="center"  style="position: relative; width: 400px; top:30px">
        
        <tbody>
         
          <tr>
            <th scope="row" colspan="40%">아이디</th>
            <td>(아이디)</td>
          </tr>
         
         <tr>
            <th scope="row" colspan="40%">비밀번호</th>
            <td>비밀**</td>
         </tr>
         
        <tr>
            <th scope="row" colspan="40%">이메일</th>
            <td>???@?????.???</td>
          </tr>
          
         <tr>
            <th scope="row" colspan="40%">전화번호</th>
            <td>010-????-????</td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">회원등급</th>
            <td>???</td>
         </tr>
         
         <tr>
            <th scope="row" colspan="40%">포인트</th>
            <td>0</td>
         </tr>
          
         <tr>
            <th scope="row" colspan="40%">가입일</th>
            <td>???</td>
         </tr>
         
           
        </tbody>
        
      </table>
      <br> <hr>
    
    <button type="submit" class="btn btn-primary" style="width: 100px">내정보 수정</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn btn-default" style="width: 100px">취소</button>
    
    
    
    </div>
   </form>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
  </body>
</html>
