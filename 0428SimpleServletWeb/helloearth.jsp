<%@page import="com.earth.jaehyunki.SuperSimpleServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setAttribute("requestString", "request 영역의 문자열");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<h2>${name}님 안녕하세요. 
	<br> 
	<br> 
		저는 ${servname}입니다.
	</h2>
</body>
</html>