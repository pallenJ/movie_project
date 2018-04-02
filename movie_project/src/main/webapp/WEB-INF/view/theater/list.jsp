<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화관</title>
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
        <div class="area">
            <div class="empty-row"></div>
            <div class="text-right" style="margin-right: 20px;">
                <a href='<c:url value="/theater/register" />' class="btn btn-outline-info">등록</a>
                <a href='<c:url value="/theater/my" />' class="btn btn-outline-primary">나의 영화관 조회</a>
            </div>
            <div>
                <h2>영화관</h2>
            </div>
            <div class="empty-row"></div>
            <div>
	            <c:forEach var="list" items="${list }">
	                <a href='<c:url value="/theater/detail?theaterid=${list.id }"/>' class="btn btn-info">${list.name }</a><br><br>	
	            </c:forEach>
            </div>
            <div class="empty-row"></div>
        </div>
        <div class="empty-row"></div>
        <div class="empty-row"></div>
    </body>
</html>