<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn3").click(function(){
			//$("#frm").submit();
			$("#frm").ajaxSubmit({
				type : "post",
				url : "ajaxTest1",
				dataType : "html",
				success : function(result){ //익명함수 
					$("#notice_content").html(result);
				},
				error: function(){
					alert('에러가 나왔다 홀홀홀~');
					return;
				}
			});
		});
	
	
	$("#btn4").click(function(){
		var aaa = {/* 일반적으로 option 이라고 쓴다 */
			type : "post",
			url : "ajaxTest1",
			dataType : "html",
			success : function(result){ //익명함수 
				$("#notice_content").html(result);
			},
			error: function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			}
	 	}
		
		$("#frm").ajaxSubmit(aaa);
	});

	
	
	$("#btn5").click(function(){
		//$("#frm").submit();
		var option = {
				type : "post",
				url : "ajaxTest1",
				dataType : "html",
				beforeSubmit : beforeTest,
				success : okTest,
				error: err
			}
		$("#frm").ajaxSubmit(option);
	});
});
	
	
	
	
	
	
	function err(){
		alert("에러가 나왔다");
		return false;
	}
	function okTest(responseText, statusText,xhr,$form){
		if(statusText == "success"){
			$("#notice_content").html(responseText);
			$form.css('background','red');
		}
	}
	
	
	function beforeTest(){
		if($("#n").val() == ""){
			alert("값을 입력해 주세요.");
			$("#n").focus();
			return false;
		}else{
			alert("아작스가 submit하기전에 실행되는 함수");
		}
	}


	function testDiv(num) {
/* location.href="ajaxTest1?n="+num */
		$.ajax({
			type : "post",
			url : "ajaxTest1",
			dataType : "html",
			data : "n="+num,
			success : function(result){ /*매개변수 아무렇게나 적어도 됨  리설트로 테이블이 날라옴*/
			 	$("#notice_content").html(result);
			},
			error : function(){
				alert('에러가 발생했습니다.');
				return ;
			}
		}); 
	 }  
</script>
</head>
<body>
		<ul>
			<li onclick="testDiv(1)"> 김영일</li>
			<li onclick="testDiv(2)">27살</li>
			<li onclick="testDiv(3)">직업 대장</li>			
		</ul>
		<div id="notice_content"></div>
		
		<form name="frm" id="frm" action="ajaxTest1" >
	<input type="text" id="n" name="n">
</form>
	<button id="btn3" >버튼2</button>
	<button id="btn4" >버튼3</button>
	<button id="btn5" >버튼4</button>
</body>
</html>