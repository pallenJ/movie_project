<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	alert("중복된 예약이 있거나, 결제대기 중인 좌석이 포함되어 있습니다.");
	location.href = '${pageContext.request.contextPath}'+'/ticket';	//자바스크립트 페이지 강제이동	
</script>

