<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
	<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
	<title>글수정</title>
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


</head>
<body>
	<form action="<c:url value='/noticeEdit'></c:url>" method="post">
	<table class="table table-bordered  table-hover" align="center"  style="position: relative; width: 80%; top:30px">

		<thead>
			<tr>
				<th colspan="100%"><h1 align="center"> 글수정 </h1></th>
			</tr>
			<tr>
				<th><h3> 글머리 </h3></th>
					<td>

						<div class="dropdown">
							<select class="form-control" name="head">
								<option>공지사항</option>
								<option>이벤트</option>
								<option>기타</option>
							</select>
						</div>

					</td>
					<th colspan="30%"><h4>제목</h4></th>
					<td colspan="50%"><input type="text" style="width: 100%;" name="title" value="${before.title}" required/></td>
					<tr></tr>
					<tr></tr>
				</thead>
				<tbody>
					<tr>
						<th colspan="100%" style="height: 500px;">
							<textarea  style="width:100%; height: 100%" name="content" required/>
								${before.content}
							</textarea>
						</th>
					</tr>



				</tbody>
				<tfoot>
					<tr><td colspan="100%">
						<div class="bs-example" data-example-id="button-tag-button-group-justified">
							<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">

								<div class="btn-group" role="group">
									<input type="hidden" name="no" value="${before.no}">
									<button type="submit" class="btn btn-default">수정완료</button>
								</div>

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default" onclick="history.back();">취소</button>
								</div>

							</div>
						</div></td></tr>
					</tfoot>
				</table>
				</form>
				<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
				<!-- Include all compiled plugins (below), or include individual files as needed -->
				<script src="js/bootstrap.min.js"></script>

			</body>
			</html>