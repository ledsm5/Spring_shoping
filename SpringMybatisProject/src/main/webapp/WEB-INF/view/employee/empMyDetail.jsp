<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사원번호 : ${employeeCommand.employeeId }<br />
	아이디: ${employeeCommand.empUserid }<br />
	이름 : ${employeeCommand.empName }<br />
	입사일: <fmt:formatDate value="${employeeCommand.hireDate }"/><br /> 
	직무 : ${employeeCommand.jobId }<br />
	연락처 : ${employeeCommand.phNumber }<br />
	사무실번호 :${employeeCommand.officeNumber }<br/>
	이메일: ${employeeCommand.email }<br />
	주소 : ${employeeCommand.empAddress }<br />
<a href="empMyModify?empId=${employeeCommand.employeeId }">수정</a> | 
<a href="empMyPage" >뒤로가기</a>  
</body>
</html>