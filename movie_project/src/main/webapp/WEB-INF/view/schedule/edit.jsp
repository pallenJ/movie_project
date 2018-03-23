<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>영화 수정 화면</h1>
<div>
	<form action="edit" method="post">
		<input type="hidden" name="id" value="${list.id }"><br>
		<input type="text" name="title" value="${list.title }" placeholder="영화제목"><br>
		<input type="date" name="open" value="${fn:substring(list.open, 0, 10) }" placeholder="개봉일"><br>
		<input type="date" name="close" value="${fn:substring(list.close, 0, 10) }" placeholder="상영일"><br>
		<input type="text" name="director" value="${list.director }" placeholder="감독"><br>
		<input type="text" name="actor" value="${list.actor }" placeholder="배우"><br>
		<input type="text" name="genre" value="${list.genre }" placeholder="장르"><br>
		<input type="text" name="rate" value="${list.rate }" placeholder="이용가"><br>
		<input type="text" name="time" value="${list.time }" placeholder="상영시간"><br>
		<input type="text" name="nation" value="${list.nation }" placeholder="국가"><br>
		<input type="text" name="distributor" value="${list.distributor }" placeholder="배급사"><br>
		<input type="text" name="productor" value="${list.productor }" placeholder="영화사"><br>
		<input type="text" name="story" value="${list.story }" placeholder="줄거리"><br>
		<input type="text" name="posterpath" value="${list.posterpath }" placeholder="포스터경로"><br>
		<input type="text" name="poster" value="${list.poster }" placeholder="포스터"><br>
		<input type="text" name="uploader" value="${list.uploader }" placeholder="올린사람"><br>
		<input type="text" name="price" value="${list.price }" placeholder="가격"><br>
		<input type="submit" value="수정">
	</form>
</div>