package com.shs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

public class SearchPlayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_search.jsp";
		
		String name = request.getParameter("name");
		//System.out.println(name);
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberDTO> list = mDao.memSearch(name);		
		
		int search_cnt = list.size();
		request.setAttribute("name", name);
		request.setAttribute("search_cnt", search_cnt);
		request.setAttribute("shslist", list);
		//List<MemberDTO> list = new ArrayList<>();
		request.setAttribute("shslist", list);
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(false);  //forward 방식으로 보냄
		
		return forward;
	}

}
