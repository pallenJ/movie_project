<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화 수정</title>
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
            <h2>영화관 수정</h2>
            <form action="edit" method="post">
                <div class="content">
                    <div>
                        <input type="hidden" name="id" value="${theater.id}">
                        지점명 <input type="text" name="name" value="${theater.name }" required><br><br>
                        지역 <input type="text" name="region" value="${theater.region }" required><br><br>
                        주소 <input type="text" name="address" value="${theater.address }" style="width: 80%;" required><br><br>
                        전화번호 <input type="text" name="tel" value="${theater.tel }" required><br><br>
                        <input type="hidden" name="manager" value="${theater.manager}">
                    </div>
                    <div style="text-align: center;">
                        <input type="submit" value="수정" class="btn btn-info">
                    </div>
                </div>
            </form>
            <div class="empty-row"></div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>