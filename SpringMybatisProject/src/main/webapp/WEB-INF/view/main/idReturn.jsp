<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <br>
	<c:if test="${memId == null }">
		입력정보를 확인해 주세요.
	</c:if>
	<c:if test="${memId != null }">
		당신의 아이디는 ${memId } 입니다.
	</c:if>
</body>
</html>