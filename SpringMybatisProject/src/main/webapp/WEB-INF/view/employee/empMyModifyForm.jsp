<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action ="empModifyAction" method ="post" name="frm" modelAttribute="employeeCommand">
	
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><form:input path="empUserid" value="${emp.empUserid }" readonly="true"></form:input></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><form:password path="empPw" ></form:password>
					<form:errors path="empPw"></form:errors>
				</td>
			</tr> 
			
			
			<tr>
				<td>직무 </td>
				<td><form:input path="jobId" value="${emp.jobId }"></form:input></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><form:input path="phNumber" value="${emp.phNumber }"></form:input></td>
			</tr>
			<tr>
				<td>사무실번호</td>
				<td><form:input path="officeNumber" value="${emp.officeNumber }"></form:input></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email" value="${emp.email }"></form:input></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><form:input path="empAddress" value="${emp.empAddress }"></form:input></td>
			</tr>			
			<tr>
				<td>
					<input type="submit" value ="수정">
					<input type="button" value ="이전" onclick="javascript:history.back();">
				</td>			
			</tr>
		</table>
	</form:form>
</body>
</html>