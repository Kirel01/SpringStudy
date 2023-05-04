<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>메인화면</title>
<link rel="stylesheet" href="resources/css/main.css">
<style type="text/css">

.input-field {
	width: 300px;
	height: 40px;
	border-radius: 5px;
	padding: 0 10px;
	margin-bottom: 10px;
}


</style>
</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="top_gnb_area">
				<h1>네비게이션 바</h1>
			</div>
			<div class="top_area">
				<div class="logo_area">
					<img src="resources\img\denver.png" class="denverlogo"/>
				</div>

				<div class="search_area">
					<h1>검색창</h1>
						<input type="text" name="id" class="input-field"placeholder="검색어를 입력해주십시오." /> 
				</div>
				<div class="login_area">
					<div class="login_button"><a href="/login/loginpage">로그인</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="content_area">
				<h1>컨텐츠 영역</h1>
			</div>
		</div>
	</div>
</body>
</html>