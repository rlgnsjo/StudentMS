package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class InsertPlayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		//(7) jsp -> Frontcontroller -> InsertPlayAction으로 request를 사용하여 전송한 input태그들의 value를 꺼내서
		// sname, sage, smajor, sphone 변수에 각각담음.   
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor =	request.getParameter("input_major");
		String sphone =	request.getParameter("input_phone");
		
		// (8) Model START!
		// MemberDAO객체를 빌려온다.
		MemberDAO mDao = MemberDAO.getInstance(); //sqlSessinonFactory를 빌려줌	
		//(9)MemberDTO객체 생성과 동시에 (이름, 나이, 전공, 번호) 값을 담아줌. 
		MemberDTO mDto = new MemberDTO(sname,sage,smajor,sphone); 
		//(10) Member.DAO클래스의  memInsert()함수를 실행 매개변수로 (이름, 나이,전공, 번호) 가 담긴 mDto를 전송
		int result = mDao.memInsert(mDto); //sqlSession 생성
		//(16)MemberDAO의 memInsert()메서드에서 보낸 return값을 result변수에 담음.  
		
		//(17) result > 0 : 등록 성공  
		//     else: 등록 실패 
		//  등록 성공시 이동하는 페이지를 welcome페이지로 설정
		//   등록 실패시 이동하는 페이지를 학생등록페이지로 설정
		if(result > 0) {
			url = "welcome.shs";
		} else {
			url = "insert.shs";
		}
		
		//(18) ActionForward 객체를 생성후 forward 인스턴스를 활용하여
		// forward인스턴스의 path변수에 "welcome.shs"를 forward 인스턴스의 isRedirect변수에 true값을 각각담음.
		ActionForward forward = new ActionForward(); 
		forward.setpath(url);
		forward.setRedirect(true);  //sendredirect방식으로 전송
		
		
		 // (19).path와 isRedirect값을 담고 있는 forward를 return을 사용하여 호출한곳(FrontController)으로 전송.
		return forward;		
	}

}
