<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Home</title>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="css/swiper.css">
<style>
	.empty-row{
         height: 50px;
     }
     .area{
         margin: auto;
         text-align: center;
         width: 80%;
     }
    /* swiper-container의 크기를 조절하여 위치 설정 */
    .swiper-container{
        width: 500px;
        height: 700px;
        margin: 20px auto;
    }
</style>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="js/swiper.js"></script>
<script>    
    $(document).ready(function(){
        //class="swiper-container"에 swiper 적용
        //var slider = new Swiper("선택자", {옵션});
        var slider = new Swiper(".swiper-container", {
            //적용시킬 옵션들 - API 문서에서 참조해야함
            nextButton:".swiper-button-next", //다음 버튼
            prevButton:".swiper-button-prev", //이전 버튼

            loop:true, //시작지점과 끝지점을 이어지도록 처리

            grabCursor: true, //손가락 모양의 커서로 변경

            pagination:".swiper-pagination", //페이지 위치 표시
            paginationClickable:true, //위치를 클릭으로 이동할 수 있도록 설정

            autoplay:2000, //자동재생(밀리초) 설정
        });

    });
</script>
</head>
<body>
	<!-- 포스터 이미지 -->
	<div class="area">
		<div class="empty-row"></div>
		<div class="swiper-container">
	            <!-- 이미지 영역 : wrapper -->
	            <div class="swiper-wrapper">
	                <!-- 1장의 이미지 영역 : slide -->
	                <c:forEach var="list" items="${list }">
	                    <div class="swiper-slide">
	                        <img src="${pageContext.request.contextPath}/image/${list.poster}" style="width: 100%; height: 100%;">
	                    </div>
	                </c:forEach>
	            </div>
	
	            <!-- 이전/다음 버튼 -->
	            <div class="swiper-button-next"></div>
	            <div class="swiper-button-prev"></div>
	
	            <!-- 네비게이터 버튼 -->
	            <div class="swiper-pagination"></div>
	       </div>
	       <div class="empty-row"></div>
	</div>
       
       
	<c:if test="${re_login_home}">
		<script type="text/javascript">
			alert('로그인 성공');
			location.href = 'home';
		</script>
	</c:if>
	<div align="right">

		<c:if test="${re_reg_reg eq 'ok'}">
			<script type="text/javascript">
				alert('회원가입에 성공했습니다');
				location.href = 'home';
			</script>
		</c:if>
	</div>
	
</body>
</html>