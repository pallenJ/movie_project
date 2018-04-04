<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<c:if test="${re_admin}">
	
	<script type="text/javascript">
		location.href = 'admin';
	</script>

</c:if>

<title></title>

<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>


<div align="center">
	<h1>회원 관리</h1>

</div>
<hr>
<br>

</head>
<body>
	


	<!-- <script type="text/javascript">
	  	$(document).ready(function() {
	  		$(".form").submit(function() {
	  			event.preventDefault();
	  			submitIgnoreGuard(this);
	  		})
	  	})u
	
	</script> -->



	
	<!--전체를 감는 div-->

	<div align="center">

		<!-- ==================================================== -->
		<!--   게시판 글 목록-->
		<table class="table table-striped table-bordered table-hover"
			style="width: 800px">

			<thead>

				<tr>
					<th width="10%">번호</th>
					<th width="20%">아이디</th>
					<th width="10%">등급</th>
					<th width="20%">가입일</th>
					<th width="40%">수정/삭제</th>
				</tr>

			</thead>

			<!-- 샘플로 넣은 데이터-->


			<tbody>
				<c:forEach var="member" items="${list}">
					<tr>
						<%-- <c:if test="${sessionScope.loginGrade eq '관리자' and sessionScope.loginGrade eq 'admin'}"> --%>
						<td>${member.no}</td>
						<td> ${member.id}
						<td>${member.grade}</td>
						<td>${member.reg}</td>
						<td>
						<div align="center">
						<form action="<c:url value='/memInfo'></c:url>" style="display:inline;width: -10px">
							<input type="hidden" name="no" value="${member.no}">
							<button type="submit"> 회원정보 </button>
						</form>
						
						
						<form action="<c:url value='/memEdit'></c:url>" style="display:inline;width: -10px">
							<input type="hidden" name="no" value="${member.no}">
							<button type="submit"> 수정 </button>
						</form>
						
						
						<form action="<c:url value='/memDelete'></c:url>" style="display:inline;width: -10px;">
							<input type="hidden" name="no" value="${member.no}">
							<button type="submit"> 삭제 </button>
						</form>
						</div>
						</td>
						<%-- </c:if> --%>
					</tr>
				</c:forEach>

			</tbody>

		</table>

		<!-- ==================================================== -->
		<!-- 검색 기능 -->
		<div class=".col-lg-6" align="center" style="width: 500px">
		<form action="<c:url value='/qna'></c:url>" class="form-inline input-group" style="position: relative;">
			<div class=".col-lg-6" align="center" style="width: 500px">
				<div class="input-group">

					<!--       검색 옵션 선택(드롭다운)-->
					<!-- <div class="input-group-btn">

						<div class="dropdown" style="width: 90px;">
							<select class="form-control" name="search">
								<option value="title">번호</option>
								<option value="content">아이디</option>
								<option value="content">가입일</option>
							</select>
						</div>

					</div> -->
					<!-- 검색할 단어 입력-->
					<!-- <input type="text" class="form-control" name="keyword"
						placeholder="Search for..."> <span class="input-group-btn">
						검색버튼
						<button class="btn btn-info" type="submit">검색</button>
					</span> -->

				</div>
				<!-- /input-group -->
			</div>
			

		</form>
		<!-- /.col-lg-6 -->
		</div>
		<br>
		<!-- ==================================================== -->

		<!-- 페이징 기능 -->
		<div class="col-lg-6" data-example-id="simple-pagination">
			<nav>
				<%-- <ul class="pagination pagination-sm">
					<c:if test="${pagingNum>0}">
						<li class="page-item"><a href='<c:url value='/qna'></c:url>?pg=${pagingNum}'
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="1" end="${pageLast}" varStatus="page">
						<c:set var="pageidx" value="${pagingNum+page.count}" />
						<c:choose>
							<c:when test="${pageidx == param.pg}">

								<li class="page-item active"><a class="page-link"
									href='<c:url value='/qna'></c:url>?pg=${pageidx}'>${pageidx}</a>
								</li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link" href='<c:url value='/qna'></c:url>?pg=${pageidx}'>${pageidx}</a>
								</li>
							</c:otherwise>

						</c:choose>
					</c:forEach>

					<c:if test="${lastPage-pagingNum>10}">
							<li class="page-item"><a class="page-link" href='<c:url value='/qna'></c:url>?pg=${pagingNum+11}'
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
						
						
				</ul> --%>
				
				
				
				
	
				
				
				
			</nav>
			
		</div>
	</div>
		<!-- ==================================================== -->


	<!--/bs-example -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

</body>
</html>