<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화관 등록</title>
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
            <div class="content">
                <form action="register" method="post">
                    <div style="text-align: center;">
                        <h2>영화관 등록</h2><br>
                    </div>
                    <div>
                        지점명 <input type="text" name="name" required><br><br>
                        지역 <input type="text" name="region" required><br><br>
                        주소 <input type="text" name="address" style="width: 80%;" required><br><br>
                        전화번호 <input type="text" name="tel" required><br><br>
                        <input type="hidden" name="manager" value="${sessionScope.id }" readonly="readonly">
                    </div>
                    <div class="empty-row"></div>
                    <div style="text-align: center;">
                        <input type="submit" value="등록" class="btn btn-info">            
                    </div>
                    <div class="empty-row"></div>
                </form>
            </div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>