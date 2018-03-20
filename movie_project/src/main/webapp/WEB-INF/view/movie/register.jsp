<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화 등록 화면</h1>
<div>
	<form action="register" method="post">
		<input type="text" name="title" placeholder="영화제목"><br>
		<input type="date" name="open" placeholder="개봉일"><br>
		<input type="date" name="close" placeholder="상영일"><br>
		<input type="text" name="director" placeholder="감독"><br>
		<input type="text" name="actor" placeholder="배우"><br>
		<input type="text" name="genre" placeholder="장르"><br>
		<input type="text" name="rate" placeholder="이용가"><br>
		<input type="text" name="time" placeholder="상영시간"><br>
		<input type="text" name="nation" placeholder="국가"><br>
		<input type="text" name="distributor" placeholder="배급사"><br>
		<input type="text" name="productor" placeholder="영화사"><br>
		<input type="text" name="story" placeholder="줄거리"><br>
		<input type="text" name="posterpath" placeholder="포스터경로"><br>
		<input type="text" name="poster" placeholder="포스터"><br>
		<input type="text" name="uploader" placeholder="올린사람"><br>
		<input type="text" name="price" placeholder="가격"><br>
		<input type="submit" value="등록">
	</form>
</div>
