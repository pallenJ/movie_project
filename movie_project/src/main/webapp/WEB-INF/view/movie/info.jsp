<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화 정보</title>
        <style>
            .empty-row{
                height: 50px;
            }
            .area{
                margin: auto;
                text-align: center;
                width: 80%;
            }
            .content{
                margin: auto;
                text-align: left;
                width: 80%;
            }
            #img{
                 width: 30%; 
                display: inline-block; 
                text-align: center; 
                overflow: hidden; 
                vertical-align: top;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
        <div class="empty-row"></div>
        <div class="area">
            <div class="empty-row"></div>
            <div style="text-align: right; margin-right: 20px;">
                <a class="btn btn-outline-primary btn-sm" href='<c:url value="/movie/edit?movieid=${movie.id }"/>'>수정</a>
                <a class="btn btn-outline-secondary btn-sm" href='<c:url value="/movie/delete?movieid=${movie.id }"/>'>삭제</a>
            </div>
            <h2>영화 정보</h2>
            <div class="empty-row"></div>
            <div class="content">
                <div id="img">
                    <img src="${pageContext.request.contextPath}/image/${movie.poster}" style="margin: 20px; width: 200px; height:280px; overflow: hidden; vertical-align: top;"><br>
                </div>
                <div style="width: 69%; display: inline-block;">
                    <div class="empty-row"></div>
                    <div>
                        <h3>${movie.title }</h3>
                    </div>
                    <div>
                        <h5>영화 개봉일 : ${fn:substring(movie.open, 0, 10) }</h5>
                        <h5>상영 마감일 : ${fn:substring(movie.close, 0, 10) }</h5>
                        <h5>감독 : ${movie.director} / 배우 : ${movie.actor}</h5>
                        <h5>장르 : ${movie.genre} / 등급 : ${movie.rate}</h5>
                        <h5>상영시간 : ${movie.time} / 국가 : ${movie.nation}</h5>
                        <h5>배급사 : ${movie.distributor} / 제작사 : ${movie.productor}</h5>
                    </div>
                </div>
                <div style="width: 90%; margin: auto;">
                    <h6>줄거리<br>${movie.story}</h6>
                </div>
                <div class="empty-row"></div>
                <div style="text-align: center;">
                    <a class="btn btn-primary" href='<c:url value="/movie"/>'>영화 페이지로</a>
                </div>
                <div class="empty-row"></div>
            </div>
            <div class="empty-row"></div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>

