<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<!-- 로그인이 안된경우  -->
<c:if test="${empty authInfo }">

	<form:form action="login" method="post" name="frm" modelAttribute="loginCommand">
		<table>
			<tr><td colspan="3">아이디저장 | 자동로그인</td></tr>
			<tr>
				<td>아이디</td>
				<td>
					<form:input path="userId" />
					<form:errors path="userId"  /> 
				</td>
				<td rowspan="2">
					<input type="image" src="images/img1.jpg" width="100" alt="login">
				</td>
			</tr>
			<tr><td>비밀번호</td>
				<td>
					<form:password path="userPw" />
					<form:errors path="userPw" />
				</td>
			</tr>
			<tr><td>아이디 | 비밀번호 찾기 </td><td><a href="register/agree">회원가입</a></td></tr>
		</table>
	</form:form>
</c:if>

<!-- 로그인 되엇을때 -->
<c:if test="${!empty authInfo }">
	<!-- 일반사용자 -->
	
		<a href ="my/myPage">마이페이지</a>

	<!-- 직원전용 -->
	
		<a href="emp/empList">직원 리스트</a>
		<a href="mem/memList">회원리스트</a>
	

		<a href="login/logout">로그아웃</a>
</c:if>

</body>
</html>