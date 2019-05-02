package com.shs.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dto.MemberDTO;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "shs_search.jsp";
		
		List<MemberDTO> list = new ArrayList<>();
		request.setAttribute("shslist", list);
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(false);  //forward 방식으로 보냄
		
		return forward;
	}

}
