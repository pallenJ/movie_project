<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<title>글쓰기</title>
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

	<form action="<c:url value='/qnawrite'></c:url>" method='post'>
		<c:if test="${!empty requestScope.gno}">
			<input type="hidden" name="parent" value="${requestScope.parent}">
			<input type="hidden" name="gno" value="${requestScope.gno}">
		</c:if>
		<table class="table table-bordered  table-hover" align="center"
			style="position: relative; width: 80%; top: 30px">

			<thead>
				<tr>
					<th colspan="100%"><h1 align="center">글쓰기</h1></th>
				</tr>
				<tr>
					<th><h4>
							글머리
							</h4></th>
					<td>

						<div class="dropdown">
							<select class="form-control" name="head">
								<option>일반문의</option>
								<option>정보관련</option>
								<option>환불관련</option>
								<option>기타</option>
							</select>
						</div>


					</td>
					<th colspan="30%"><h4>제목</h4></th>
					<td colspan="50%"><input type="text" name="title" style="width: 100%;" required/></td>
				<tr></tr>
				<tr></tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="100%" style="height: 500px;">
					<textarea name="content" style="width: 100%; height: 100%"
					placeholder="내용을 입력해 주세요"></textarea></th>
				</tr>



			</tbody>
			<tfoot>
				<tr>
					<td colspan="100%">

						<div align="right">
							<input type='radio' name='secret' value='p' checked="checked"/>공개
							<input type='radio' name='secret' value='s' />비공개

						</div>

					</td>
				</tr>
				<tr>
					<td colspan="100%">
						<div class="bs-example"
							data-example-id="button-tag-button-group-justified">
							<div class="btn-group btn-group-justified" role="group"
								aria-label="Justified button group">

								<div class="btn-group" role="group">
									<button type="submit" class="btn btn-default">글쓰기</button>
								</div>

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default">취소</button>
								</div>

								
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
	</form>
</body>
</html>