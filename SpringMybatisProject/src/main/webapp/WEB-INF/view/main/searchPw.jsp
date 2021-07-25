<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="searchPwAction" method="post" name="frm">
		아이디 : <input type="text" name="memId"><span>${errMemId }</span><br>
		이메일 : <input type="text" name="memEmail"><span>${errEmail }</span>
		 <input type="submit" value="전송">
	</form>
</body>
</html>