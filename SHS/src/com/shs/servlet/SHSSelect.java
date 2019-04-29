package com.shs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shs.dao.MemberDAO;
import com.shs.dto.MemberDTO;

/**
 * Servlet implementation class SHSSelect
 */
@WebServlet("/SHSSelect")
public class SHSSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHSSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET:출석부  페이지 출력!!");
		
		
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberDTO> list = mDao.memSelect();
		
	
		
		// servlet에서 page이동방법 2가지!!
		//1.redirect 새로운 페이지로 이동 대신에 데이터 전송이 불가능하다(다만 쿼리스트링으로는 가능!). [url주소가 변경됨!]
		//DB를 타고난뒤 변화가 생기는 요청은 redirect를사용함!
		
		//2.forward  기존페이지에 페이지를 덮에씌우는 방법 데이터 전송이 가능하다.[url주소가 변경되지 않음!]
		// 검색이나 출석이나 조회같은DB가 변경되지않는 요청은 forward를 사용한다. 
		request.setAttribute("shslist", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("shs_select.jsp");		
		dis.forward(request, response);
		
		//response.sendRedirect("shs_select.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
