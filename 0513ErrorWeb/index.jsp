<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout' }" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login/login' : '/login/logout' }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/menu.css' />" />
    <title>DenverNuggets_Homepage</title>
</head>
<body>
    <div id="menu">
    	<ul>
    		<li id="logo">
    			<img src="resources\img\denver.png" class="denverlogo"/>
			</li>
    		<li><a href="<c:url value='/'/>">Home</a></li>		<%-- HomeController의 RequestMapping 값인 /와 연결 --%>
    		<li><a href="<c:url value='/board/list'/>">Board</a></li>
    		<li><a href="<c:url value='/${loginoutlink}'/>">${loginout}</a></li>
    		<li><a href="<c:url value='/register/add'/>">SignUp</a></li>
    		<li><a href=""><i class="fas fa-search small"></i></a></li>
    	</ul>
    </div>
    <div style="text-align: center;">
    	<img src="resources\img\dvmain.png" class="dvmain"/>
    	<h1>THREE THINGS TO WATCH FOR IN</h1>
    	<h1>GAME 2 OF NUGGETS-TIMBERWOLVES</h1>
    	<h1></h1>
    	<h2>INJURY REPORT</h2>
    	<h2>Aaron Gordon, a viable small-ball five? </h2>
    	<h2>Will Timberwolves switch up its defensive assignments? </h2>
    </div>
</body>
</html>