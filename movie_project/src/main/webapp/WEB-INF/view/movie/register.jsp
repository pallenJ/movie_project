<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>영화 등록 화면</h1>
<div>
	<form action="register" method="post">
		<input type="text" id="title" placeholder="영화제목"><br>
		<input type="date" id="open" placeholder="개봉일"><br>
		<input type="date" id="close" placeholder="상영일"><br>
		<input type="text" id="director" placeholder="감독"><br>
		<input type="text" id="genre" placeholder="장르"><br>
		<input type="text" id="nation" placeholder="국가"><br>
		<input type="text" id="distributor" placeholder="배급사"><br>
		<input type="text" id="productor" placeholder="영화사"><br>
		<input type="text" id="story" placeholder="줄거리"><br>
		<input type="text" id="posterpath" placeholder="포스터경로"><br>
		<input type="text" id="poster" placeholder="포스터"><br>
		<input type="text" id="uploader" placeholder="올린사람"><br>
		<input type="text" id="price" placeholder="가격"><br>
		<input type="submit" value="등록">
	</form>
</div>
