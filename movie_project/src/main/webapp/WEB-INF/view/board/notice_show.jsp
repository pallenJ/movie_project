<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>글보기</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- font awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css" media="screen"
	title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="css/style.css" media="screen"
	title="no title" charset="utf-8">


</head>
<body>
	<table class="table table-bordered  table-hover" align="center"
		style="position: relative; width: 70%; top: 30px">

		<thead>
			<tr>
				<th colspan="100%"><h1 align="center">글보기</h1></th>
			</tr>
			<tr>
				<th><h4>
						<font color="gray">${contents.head}</font>
					</h4></th>

				<th colspan="30%"><h4>제목</h4></th>
				<td colspan="50%">${contents.title}</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="100%" style="height: 80%;">
					<div align="center">${contents.content}</div>
				</td>
			</tr>



		</tbody>
		<tfoot>
			<tr>
				<td colspan="100%">
					<div class="bs-example"
						data-example-id="button-tag-button-group-justified">
						<div class="btn-group btn-group-justified" role="group"
							aria-label="Justified button group">
							<c:if test="${sessionScope.loginGrade eq '관리자' or sessionScope.loginGrade eq 'admin'}">
								<form action="<c:url value='/noticeEdit'></c:url>" class="btn-group"
									role="group">
									<input type="hidden" name="no" value="${contents.no}">
									<button type="submit" class="btn btn-default">수정</button>
								</form>
								<form action="<c:url value='/noticeDelete'></c:url>" class="btn-group"
									role="group">
									<input type="hidden" name="no" value="${contents.no}">
									<button type="submit" class="btn btn-default">삭제</button>
								</form>
							</c:if>

							<form action="<c:url value='/notice'></c:url>" class="btn-group"
								role="group">
								<button type="submit" class="btn btn-default">글목록</button>
							</form>

						</div>
					</div>
				</td>
			</tr>
		</tfoot>
	</table>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>