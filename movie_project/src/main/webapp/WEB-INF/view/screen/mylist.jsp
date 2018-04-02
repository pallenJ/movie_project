<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>상영관 목록</title>
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
                text-align: center;
                padding: 50px;
                width: 60%;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
        <div class="empty-row"></div>
        <div class="area">
            <div class="text-right" style="margin-right: 20px;">
                <a href='<c:url value="/screen/register"/>' class="btn btn-outline-primary">상영관 등록</a>
            </div>
            <div class="content">
                <div>
                    <c:forEach var="list" items="${list }">
                        <a href='<c:url value="/screen/detail?screenid=${list.id }"/>' class="btn btn-secondary">${list.no } 관</a><br><br>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>

