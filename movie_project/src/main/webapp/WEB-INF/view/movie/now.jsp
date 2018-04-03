<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title></title>
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
                width: 100%; height: 100%;
                text-align: center;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
    	<div class="empty-row"></div>
        <div class="text-right" style="margin-right: 20px;">
            <a class="btn btn-outline-primary" href='<c:url value="/movie/register"/>'>영화 등록</a>
            <a class="btn btn-outline-secondary" href='<c:url value="/movie/mylist"/>'>나의 영화 리스트</a>
            <a class="btn btn-outline-info" href='<c:url value="/movie/list"/>'>영화사별 검색(관리자용)</a>
        </div>
        <div class="empty-row"></div>
        <div class="area">
            <a class="btn btn-secondary btn-lg" href='<c:url value="/movie/now"/>'>현재 상영작</a>
            <a class="btn btn-primary btn-lg" href='<c:url value="/movie/soon"/>'>상영 예정작</a>
            <div class="empty-row"></div>
            <div class="card border-secondary mb-3" style="width: 100%; display:inline-block;">
                <c:forEach var="list" items="${list }">
                    <div style="width: 30%; overflow: hidden; display: inline-block; margin: auto;">
                        <img src="${pageContext.request.contextPath}/image/${list.poster}" style="margin: 20px; width: 200px; height:280px;"><br>
                        <a class="btn btn-secondary" href='<c:url value="/movie/info?movieid=${list.id }"/>' style="margin: 20px;">${list.title }</a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>