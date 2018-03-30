<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>회원가입</title>

<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<!-- 합쳐지고 최소화된 최신 CSS -->

<!-- font awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css" media="screen"
	title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="css/style.css" media="screen"
	title="no title" charset="utf-8">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<c:choose>

		<c:when test="${re_reg_reg eq 'no'}">
			<script type="text/javascript">
				alert('회원가입에 실패했습니다');
			</script>
		</c:when>
		
		<c:when test="${re_idCheck eq '1'}">
			<script type="text/javascript">
				alert('사용할 수 없는 아이디 입니다');
				history.back();
			</script>
		</c:when>

		<c:when test="${re_idCheck eq '0'}">
			<script type="text/javascript">
				alert('사용가능한 아이디 입니다');
				history.back();
			</script>
		</c:when>

	</c:choose>
	<c:if test="${re_reg_reg eq 'no'}">
		<script>
			history.back();
		</script>
	</c:if>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#idCheck').click(function() {
				var inputed =$('#id').val();
				location.href = 'idCheck?id='+inputed;
				   /* $.ajax({
				        url:'idCheck',
				        data: {
			                id : inputed
			            },
						success: function (idCheck) {
						alert('');	
						}

				    }); */
				
			})
		});

		function checkPw() {

			var pw   = document.getElementById("pw").value;
			var pwck = document.getElementById("pwCheck").value;
			if (pw != pwck) {

				document.getElementById('pwsame').innerHTML = '비밀번호가 틀렸습니다. 다시 입력해 주세요';
				return false;
			}
		}
	</script>

	<article class="container">
		<br><br>
		<div class="page-header" align="center">
			<h1>회원가입</h1>
		</div>
		<br>
		<div class="col-md-6"  style="float: none; margin: 0 auto;">
			<form role="form" action='register' method="post"
				onsubmit="return checkPw()">
				<!-- 아이디 입력 및 중복확인 기능-->
				<div class="form-group">
					<label for="id">아이디</label>
					<div class="input-group">
						<input type="text" class="form-control" id="id" name="id"
							placeholder="아이디" required> <span class="input-group-btn">
							<button class="btn btn-success" id="idCheck" type="button"
								onclick="">
								중복 확인<i class="fa fa-mail-forward spaceLeft"></i>
							</button>
						</span>
						<p id="checkMsg"></p>
					</div>
				</div> 
				<!--비밀번호 입력-->
				<div class="form-group">
					<label for="pw">비밀번호</label> <input type="password"
						class="form-control" id="pw" name="pw" placeholder="비밀번호" required>
				</div>
				<!--비밀번호 확인-->
				<div class="form-group">
					<label for="pwcheck">비밀번호 확인</label> <input type="password"
						class="form-control" id="pwCheck" name="pwcheck"
						placeholder="비밀번호 확인">
					<p id="pwsame" style="color: red;"></p>
				</div>

				<div class="form-group">
					<label for="birth">생년월일</label> <input type="text"
						class="form-control" id="birth" name="birth"
						placeholder="주민번호 앞 6자리" required>
				</div>

				<!--핸드폰   입력-->
				<div class="form-group">
					<label for="tel">핸드폰 번호</label> <input type="tel"
						class="form-control" id="phone" name="phone"
						placeholder="-없이 입력해주세요" required>
				</div>

				<!--이메일 입력-->
				<div class="form-group">
					<label for="email">E-mail</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="이메일 주소"
						required>
				</div>





				<div class="form-group">
					<label>약관 동의</label>

					<div class="checkbox agreeBox" align="right">
						<span class="fa fa-check"></span> <input id="agree"
							type="checkbox" autocomplete="off" checked> <a href="#">이용약관</a>에
						동의합니다.
					</div>
				</div>

				<div class="form-group text-center">
					<button type="submit" class="btn btn-info">
						회원가입<i class="fa fa-check spaceLeft singnupBtn"></i>
					</button>
					<button type="button" onClick="history.back();"
						class="btn btn-warning">
						가입취소<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>

			</form>
		</div>


	</article>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<input type="checkbox">

</body>
</html>
