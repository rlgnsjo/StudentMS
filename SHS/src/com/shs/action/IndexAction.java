package com.shs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements  Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)  //여기서도 request, response를 매개변수로 가지고 있다.
			throws ServletException, IOException {
		String url = "shs_index.jsp";
		
		ActionForward  forward = new ActionForward(); 
		forward.setpath(url);  // 경로를 찾아감. 액션포워드의 setpath 메서드를 탐. 
		forward.setRedirect(false);  //forward 방식으로 보냄
		
		return forward;
	}
  
}
