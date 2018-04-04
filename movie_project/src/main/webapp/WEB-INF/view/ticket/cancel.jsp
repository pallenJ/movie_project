<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	alert("결제 취소");
	location.href = '${pageContext.request.contextPath}'+'/ticket';	//자바스크립트 페이지 강제이동
</script>

