<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		<input type="hidden" value="${dto.noticeNo }" name="noticeNo">
	<table border="1"> 
		<tr><td>번호</td><td>제목</td><td>등록일</td><td>조회수</td><td></td></tr>
		<c:forEach items="${list }" var="dto" varStatus="cnt"> <!-- 반복상태확인 -->
		<tr>
			<td> ${cnt.count }</td><td><a href="libraryDetail?noticeNo=${dto.noticeNo }">${dto.noticeSub }</a></td><td>${dto.noticeDate }</td><td>${dto.noticeCount }</td>
			<td><a href="libDelCon?noticeNo=${dto.noticeNo }">삭제하기</a></td>
		</tr>
		</c:forEach>
	</table>
	</form>
	
	
	<a href="libDelCon">삭제하기</a>
	
	<a href="libRegist">자료등록</a>
</body>
</html>