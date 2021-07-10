<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="pwChangeAction" name="frm" id="frm" method="post" modelAttribute="employeeCommand" >
		현재 비밀번호 :  <form:password path="oldPw"></form:password> 
					<form:errors path="oldPw"></form:errors><br>
		변경 비밀번호 :	<input type="password" name="empPw"> 
					<form:errors path="empPw" ></form:errors><br>
		변경 비밀번호 확인 : <input type="password" name="empPwCon"> 
					<form:errors path="empPwCon"></form:errors><br>
		<input type="submit" value="비밀번호 변경" id="btn">
	</form:form>
</body>
</html>