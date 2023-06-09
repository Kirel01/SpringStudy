<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	/* 날짜 표시 방식 */
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	/* 세션 생성(최초 요청) 시각 */
	long creationTime = session.getCreationTime();
	String creationTimeStr = dateFormat.format(new Date(creationTime));
	/* 마지막 요청 시각 */
	long lastTime = session.getLastAccessedTime();
	String lastTimeStr = dateFormat.format(new Date(lastTime));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>세션</title>
</head>
<body>
    <h2>Session 설정 확인</h2>
    <ul>
    	<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></li>
    	<li>세션 아이디 : <%= session.getId() %></li>
    	<li>최초 요청 시각 : <%= creationTimeStr %></li>
    	<li>마지막 요청 시각 : <%= lastTimeStr %></li>
    </ul>
</body>
</html>