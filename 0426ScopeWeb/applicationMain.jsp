<%@page import="java.util.HashMap"%>
<%@page import="com.earth.pluto.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Person> maps = new HashMap<>();
	maps.put("actor", new Person("최민식", 40));
	maps.put("actor2", new Person("손석구", 35));
	application.setAttribute("maps", maps);
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>application 영역</title>
</head>
<body>
    <h2>application 영역의 공유</h2>
    application 영역에 속성이 저장되었습니다. 
</body>
</html>