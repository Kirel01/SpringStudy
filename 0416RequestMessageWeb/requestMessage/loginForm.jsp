<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 창</title>
    <script type="text/javascript">
    	function fnValidate() {
			//alert("!!")
			let frmLogin = document.frmLogin
			let userID = frmLogin.userID.value
			let userNAME = frmLogin.userNAME
			
			if((userID.length == 0 || userID == "") || (userNAME.length == 0 || userNAME == "")){
				alert("아이디와 이름은 필수입니다.")
			}
			else{
				frmLogin.method = "post"
					frmLogin.action = "${contextPath}/req/login"
					frmLogin.submit()
			}
		}
    </script>
</head>
<body>
    <form action= "${contextPath}/req/login" method="post" name="frmLogin">
    <table width="400">
    	<tr>
    		<td>아이디<input type="text" size="10" name="userID" /></td> 
    		<td>이름<input type="text" size="10" name="userNAME" /></td>
    	</tr>
    	<tr>  
    		<td>
    			<input type="button" value="로그인" onclick="fnValidate()" />
    			<input type="reset" value="다시입력" />
    		</td>  		
    	</tr>
    </table>
    </form>
</body>
</html>