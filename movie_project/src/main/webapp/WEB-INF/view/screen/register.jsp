<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>상영관 등록</title>
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
        	<div class="card border-info mb-3" style="max-width: 40rem; margin:auto;">
	            <div class="card-header">
	                <h2>상영관 등록</h2>
	            </div>
	            <div class="card-body">
		            <form action="register" method="post">
		                <div class="content">
		                    상영관 번호 <input type="text" name="no" placeholder="예) 1, 2, 3 ..." required><br><br>
		                    지점명 <input type="text" name="theater" value="${theater.name }" readonly="readonly"><br>
		                    <input type="submit" value="등록" class="btn btn-primary">
		                </div>
		            </form>
	            </div>
        	</div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>