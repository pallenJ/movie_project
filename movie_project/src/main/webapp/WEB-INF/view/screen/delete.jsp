<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>상영관 삭제</title>
        <style>
            .empty-row{
                height: 50px;
            }
            .area{
                margin: auto;
                text-align: center;
                width: 80%;
                border: 1px dotted;
            }
            .content{
                margin: auto;
                text-align: center;
                padding: 50px;
                width: 60%;
                border: 1px dotted;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
        <div class="empty-row"></div>
        <div class="area">
            <form action="delete" method="post">
                <div class="content">
                    <input type="hidden" name="screenid" value="${screenid }">
                    <input type="password" name="managerpw" placeholder="비밀번호"><br><br>
                    <input type="submit" value="삭제" class="btn btn-secondary btn-sm">
                
                </div>
            </form>
        </div>
        <div class="empty-row"></div>
    </body>
</html>