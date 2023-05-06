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
    <title>게시판 리스트</title>
</head>
<body>
    <div id="menu">
    	<ul>
    		<li id="logo">earth</li>
    		<li><a href="<c:url value='/'/>">Home</a></li>		<%-- HomeController의 RequestMapping 값인 /와 연결 --%>
    		<li><a href="<c:url value='/board/list'/>">Board</a></li>
    		<li><a href="<c:url value='/${loginoutlink}'/>">${loginout}</a></li>
    		<li><a href="<c:url value='/register/add'/>">SignUp</a></li>
    		<li><a href=""><i class="fas fa-search small"></i></a></li>
    	</ul>
    </div>
    <div style="text-align: center;">
    	<h2>건강하게 앞서 나아가다.</h2>
    	<h2>아름다운 시간, 오래오래 간직하도록</h2>
    	<h2>더 건강한 당신을 위하여</h2>
    	<h2>건강 센서, 통찰 제공</h2>
    	<h2>손목 온도 변화, 혁신적 센서</h2>
    </div>
</body>
</html>