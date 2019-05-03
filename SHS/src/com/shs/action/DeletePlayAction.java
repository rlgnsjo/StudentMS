package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;

public class DeletePlayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		int id = Integer.parseInt(request.getParameter("id"));						
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memDelete(id);
		
		if (result > 0) {
			url = "select.shs";
		}else {
			url = "index.shs";
		}
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(false);  //forward 방식으로 보냄
		
		return forward;
	}

}
