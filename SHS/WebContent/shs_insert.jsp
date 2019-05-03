<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생등록</title>
	<link rel= "stylesheet" href= "css/common.css?v=1">	
	<style type="text/css">
		
		.content {
			width: 390px;
			height: 600px;
			border: 2px solid black;
			margin: 50px auto 0;
			background-color: #eee;
			border-radius: 5px;
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		
		.shs_manager {
			padding-top: 20px;
			padding-bottom: 20px;
			text-align: center;
			color: #454552;
			font-size: 20px;
		}
		.btn_index {
			padding: 10px 12px;
			background-color: yellowgreen;
			color: white;
			width: 90px;
			display: inline-block;
			border-radius: 10px;
			font-size: 17px;	
			border: none;
			curser: pointer;		
		}
		.btn_index:hover{
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		.div_index {
			padding-bottom: 22px;
			text-align: center; 
		}
		
		.btn2 {
			background-color: orange;			 
		}
		.btn3 {
			background-color: salmon;
		}
		.in_content {
			text-align: right;			 
		}
		.div_input {
			padding: 3px 20px;				
		}
		.div_input > label {
			float: left;
			line-height: 40px;
		}
		.shs_input {
			width: 270px;
			display: inline-block;
			height: 40px;
			font-size: 16px;
			color: #515151;
			outline: none;
			border: 1px solid #aaa;
			padding: 0 10px;
		}
		.btn_wrap {
			display: flex;
			padding: 15px 0px;
			justify-content: space-evenly;
		}
		.err_msg {
			color:tomato;
			font-size:14px;
			display: none;
			text-align: left; 
			padding-left: 80px;
		}
	</style>
</head>
<body>
	<div class="content">
		<%@ include file="include/header.jsp" %>	
		<div class="shs_manager"> - 학사등록 - </div>
		<form action="insertPlay.shs" id="frm_insert" name="frm_insert" method="POST">
			<div class="in_content">				
				<div class="div_input">
					<label for="input_name">이름:</label>
					<input type="text" id="input_name" name="input_name" class="shs_input" placeholder="이름"><br>	
					<span class= "err_msg" ></span>				
				</div>
				<div class="div_input">
					<label for="input_age">나이:</label>
					<input type="text" id="input_age" name="input_age" class="shs_input" placeholder="나이"><br>
					<span class= "err_msg" ></span>						
				</div>
				<div class="div_input">
					<label for="input_major">전공:</label>
					<input type="text" id="input_major" name="input_major" class="shs_input" placeholder="전공"><br>		
					<span class= "err_msg" ></span>				
				</div>
				<div class="div_input">
					<label for="input_phone">핸드폰번호:</label>
					<input type="text" id="input_phone" name="input_phone" class="shs_input" placeholder="핸드폰번호"><br>
					<span class= "err_msg" ></span>			
				</div>
			</div>
			<div class="div_index btn_wrap">
				<a href="index.shs" class="btn_index btn3">취소</a>
				<!-- <a href="#" class="btn_index btn1 submitBtn">등록</a> -->
				<!--(1) button클릭시 jQuery의 click()이벤트 발생  
				   jQeuery click()이벤트 function()으로 이동 -->
				<button type="submit" class="btn_index btn1 submitBtn">등록</button>
			</div>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<script type="text/javascript" src="js/validation.js"></script>
	<script type="text/javascript">
		$(function(){
			//shs_input태그 focus() => border효과를 준것.
			$('.shs_input').focus(function() {
				$(this).css('border', '1px solid dodgerblue');
			});
			$('.shs_input').blur(function() {
				$(this).css('border', '1px solid #aaa');
			});
			
			// keyup()을 활용한 유효성 체크input값
			$('#input_name').keyup(function() {		//키가 눌렸을때 val 							
				nameCheck();			
			});
			//여기부터  비밀번호 유효성체크 
			$('#input_age').keyup(function() {								 							
				ageCheck();
			});
			$('#input_major').keyup(function() {								  											
				majorCheck();											
			});
			$('#input_phone').keyup(function() {												
				phoneCheck();				
				
			});
		
			
			
			//등록 버튼 클릭시 form태그 안에 있는 input태그의 값을 Servelt으로 전송 
			$('.submitBtn').click(function(){
				// (2)	유효성 체크 시작
				
				if(!nameCheck()){
					$('#input_name').focus();
					return false;
				}
				if(!ageCheck()){
					$('#input_age').focus();
					return false;
				}
				if(!majorCheck()){
					$('#input_major').focus();
					return false;
				}
				if(!phoneCheck()){
					$('#input_phone').focus();
					return false;
				}
				
				// ----유효성 체크완료 --
				//-- 유효한 값만 있음 --
				
				//form태그의 action주소로 method방식을 통하여 데이터를 전송
				
				//method: POST방식 
				
				//(3) 유효성 체크 완료:모두 유효한 값으로 판명 #frm_insert 속성을 가진 form태그를 submit()함.
				//    submit동작  Method = POST Action ="insertPlay.shs" form태그 내부에 있는 input
				//    태그들의 value를 POST방식으로 insertPlay.shs(FrontController)로 전송.
				
				$('#frm_insert').submit();
				
			});
		});
		
		
	</script>
</body>
</html>