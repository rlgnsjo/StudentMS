package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_update.jsp";
		
		int id = Integer.parseInt(request.getParameter("id"));			
		//System.out.println("id=" + id);		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto =mDao.memInfo(id);		
		request.setAttribute("memInfo", mDto);  	
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(false);  //forward 방식으로 보냄
		
		return forward;
	}

}
