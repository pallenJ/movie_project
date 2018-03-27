<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
	<title>글쓰기</title>
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
	<table class="table table-bordered  table-hover" align="center"  style="position: relative; width: 80%; top:30px">

		<thead>
			<tr>
				<th colspan="100%"><h1 align="center"> 글쓰기 </h1></th>
			</tr>
			<tr>
				<th><h4> 글머리 </h3></th>
					<td>

						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
								Dropdown
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
							</ul>
						</div>

					</td>
					<th colspan="30%"><h4>제목</h4></th>
					<td colspan="50%"><input type="text" style="width: 100%;"></td>
					<tr></tr>
					<tr></tr>
				</thead>
				<tbody>
					<tr>
						<th colspan="100%" style="height: 500px;">
							<textarea style="width:100%; height: 100%"></textarea>
						</th>
					</tr>



				</tbody>
				<tfoot>
					<tr><td colspan="100%">
						<div class="bs-example" data-example-id="button-tag-button-group-justified">
							<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default">글쓰기</button>
								</div>

								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default">취소</button>
								</div>

							</div>
						</div></td></tr>
					</tfoot>
				</table>

				<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
				<!-- Include all compiled plugins (below), or include individual files as needed -->
				<script src="js/bootstrap.min.js"></script>

			</body>
			</html>