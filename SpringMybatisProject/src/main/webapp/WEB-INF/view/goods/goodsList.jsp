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
	상품리스트 페이지 입니다. 상품의갯수는 ${count  } 개 입니다<br>
	<a href="goodsRegist">상품등록</a>
	<br>

	<table>
		<tr>
			<th>상품번호</th>
			<th>카테고리</th>
			<th>상품명</th>
			<th>가격</th>
			<th>배송비</th>
		</tr>
			<c:forEach items="${lists33 }" var="dto">
		<tr>
			<td><a href="goodsDetail?prodNum=${dto.prodNum }">${dto.prodNum }</a></td>       
			<td>${dto.ctgr }</td>
			<td>${dto.prodName }</td>
			<td>가격</td>		
			<td>${dto.prodDelFee }</td>
		</tr>
			</c:forEach>
		
		<tr><td colspan="5">
				<%@ include file="../include/includePage.jsp" %>
			</td>
		</tr>
		
	</table>
</body>
</html>