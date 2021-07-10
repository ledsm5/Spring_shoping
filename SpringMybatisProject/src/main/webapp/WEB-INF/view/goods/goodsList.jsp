<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품리스트 페이지 입니다.<br>
	<a href="goodsRegist">상품등록</a>
	<br>
	<form action="#">
	<table>
		<tr>
			<th>상품번호</th>
			<th>카테고리</th>
			<th>상품명</th>
			<th>가격</th>
			<th>배송비</th>
		</tr>
			<c:forEach items="${lists }" var="dto">
		<tr>
			<td><a href="prodDetail?${dto.goodsNum }">${dto.goodsNum }</a></td>       
			<td>${dto.ctgr }</td>
			<td>${dto.prodName }</td>
			<td>가격</td>		
			<td>${dto.prodDelFee }</td>
		</tr>
			</c:forEach>
		<tr><td><input type="button" value="홈으로" onclick="javascript:location.href='main.sm"></td></tr>
	</table>
	</form>
	
	
</body>
</html>