<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
<head>
<title>나의 영화관</title>
<style>
.empty-row {
	height: 50px;
}

.area {
	margin: auto;
	text-align: center;
	width: 80%;
}

.content {
	margin: auto;
	text-align: center;
	padding: 50px;
	width: 60%;
}
</style>
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.min.css">
</head>
<body>
	<div class="empty-row"></div>
	<div class="area">
		<div class="text-right" style="margin-right: 20px;">
			<a href='<c:url value="/theater/edit"/>'
				class="btn btn-outline-secondary">영화관 수정</a> <a
				href='<c:url value="/theater/delete"/>'
				class="btn btn-outline-primary">영화관 삭제</a>
		</div>
		<div class="content">
			<div class="card border-info mb-3"
				style="max-width: 20rem; margin: auto;">
				<div class="card-header">${theater.name }</div>
				<div class="card-body" style="text-align: left;">
					<h6 class="card-title">지역 :</h6>
					<h5 class="card-text">${theater.region}</h5>
					<h6 class="card-title">주소 :</h6>
					<h5 class="card-text">${theater.address }</h5>
					<h6 class="card-title">전화번호 :</h6>
					<h5 class="card-text">${theater.tel }</h5>
				</div>
			</div>
		</div>
	</div>
	<div class="empty-row"></div>
</body>
</html>