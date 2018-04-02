<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화관 삭제</title>
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
            <div class="empty-row"></div>
            <form action="delete" method="post">
                <div class="content">
                    <input type="hidden" name="theaterid" value="${theater.id }">
                    <input type="password" name="managerpw" placeholder="비밀번호"><br><br>
                    <input type="submit" value="삭제" class="btn btn-primary btn-sm">
                </div>
            </form>
            <div class="empty-row"></div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>