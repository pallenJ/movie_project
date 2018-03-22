<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<h1>상영시간표 등록 화면</h1>
<div>
	<form action="register" method="post">
		<input type="text" name="moive" value="v0000000001" placeholder="영화id"><br>
		<input type="text" name="theater" value="t0000000001" placeholder="영화관id"><br>
		<input type="text" name="screen" value="c0000000001" placeholder="상영관id"><br>
		<input type="date" name="day" value="2018-03-30" placeholder="상영날짜"><br>
		<input type="text" name="starttime" value="15:30" placeholder="상영시작시간"><br>
		<input type="text" name="endtime" value="17:50" placeholder="상영종료시간"><br>
		<input type="text" name="uploader" value="m0000000001" placeholder="올린사람"><br>
		<input type="text" name="morning" value=200 placeholder="조조할인 할인가격"><br>
		<input type="text" name="night" value=200 placeholder="야간할인 할인가격"><br>
		<input type="submit" value="등록">
	</form>
</div>
