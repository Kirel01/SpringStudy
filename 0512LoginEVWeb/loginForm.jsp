<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/style.css'/>">
    
    <title>로그인</title>
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


	<form action="<c:url value='/login/login'/>" method="post" onsubmit="return frmCheck(this)">
		<h3 id="title">Login</h3>
		<div id="msg">
			<c:if test="${ not empty param.msg }">
			<i class="fa fa-exclamation-circle">${URLDecoder.decode(param.msg)}</i>
			</c:if>
		
		</div>
		<input type="text" name="id" placeholder="이메일 입력" value="${cookie.id.value }" autofocus />
		<input type="password" name="pwd" placeholder="비밀번호" />
		<input type="hidden" name="toURL" value="${param.toURL }" />
		
		<button>로그인</button>
		
		<div id="checked">
			<label><input type="checkbox" checked="checked" name="rememberId" value="on" ${empty cookie.id.value ? "" : "checked"} />아이디 기억</label> |
			<a class="forget" href="">비밀번호 찾기</a> |
			<a class="register"href="">회원가입</a> 
		</div>
	</form>
	<script type="text/javascript">
		function frmCheck(frm) {
			let msg = ''
			
			if(frm.id.value.length == 0) {
				setMessage('ID를 입력하세요.', frm.id)
				return false;
			}
			if(frm.pwd.value.length == 0) {
				setMessage('비밀번호를 입력하세요.', frm.pwd)
				return false;
			}
			
			return true;
			
		}
	       function setMessage(msg, element){
	           document.getElementById("msg").innerHTML 
	           		= `<i class="fa fa-exclamation-circle">${'${msg}'}</i>`
	           if(element){
	              element.select()   //값을 잘못입력했는데 잘못 입력한 부분에서 다시 입력받게 해당된 element에 select를 해주자
	           }
	        }
	
	
	</script>
    
</body>
</html>