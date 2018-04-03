<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화 목록</title>
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
                width: 60%;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
        <div class="empty-row"></div>
        <div class="area">
            <div class="empty-row"></div>
            <form action="list" method="post">
                <div>
                    <input type="text" name="uploaderid" placeholder="영화사 ID">
                    <input type="submit" value="검색" class="btn btn-primary btn-sm">
                </div>
            </form>
            <div class="empty-row"></div>
            <div>
                <c:forEach var="list" items="${list }">
                    <a href="info?movieid=${list.id }" class="btn btn-primary">${list.title }</a><br><br>
                </c:forEach>
            </div>
            <div class="empty-row"></div>
        </div>
    </body>
</html>
