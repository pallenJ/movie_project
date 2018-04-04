<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 글자 자르는 태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
	alert("수정 실패!");
	location.href = '${pageContext.request.contextPath}'+'/schedule/';	//자바스크립트 페이지 강제이동	
</script>
