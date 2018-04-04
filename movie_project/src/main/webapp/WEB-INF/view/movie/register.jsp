<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/design/nav.jsp"></jsp:include>
<html>
    <head>
        <title>영화 등록</title>
        <style>
            .empty-row{
                height: 50px;
            }
            .area{
                margin: auto;
                text-align: center;
                align-content: center;
            }
            .content{
                margin: auto;
                text-align: left;
            }
        </style>
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
    </head>
    <body>
        <div class="empty-row"></div>
        <div class="area">
            <h2 class="text-center">영화 등록</h2><br>
            <form action="register" method="post" enctype="multipart/form-data">
                <div class="card border-info mb-3" style="width: 80%; text-align: left; margin:auto;">
                    <div class="empty-row"></div>
                    <div class="card-body">
	                    <div>
	                        	영화제목 <input type="text" name="title" style="width: 80%;" required><br><br>
	                    </div>
	                    <div>
	                        	개봉일 <input type="date" name="open" required>
	                   		     상영마감일 <input type="date" name="close" required><br><br>
	                    </div>
	                    <div>
	                    	    감독 <input type="text" name="director" required><br><br>
	                    </div>
	                    <div>
	                    	    출연배우 <input type="text" name="actor" style="width: 81%;" required><br><br>
	                    </div>
	                    <div>
	                     	   장르 <input type="text" name="genre" style="width: 85%;" required><br><br>
	                    </div>
	                    <div>
	                      	  등급 <select name="rate" required>
	                            <option value="전체관람가">전체관람가</option>
	                            <option value="12세관람가">12세관람가</option>
	                            <option value="15세관람가">15세관람가</option>
	                            <option value="18세관람가">18세관람가</option>
	                        </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                  	      상영시간 <input type="text" name="time" required><br><br>
	                    </div>
	                    <div>
	             		           국가 <input type="text" name="nation" style="width: 85%;" required><br><br>
	                    </div>
	                    <div>
	               		         배급사 <input type="text" name="distributor" style="width: 83%;" required><br><br>
	                    </div>
	                    <div>
	                  		영화사 <input type="text" name="productor" style="width: 83%;" required><br><br>
	                    </div>
	                    <div>
	           			        줄거리<br>
	                        <textarea cols="95" rows="5" maxlength="400" name="story" required></textarea><br><br>
	                    </div>
	                    <div>
	                 	       포스터 <input type="file" name="poster"><br><br>
	                    </div>
	                    <div>
	                  	      티켓 기본가 <input type="text" name="price" placeholder="예) 10000" required><br><br>
	                    </div>
	                    <div style="text-align: center;">
	                        <input type="submit" value="등록" class="btn btn-primary">
	                    </div>
	                    <div class="empty-row"></div>
                    </div>
                </div>
            </form>
        </div>
        <div class="empty-row"></div>
    </body>
</html>
