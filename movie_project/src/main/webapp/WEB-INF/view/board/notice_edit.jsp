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

<script type="text/javascript">
	$(function() {
		$("#fileD").change(function() {
			var flag = $("#fileD").is(":checked");
			
			if(flag){
			$("#fileDelete").val(true);
			$("#editdiv").html("<input type='file' name='newfile' id='newfile'>");	
			}else{
			$("#fileDelete").val(false);
			$("#editdiv").html("현재파일 : ${before.upload}<a id='showimg' href='#'> 사진보기 </a><div id='imgshow'></div>");	
			}
			
		/* 	$("#showimg").click(function() {
				alert("click");
				if($("#imgshow").html()){
					$("#imgshow").html("");
					$(this).html("사진보기");
				}else{
					$("#imgshow").html("<img src='${pageContext.request.contextPath}/image/${before.upload}'style='max-height:100%; height:450px; width:auto;'>");
					$(this).html("사진접기");
				}
					
			}) */
		})
		
		
	});
</script>


</head>
<body>
	<form action="<c:url value='/noticeEdit'></c:url>" method="post" enctype="multipart/form-data">
		<table class="table table-bordered  table-hover table-primary"
			align="center" style="position: relative; width: 80%; top: 30px">

			<thead>
				<tr>
					<th colspan="100%"><h1 align="center">글수정</h1></th>
				</tr>
				<tr>
					<th><h3>글머리</h3></th>
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
					<td colspan="50%"><input type="text" style="width: 100%;"
						name="title" value="${before.title}" required /></td>
				<tr></tr>
				<tr></tr>
			</thead>
			<tbody>


				<tr>
					<th colspan="100%" style="height: 500px;">
						<c:choose>
							<c:when test="${before.upload ne null and before.upload ne ''}">
								
								<input type='checkbox' name='fileD' id='fileD'>파일삭제/수정<br>
							<div id="editdiv">
								현재파일 : ${before.upload}
								<a id='showimg' href='#'> 사진보기 </a>
								
								<div id='imgshow'></div>
							</div>
							
							<br>
							<input type='hidden' name='fileDelete' id='fileDelete'
									value='false'>
							</c:when>
							
							<c:otherwise>
							
								<input type='file' name='newfile' id='newfile'>
							
							</c:otherwise>
						</c:choose>
						 <textarea style="width: 100%; height: 500px" name="content"
							required>
								${before.content}
							</textarea>
					</th>
				</tr>



			</tbody>
			<tfoot>
				<tr>
					<td colspan="100%">
						<div class="bs-example"
							data-example-id="button-tag-button-group-justified">
							<div class="btn-group btn-group-justified" role="group"
								aria-label="Justified button group">

								<div class="btn-group" role="group">
									<input type="hidden" name="no" value="${before.no}">
									<button type="submit" class="btn btn-default">수정완료</button>
								</div>

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default"
										onclick="location.href='noticeShow?no=${before.no}'">취소</button>
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