<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="goodsRegistAction" method="post" name="frm" enctype="multipart/form-data" modelAttribute="goodsCommand" > <!-- 기본설정 되있는데  multipart로 바꾸면 파일을 날릴수있다  -->
		<table border=1>
			<tr>
				<th>상품번호</th>
				<td>
				<select name="ctgr">
					<option value="top">상의</option>
					<option value="buttom">하의</option>
					<option value="shoes">신발</option>
					<option value="etc">기타</option>
				</select>
				<input type ="text" name="prodNum" value="${prodNum }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type ="text" name="prodName">
				<form:errors path="prodName"></form:errors> </td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type ="text" name="prodPrice" maxlength="9"></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type ="text" name="prodCapacity"></td>
			</tr>
			<tr>
				<th>공급처</th>
				<td><input type ="text" name="prodSupplyer"></td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><input type ="text" name="prodDelFee" ></td> <!-- 별뜨게 하기   -->
		       <!--	<td><input type ="number" name="prodDelFee" min="0" max="5" step="1"></td> 별뜨게 하기  -->	
		</tr>
			<tr>
				<th>추천여부</th>
				<td>
					<input type ="radio" name="recommand" value="Y" checked>추천
					<input type ="radio" name="recommand" value="N">비추
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="6" cols="50"  name="prodDetail" ></textarea></td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<input type="file" name="prodImage" multiple="multiple"> <br>
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="등록">
					<input type="reset" value="취소">
					<input type="button" value="홈으로" onclick="javascript:location.href='main.sm">
				</td>
			</tr>
		</table>	
	</form:form>
</body>
</html>