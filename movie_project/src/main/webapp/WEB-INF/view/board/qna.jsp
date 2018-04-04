<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>Qna게시판</title>

<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>

<br><br>
<div align="center">
	<h1>Q&A</h1>

</div>
<hr>
<br>

</head>
<body>
	<c:if test="${re_edit_qna}">
		<script type="text/javascript">
			alert('수정이 완료되었습니다.');
		</script>
	</c:if>
	
	<c:if test="${re_qna_none}">
		<script type="text/javascript">
			alert('없는 글입니다.');
		</script>
	</c:if>
	<c:if test="${re_qna_secret}">
		<script type="text/javascript">
			alert('비밀 글입니다.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${re_qna_dfail eq 0}">
		<script type="text/javascript">
			alert('관리자 혹은 본인만 삭제 가능합니다.');
		</script>
	</c:if>
	
	<c:if test="${re_qna_dfail eq 2}">
		<script type="text/javascript">
			alert('삭제를 실패했습니다.');
		</script>
	</c:if>
	
	<c:if test="${re_qna_delete eq 1}">
		<script type="text/javascript">
			alert('삭제가 완료 되었습니다.');
		</script>
	</c:if>

	<c:if test="${re_qna}">
		<script type="text/javascript">
			location.href = 'qna';
		</script>
	</c:if>


	<script type="text/javascript">
	  	$(document).ready(function() {
	  		$(".form").submit(function() {
	  			event.preventDefault();
	  			submitIgnoreGuard(this);
	  		})
	  	})u
	
	</script>



		<div align="center">
		
	<form action="<c:url value='/qnawrite'></c:url>" style="position: relative; left: 360px;">
			<button type="submit" class="btn btn-outline-secondary"
				>글쓰기</button>
	</form>
		</div>
	<!--전체를 감는 div-->

	<div align="center">

		<!-- ==================================================== -->
		<!--   게시판 글 목록-->
		<table class="table table-striped table-bordered table-hover"
			style="width: 800px">

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
						<td><c:if test="${qnaitem.gno>0}">
						&nbsp; └
						</c:if> <font color="gray" size="2">[${qnaitem.head}]</font> <a
							href="<c:url value='/qnaShow'></c:url>?no=${qnaitem.no}" onclick="moveIgnoreGuard($(location).attr('href'))">${qnaitem.title}</a>
							<c:if test="${qnaitem.secret == 's'}">
								<font color="red" size="2">[비밀글]</font>
							</c:if></td>
						<td>${qnaitem.writerId}</td>
						<td>${qnaitem.reg}</td>
						<td>${qnaitem.read}</td>
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
					<div class="input-group-btn">

						<div class="dropdown" style="width: 90px;">
							<select class="form-control" name="search">
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="head">말머리</option>
								<option value="writerId">작성자</option>
							</select>
						</div>

					</div>
					<!-- 검색할 단어 입력-->
					<input type="text" class="form-control" name="keyword"
						placeholder="Search for..."> <span class="input-group-btn">
						<!-- 검색버튼-->
						<button class="btn btn-info" type="submit">검색</button>
					</span>

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
				<ul class="pagination pagination-sm">
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
						
						
				</ul>
				
				
				
				
	
				
				
				
			</nav>
			
		</div>
	</div>
		<!-- ==================================================== -->


	<!--/bs-example -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

</body>
</html>