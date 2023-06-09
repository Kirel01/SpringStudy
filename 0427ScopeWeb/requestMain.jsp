<%@page import="com.earth.pluto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("requestString", "request 영역의 문자열");
	request.setAttribute("requestPerson", new Person("이도",33));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>request 영역</title>
</head>
<body>
    <h2>request 영역 속성 값 삭제하기 및 읽기</h2>
    <%
    	request.removeAttribute("requestString");
   		request.removeAttribute("requestInteger");
   		
   		Person rperson = (Person)(request.getAttribute("requestPerson"));
    %>
    
    <h2>request 영역 속성값 읽기</h2>
    <ul>
   		<li>String 객체 : <%= request.getAttribute("requestString") %></li> 	
   		<li>Person 객체 : <%= rperson.getName() %>, <%= rperson.getAge() %></li> 	
   </ul>
   
   <%
		request.getRequestDispatcher("requestForward.jsp?paramOne=지구&paramTwo=earth").forward(request, response);
   %>
</body>
</html>