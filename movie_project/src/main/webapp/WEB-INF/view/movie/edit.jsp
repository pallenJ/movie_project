<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h2 class="text-center">영화 수정</h2><br>
            <form action="edit" method="post" enctype="multipart/form-data">
                <div class="content">
                    <div class="empty-row"></div>
                    <div>
                        <input type="hidden" name="id" value="${list.id }"><br>
                    </div>
                    <div>
                        영화제목 <input type="text" name="title" style="width: 80%;" value="${list.title }"><br><br>
                    </div>
                    <div>
                        개봉일 <input type="date" name="open" value="${fn:substring(list.open, 0, 10) }">
                        상영마감일 <input type="date" name="close" value="${fn:substring(list.close, 0, 10) }"><br><br>
                    </div>
                    <div>
                        감독 <input type="text" name="director" value="${list.director }"><br><br>
                    </div>
                    <div>
                        출연배우 <input type="text" name="actor" style="width: 81%;" value="${list.actor }"><br><br>
                    </div>
                    <div>
                        장르 <input type="text" name="genre" style="width: 85%;" value="${list.genre }"><br><br>
                    </div>
                    <div>
                        등급 <select name="rate" value="${list.rate }">
                            <option value="전체관람가">전체관람가</option>
                            <option value="12세관람가">12세관람가</option>
                            <option value="15세관람가">15세관람가</option>
                            <option value="18세관람가">18세관람가</option>
                        </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        상영시간 <input type="text" name="time" value="${list.time }"><br><br>
                    </div>
                    <div>
                        국가 <input type="text" name="nation" style="width: 85%;" value="${list.nation }"><br><br>
                    </div>
                    <div>
                        배급사 <input type="text" name="distributor" style="width: 83%;" value="${list.distributor }"><br><br>
                    </div>
                    <div>
                        영화사 <input type="text" name="productor" style="width: 83%;" value="${list.productor }"><br><br>
                    </div>
                    <div>
                        줄거리<br>
                        <textarea cols="95" rows="5" maxlength="400" name="story">${list.story }</textarea><br><br>
                    </div>
                    <div>
                        <input type="hidden" name="posterpath" value="${list.posterpath }" placeholder="포스터경로"><br>
                    </div>
                    <div>
                        포스터 <input type="file" name="poster" value="${list.poster}">기존파일:${list.postername}<br><br>
                    </div>
                    <div>
                        티켓 기본가 <input type="text" name="price" placeholder="예) 10000" value="${list.price }"><br><br>
                    </div>
                    <div>
                        <input type="hidden" name="uploader" value="${list.uploader }" placeholder="올린사람"><br>
                    </div>
                    <div style="text-align: center;">
                        <input type="submit" value="수정" class="btn btn-secondary">
                    </div>
                    <div class="empty-row"></div>
                </div>
            </form>
            <div class="empty-row"></div>
        </div>
        <div class="empty-row"></div>
    </body>
</html>
