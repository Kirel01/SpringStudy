<%@page import="java.util.Set"%>
<%@page import="com.earth.pluto.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<%
		Map<String, Person> maps = (Map<String, Person>)application.getAttribute("maps");
		Set<String> keys = maps.keySet();
		for(String key : keys) {
			Person person = maps.get(key);
			out.print(String.format("이름 : %s, 나이: %d<br/>", person.getName(), person.getAge()));
		}
	%>    
</body>
</html>