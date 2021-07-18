<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>


<script type="text/javascript">
	function fileDel(btn) {
		var delFile = $("#fileDel1").val()
		if($(btn).attr("value") == "삭제"){
			$(btn).attr("value","삭제취소");
			$("#fileDel1").val($(btn).parent().children("#fileName").text().trim() + "," + delFile)
		}else{
			$(btn).attr("value","삭제");
			fileName= $(btn).parent().children("#fileName").text().trim() + ",";
			$("#fileDel1").val(delFile.replace(fileName,""));
		}
	}
	
</script>
</head>
<body>
	<form:form action="goodsModifyAction" name="frm" method="post" modelAttribute="goodsCommand" enctype="multipart/form-data">
	<input type="hidden" name="prodNum" value="${goodsCommand.prodNum}">
	
	상품번호 :${goodsCommand.prodNum} <br>
	카테고리 :	<select name="ctgr">
					<option value="top" <c:if test="${goodsCommand.ctgr == 'top'}">selected</c:if>>상의</option>
					<option value="buttom"  <c:if test="${goodsCommand.ctgr == 'buttom'}">selected</c:if>>하의</option>
					<option value="shoes"  <c:if test="${goodsCommand.ctgr == 'shoes'}">selected</c:if>>신발</option>
					<option value="etc"  <c:if test="${goodsCommand.ctgr == 'etc'}">selected</c:if>>기타</option>
			</select>  <br>
	상품명 : <input type="text" name="prodName" value="${goodsCommand.prodName }">
			<form:errors path="prodName"></form:errors><br>
	상품가격 : <input type="number" name="prodPrice" min="100" step="1000" value="${goodsCommand.prodPrice }">
			<form:errors path="prodPrice"></form:errors><br> 		
	수량 : <input type="number" name="prodCapacity" min="0" value="${goodsCommand.prodCapacity }"> 
		<form:errors path="prodCapacity"></form:errors><br>
	공급 업체 :<input type="text" name="prodSupplyer" value="${goodsCommand.prodSupplyer }"> 
		<form:errors path="prodSupplyer"></form:errors><br>
	배송비 :<input type="number" name="prodDelFee" min="0" step="100" value="${goodsCommand.prodDelFee}">
			<form:errors path="prodDelFee"></form:errors><br>
	추천여부 :
		<input type ="radio" name="recommand" value="Y" <c:if test="${goodsCommand.recommand == 'Y'}">checked</c:if>>추천		
		<input type ="radio" name="recommand" value="N" <c:if test="${goodsCommand.recommand == 'N'}">checked</c:if>>비추<br>
		
	상세정보 :<textarea rows="5" cols="50" name="prodDetail">${goodsCommand.prodDetail }</textarea> 
			<form:errors path="prodDetail"></form:errors><br>
			
			
	이미지 : 
		<c:forTokens items="${goodsCommand.prodImage }" delims="," var="prodImage">  
		<p>
			<span id="fileName">${prodImage }</span>
	 		<input type="button" id="btn" value="삭제" onclick = "fileDel(this)" ><br> 
		</p>
	 	</c:forTokens>
	 파일추가:
	 <input type="file" name="prodImage" multiple="multiple"><br>
	 <!-- 파일 임시삭제/취소 -->
	 <input type="hidden" name="fileDel1" id="fileDel1">	<!-- 디비에서 수정을 하고나서 삭제하기 위해서 히든으로 버튼만든다  -->
			
			
		<input type="submit" value="수정하기">
		<input type="button" value="삭제하기" onclick = "javascript:location.href='goodsDel?prodNum=${goodsCommand.prodNum}'">
	</form:form>
	<a href="goodsList">리스트</a>
	<a href="../main">홈으로 </a>
</body>
</html>