<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>Qna게시판</title>

    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <div align="center"><h1>게시판</h1></div><hr><br>
    
</head>
<body>
  <!--전체를 감는 div-->
  <div align="center">
    <!-- ==================================================== -->

    <!--   게시판 글 목록-->
    <table class="table table-striped table-bordered table-hover" style="width:800px" >

        <thead>

          <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="10%">작성자</th>
            <th width="20%">작성일</th>
            <th width="10%">조회</th>
        </tr>

    </thead>

    <!-- 샘플로 넣은 데이터-->    
	

		
    <tbody>
    	<c:forEach var="qnaitem" items="${qnalist}">
        	<tr>
            <td>${qnaitem.no}</td>    
            <td><font color="gray" size="2">${qnaitem.head}</font>
                <a href="#">${qnaitem.title}</a></td>    
            <td>${qnaitem.writerId}</td>    
            <td>${qnaitem.reg}</td>    
            <td>${qnaitem.read}</td>    
        </tr>
        </c:forEach>
    
    
    
    </tbody>


</table>

<!-- ==================================================== -->
<!-- 검색 기능 -->
<div class=".col-lg-6" align="center" style="width:500px">
 <div class="input-group">

    <!--       검색 옵션 선택(드롭다운)-->
        <div class="input-group-btn">
    
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"    aria-expanded="false">Action 
                <span class="caret"></span>
            </button>  
    
            <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
          
        </div>
  <!-- 검색할 단어 입력-->
        <input type="text" class="form-control" placeholder="Search for...">

        <span class="input-group-btn">
        <!-- 검색버튼-->
            <button class="btn btn-default" type="button">Go!</button>
        </span>

        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
<br>
<!-- ==================================================== -->      

<!-- 페이징 기능 (모양만 잡은것.) -->      
<div class="bs-example" data-example-id="simple-pagination">
    <nav>
      <ul class="pagination">
        <li>
        	<c:if test="${pagingNum>0}">        	
               <a href='<c:url value='/qna'></c:url>?pg=${pagingNum}' aria-label="Previous">
        	    <span aria-hidden="true">&laquo;</span>
		          </a>
        	</c:if>
                </li>

                <c:forEach begin="1" end="${pageLast}" varStatus="page">
                <c:set var="pageidx" value="${pagingNum+page.count}" />
               <c:choose>
               <c:when test="${pageidx == pg}">
               
                <li>
                <a style="background-color: #98DFFF;" 
                href='<c:url value='/qna'></c:url>?pg=${pageidx}'>${pageidx}</a>
                </li>
               </c:when>
               
   				<c:otherwise>
   					<li>
                <a
                href='<c:url value='/qna'></c:url>?pg=${pageidx}'>${pageidx}</a>
                </li>
   				</c:otherwise>
               
               </c:choose>
   				</c:forEach>

                <li>
                
          <c:if test="${lastPage-pagingNum>10}">
          <a href='<c:url value='/qna'></c:url>?pg=${pagingNum+11}' aria-label="Next">
            
            <span aria-hidden="true">&raquo;</span>
          </a>          
          </c:if>
          
        </li>
      </ul>
    </nav>
</div>
<!-- ==================================================== -->        
</div><!--/bs-example -->

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>