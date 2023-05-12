<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginout" value="${sessionScope.id == null ? 'Login' : 'Logout' }" />
<c:set var="loginoutlink" value="${sessionScope.id == null ? '/login/login' : 'login/logout' }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/style.css'/>">
    <title>main</title>
</head>
<body>

    <header>
        <nav class="navbar">

            <div class="navbar__logo">
                <a href="">with DANG</a>
            </div>

            <ul class="navbar__menu">
                <li><a href="<c:url value='/' />">댕댕여지도</a></li>
                <li><a href="<c:url value='/' />l">댕근마켓</a></li>
                <li><a href="<c:url value='/' />">댕댕케어</a></li>
                <li><a href="<c:url value='/' />">댕댕커뮤</a></li>
                <li><a href="<c:url value='/' />">댕사무소</a></li>
                <li><a href="<c:url value='${loginoutlink}' />">${loginout}</a></li>

            </ul>
        </nav>
    </header>
    
    <p>Main Page</p>
    
</body>
</html>