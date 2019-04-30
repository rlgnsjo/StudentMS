function nameCheck() {
	var name = $.trim($('#input_name').val());
	// 공백 문자 체크  =var regEmpty = /\s/g;
	var regEmpty = /\s/g;
	// 숫자를 못들어오게 체크 
	var regNum = /[~0-9]/g;

	//name 값이 공백이거나 name값의 길이가 0이면 해당 if문 실행문 실행
	if (name == '' || name.length == 0) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('필수 정보입니다.');
		// (regNum정규식체크이용)숫자가 들어왔을때 경고문을 주기위해 작성한 유효성체크.

	} else if (regNum.test(name)) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('문자값만 들어올수 있습니다 .');
		return false;
	} else if (name.match(regEmpty)) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('공백값은 들어올수 없습니다.');
		return false;
	} else if (name.length > 4 || name.length < 2) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('2~4글자로만 입력해주세요.');
		return false;
	} else {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'dodgerblue')
				.text('멋진이름이네요.');
		return true;
	}	
}



function ageCheck() {
	var age = $.trim($('#input_age').val()); 	//$.trim = 문자열 좌우값중 공백을 없애주는기능을함 .val()은 양식(form)의 값을 가져오거나 값을 설정하는 메소드
	if (age == '' || age.length == 0) {
		$('.err_msg').eq(1).css('display', 'block')
						   .css('color', 'tomato')
						   .text('필수 정보입니다.');
		return false;
	}else if(isNaN(age)){
		$('.err_msg').eq(1).css('display', 'block')
					       .css('color', 'tomato')
					   	   .text('숫자만 입력하세요.');	
		return false;
	}else if (age > 99 || age < 19) {
		$('.err_msg').eq(1).css('display', 'block')
						   .css('color', 'tomato')
	                	   .text('19세부터99세 까지만 입력하세요.');	
		return false;
	}else{
		$('.err_msg').eq(1).css('display', 'block')
					       .css('color', 'dodgerblue')
					   	   .text('등록가능한 나이입니다.');	
		return true;
	}
}
function majorCheck(){
	var major = $.trim($('#input_major').val());
	var regEmpty = /\s/g; 				 
	var regNum = /[~0-9]/g;
	if(major.length == 0){
		$('.err_msg').eq(2).css('display', 'none');	
		return true;
	}else if (regNum.test(major)) {
		$('.err_msg').eq(2).css('display', 'block')
					       .css('color', 'tomato')
						   .text('문자값만 들어올수 있습니다 .');
		return false;
	} else if (major.match(regEmpty)) {
		$('.err_msg').eq(2).css('display', 'block')
							.css('color', 'tomato')
							.text('공백값은 들어올수 없습니다.');
		return false;
	} else {
		$('.err_msg').eq(2).css('display', 'block')
							.css('color', 'dodgerblue')
							.text('멋진전공이네요.');
		return true;
	}
}
function phoneCheck(){
	var phone = $.trim($('#input_phone').val());  
	var phoneReg = RegExp(/^[0-9]{8,11}$/); 	
	if (phone == '' || phone.length == 0) {
		$('.err_msg').eq(3).css('display', 'block')
							.css('color', 'tomato')
							.text('필수 정보입니다.');				
		return false;
	}else if (isNaN(phone)) {
		$('.err_msg').eq(3).css('display', 'block')
							.css('color', 'tomato')
							.text('숫자만 들어올수 있습니다 .');
		return false;
	}else if (!phoneReg.test(phone)) {
		$('.err_msg').eq(3).css('display', 'block')
							.css('color', 'tomato')
							.text('올바른 값을 입력해주세요.');
		return false;
	}else {
		$('.err_msg').eq(3).css('display', 'block')
							.css('color', 'dodgerblue')
							.text('등록 가능번호 입니다.');
		return true;
	}
}
