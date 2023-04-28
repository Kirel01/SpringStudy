<%@page import="java.util.ArrayList"%>
<%@page import="com.earth.bycicle.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "이순신");
	request.setAttribute("list", new ArrayList());
	
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
	<%=person.getCar().getColor() %><br/>
	${person.getCar().getColor() }<br/>
	${person.car.color }<br/>
	${name }<br/>
	${requestScope.name }<br/><br/>
	
	<%=request.getParameter("name") %><br/>
	<%-- ${pageContext.request.getParameter("id") }<br/> --%>
	${param.id }<br/><br/>
	
	${"1" + 1 }<br/>
	${"1" += "1" }<br/>
	
	${"2" > 1 }<br/>
	
	${null }<br/>
	${null + 1 }<br/>
	${null + null }<br/>
	${"" + null }<br/>	
	${""-1 }<br/><br/>
	
	${empty null }<br/> 
	${empty list }<br/><br/>
	
	${null ==0 }<br/>
	${null eq 0 }<br/><br/> 
	
	${name == "이순신" }<br/>
	${name != "이순신" }<br/>
	
	${name eq "이순신" }<br/> 
	${name ne "이순신" }<br/>
	${name.equals("이순신") }  

</body>
</html>