<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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


<style>
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>
</head>
<body>
	<form action="<c:url value='/noticewrite'></c:url>" method="post">
		<table class="table table-bordered  table-hover" align="center"
			style="position: relative; width: 80%; top: 30px">

			<thead>
				<tr>
					<th colspan="100%"><h1 align="center">글쓰기</h1></th>
				</tr>
				<tr>
					<td colspan="20%">
						
						<div class="dropdown">
						<label>글머리</label>
							<select class="form-control" name="head">
								<option>공지</option>
								<option>이벤트</option>
								<option>기타</option>
							</select>
						</div>

					</td>
						
					<td  >
					<label>제목</label>
					<input type="text" style="width: 100%; top: 50%"
						name="title" required /></td>
					</tr>
				
			</thead>
			<tbody>
				<tr>
					<th colspan="100%" style="height: 500px;"><textarea
							style="width: 100%; height: 100%" name="content" required /></textarea></th>
				</tr>



			</tbody>
			<tfoot>
				<tr>
					<th colspan="100%">

						<div class="form-group">
							<label for="inputContent" class="col-sm-2 control-label">첨부파일</label>
							<div class="col-sm-10">
								<div class="input-group">
									<label class="input-group-btn"> <span
										class="btn btn-default btn-file"> Browse <input
											type="file" name="attach_file"
											data-display-target="attachFile">
									</span>
									</label> <input type="text" class="form-control" readonly=""
										id="attachFile"
										placeholder="지원되는 파일 양식: jpg, png, gif, pdf, doc, docx, xls, xlsx, ppt, pptx">
								</div>
							</div>
						</div>
					</th>
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
	</form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>