<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#cart").click(function(){
			var cartQty = $("#cartQty").val();
			var prodNum = ${goodsReview.goods.prodNum};
			$.ajax({
				type: "post",	
				url: "<c:url value='/cart/cartAdd' />",
				dataType: "text",
				data: {"cartQty":cartQty,"prodNum":prodNum,
						"prodPrice":${goodsReview.goods.prodPrice} },
				// data : "cartQty="+cartQty +"&prodNum="+prodNum
				success: function(result){
					if(result.trim() == "1"){// 정상적으로 장바구니에 상품 등록
						if(confirm("계속쇼핑하시려면 '아니오'를 누르시오")){
							location.href="<c:url value='/cart/cartList'/>";
						}
					}else{
						alert("장바구니에 담기지 않았습니다.\n다시 시도 해주세요.");
					}
				}
		});
	});
		
		$("#wishBtn").click(function(){
			$.ajax({
				type: "POST",
				url: "../wish/goodsWishAdd",
				data: {"prodNum": "${goodsReviews.goods.prodNum}"},
				success:function(result){
					if(result.trim() == "1"){
						$("#wishBtn").attr("src","../images/돼지.jpg");
						alert("관심상품이 등록되었습니다.");
					}else{
						$("#wishBtn").attr("src","../images/도라에몽.jpeg");
						alert("관심상품이 해지되었습니다.");
					}
				},
				error: function() {
					alert('로그아웃 되었습니다 \n 다시 로그인해주세요')
					location.href= "../main";
					return
				}
			});
		});
});				
</script>
</head>
<body>
	<h1 style="text-align: center">제품</h1>
	<table border="1">
		<tr><td colspan="6">
			관심상품 
				<c:if test="${num == 0 }">
					<img alt="사진없지롱~" src="../images/도라에몽.jpeg" id="wishBtn">
				</c:if>
				<c:if test="${num == 1 }">
					<img alt="사진없지롱~" src="../images/돼지.jpg" id="wishBtn">
				</c:if>
			</td>
		</tr>
		<tr><td rowspan="5">
			<img src="../goods/upload/${goodsReview.goods.prodImage.split(',')[0]}"></td><td>${goodsReview.goods.prodName }</td>
		</tr>
		<tr>                               		 <td>${goodsReview.goods.prodName }</td></tr>
		<tr>                               		 <td>${goodsReview.goods.prodPrice }</td></tr>
		<tr>                                	<td>${goodsReview.goods.prodDelFee }</td></tr>
		<tr> <td>수량     
					<input type="number" min="1" step="1" value="1" name="cartQty" id="cartQty"></td></tr>
		<tr>                              				  
						<td><button id="cart" >장바구니</button> <button id="buy">바로구매</button> </td>
		</tr>
		<tr><td colspan="2"><br>상세보기 및 이미지 
		<p>
		<c:forTokens items="${goodsReview.goods.prodImage }" delims="," var="image">
			<img src="../goods/upload/${image }">
		</c:forTokens>
		</p>
		</td></tr>
	</table>
	<br><br>
	
	리뷰
	<hr />
	<c:forEach items="${goodsReview.review }" var="dto">
		<p>
			구매일자 : <fmt:formatDate value="${dto.reviewDate }" pattern="yyyy-MM-dd"/> <br />
			${fn:replace(dto.reviewContent, br , "<br />") }<br />
			<c:if test="${dto.reviewImg != null}">
				<img src="../goods/upload/${dto.reviewImg }" />
			</c:if>
		<p>
<c:if test="${dto.memId == null }">   등록된 리뷰가 없습니다</c:if>
	</c:forEach>
</body>
</html>