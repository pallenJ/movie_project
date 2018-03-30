<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<title>글쓰기</title>
<!-- Bootstrap -->


<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/_bootswatch.scss">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/_variables.scss">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.min.css">




</head>
<body>
	<form action="<c:url value='/noticewrite'></c:url>" method="post" enctype="multipart/form-data">

		<table class="table table-bordered  table-hover table-primary"
			align="center" style="position: relative; width: 80%; top: 30px">

			<thead>
				<tr>
					<th colspan="100%"><h1 align="center">글쓰기</h1></th>
				</tr>

				<tr>
					<td colspan="20%">

						<div class="dropdown">
							<label>글머리</label> <select class="form-control" name="head">
								<option>공지</option>
								<option>이벤트</option>
								<option>기타</option>
							</select>
						</div>

					</td>

					<td><label>제목</label> <input type="text"
						style="width: 100%; top: 50%" name="title" required /></td>
				</tr>
				<tr>
					<th colspan="100%">
						<div class="form-group">
							<label for="file" class="user-input area-30"></label>
							<input type="file" class="form-control-file "
								id="upload" name="upload" multiple="multiple">
						</div>

					</th>
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
					<th colspan="100%"></th>
				</tr>

				<tr>
					<td colspan="100%">
						<!-- <div class="bs-example"
							data-example-id="button-tag-button-group-justified">
							<div class="btn-group btn-group-justified" role="group"
								aria-label="Justified button group">
								
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-secondary" title="" 
									>Left</button>
								</div>

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-secondary" title="" 
									>Left</button>
								</div>

							</div>
						</div> -->


						<div class="bs-component" align="center">
							<button type="submit" class="btn btn-primary"
								data-toggle="tooltip" style="width: 25%">글쓰기</button>
							<label style="width: 25%"></label>
							<button type="button" class="btn btn-warning"
								onclick="history.back();" data-toggle="tooltip"
								style="width: 25%">취소</button>

						</div>
					</td>
				</tr>

			</tfoot>
		</table>
	</form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>
</html>