<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	비밀번호 확인 :
	<form action="pwChangeConfirm" name="frm" method="post" >
	
	<input type="text" name="empPw"><span>${pwFail1 }</span>
	<input type="submit" value="확인">
	
	</form>
	
</body>
</html>