<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%
	pageContext.setAttribute("cn","\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>
<a href="goodsModify?prodNum=${goodsCommand.prodNum }">수정</a> <br>
	상품번호 :${goodsCommand.prodNum} <br>
	카테고리 :${goodsCommand.ctgr}  <br>
	상품명 : ${goodsCommand.prodName }<br>
	상품가격 : <fmt:formatNumber value="${goodsCommand.prodPrice }"  type="currency" ></fmt:formatNumber> <br>
	수량 : ${goodsCommand.prodCapacity }<br>
	공급 업체 :${goodsCommand.prodSupplyer } <br>
	배송비 : ${goodsCommand.prodDelFee}<br>
	추천여부 :
	<c:if test="${goodsCommand.recommand=='Y' }">추천</c:if>
	<c:if test="${goodsCommand.recommand=='N' }">비추천</c:if>
	 <br>
	상세정보 :
	<p>
	${fn:replace(goodsCommand.prodDetail , cn , "<br/>") }
	</p>
	이미지 : <br>
	<c:forTokens items="${goodsCommand.prodImage }" delims="," var="prodImage">
		<img src="../goods/upload/${prodImage }"> <br>
	</c:forTokens><!--delims 구분   var : 받는값-->
	
</body>
</html>