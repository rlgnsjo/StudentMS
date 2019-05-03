package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class UpdatePlayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		int sid = Integer.parseInt(request.getParameter("input_id"));
		String sname = request.getParameter("input_name");
		int sage = Integer.parseInt(request.getParameter("input_age"));
		String smajor =	request.getParameter("input_major");
		String sphone =	request.getParameter("input_phone");
		
		MemberDTO mDto = new MemberDTO(sid, sname, sage, smajor, sphone);  //먼저 DTO에서 update용 생성자를 만들어준뒤 사용!!
		MemberDAO mDao =  MemberDAO.getInstance();
		int result = mDao.memUpdate(mDto);
		
		if (result > 0) {
			url = "select.shs";
		}else {
			url = "index.shs";
		}
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(true);  //sendRedirect
		
		return forward;
	}

}
