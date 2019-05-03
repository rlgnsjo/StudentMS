<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만든이</title>
<style type="text/css">
		@import url('https://fonts.googleapis.com/css?family=Jua&subset=korean');
		* {
			font-family: 'Jua', sans-serif;
			box-sizing: border-box;
		}
		body,ul {
			margin: 0;
			padding: 0;
		}
		a {
			color: inherit;
			text-decoration: none;
		}
		ul {
			list-style: none;
		}

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
		.shs_title {
			padding-top: 50px;
			text-align: center;
			font-size: 30px;
			color: black; 			
		}
		.shs_manager {
			padding-top: 20px;
			padding-bottom: 20px;
			text-align: center;
			color: #454552;
			font-size: 20px;
		}
		.shs_manager1 {
			padding-top: 20px;
			padding-bottom: 20px;
			text-align: center;
			color: #454552;
			font-size: 20px;
		}

		.btn_index {
			padding:12px 12px;
			height: 50px;
			background-color: yellowgreen;
			color: white;
			width: 280px;
			display: inline-block;
			border-radius: 10px;
			font-size: 17px;			
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
			padding: 9px 20px;				
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
			padding: 220px 0px;
			justify-content: space-evenly;
		}
		/* hr {
			margin: 2px 0px; 
			border: 1px dashed #515151;
		} */
	/* 	#input_id {
		background: lightyellow; 
		border: 1px solid #aaa!important;
		cursor: not-allowed;
	} */

	</style>
</head>
<body>
<div class="content">
		<a href="index.shs">
			<div class="shs_title">
				만든이!<br>
											
			</div>
		</a>	
		<div class="shs_manager"> -  사용해 주셔서 감사합니다! -  </div>
		<div class="shs_manager1">   저희 DB프로그램은  학생회원관리 수정등에 <br> 사용할수 있도록 최적화 되어있습니다.  </div>
		

		<form action="#" id="frm_insert" name="frm_insert" method="POST">
			
			<div class="div_index btn_wrap">
				<a href="index.shs" class="btn_index btn3">돌아가기</a>
				<!-- <a href="#" class="btn_index btn1">수정</a> -->
			</div>
		</form>
	</div>
</body>
</html>