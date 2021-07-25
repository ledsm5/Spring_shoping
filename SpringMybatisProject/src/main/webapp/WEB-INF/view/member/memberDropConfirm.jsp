<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"> <!-- google font -->


 <style>
 

    .btn{  
      text-decoration: none;
      font-size:2rem;
      color:white;
      padding:10px 20px 10px 20px;
      margin:20px;
      display:inline-block;
      border-radius: 10px;
      transition:all 0.1s;
      text-shadow: 0px -2px rgba(0, 0, 0, 0.44);
      font-family: 'Lobster', cursive; <!-- google font -->
    }
    .btn:active{
      transform: translateY(3px);
    }
    .btn.blue{
      background-color: #1f75d9;
      border-bottom:5px solid #165195;
    }
    .btn.blue:active{
      border-bottom:2px solid #165195;
    }
    .btn.red{
      background-color: #ff521e;
      border-bottom:5px solid #c1370e;
    }
    .btn.red:active{
      border-bottom:2px solid #c1370e;
    }
  </style>



</head>
<body>
	정말 탈퇴 하시겠습니까? <br>
	<a href="myPage" class="btn blue">plz Give me a chance..ㅠㅠ</a>
	<form action="memDropConfirm" >
		<input type="hidden" name="noticeNo" value="${noticeNo }"> 
		<input type="submit" value="Yes" class="btn red">
	</form>
</body>
</html>