<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function testDiv(num) {
		if(num==1){
			op1.style.display="";
			op2.style.display=none;
			op3.style.display=none;
		}else if(num==2) {
			op1.style.display=none;
			op2.style.display="";
			op3.style.display=none;
		}else if(num==3) {
			op1.style.display=none;
			op2.style.display=none;
			op3.style.display="";
		}
	}
</script>

</head>
<body>
		<ul>
			<li onclick="testDiv(1)"> 김영일</li>
			<li onclick="testDiv(2)">27살</li>
			<li onclick="testDiv(3)">직업 대장</li>			
		</ul>
		
	<div id="op1">
		<table>
			<tr><th>아이디</th><th>이력서제목</th><th>학력</th></tr>
			<tr><td>aaaa</td><td>aaa</td><td>aaa</td></tr>
		</table>
	</div>
	<div id="op2">
		<table>
			<tr><th>아이디</th><th>이력서제목</th><th>학력</th></tr>
			<tr><td>bbb</td><td>bbb</td><td>bbbb</tr>
		</table>
	</div>
	<div id="op3">
		<table>
			<tr><th>아이디</th><th>이력서제목</th><th>학력</th></tr>
			<tr><td>cccc</td><td>cccc</td><td>cccc</td></tr>
		</table>
	</div>
</body>
</html>