package com.shs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.shs.action.Action;
import com.shs.action.ActionForward;
import com.shs.action.IndexAction;

/**
 * Servlet implementation class FrontController
 */
 //FrontController 패턴
 // 앞단에서 Controller 역할을 하는 servlet 1개만 생성후 
 // 생성된 1개의 servlet이 request와 response를 모두 처리하고, 실제
 // 동작하는 Action부분만 Class로 여러개 생성해서 사용하는 방법 
 // 기존에 동작마다 Servlet을 생성하는 방식에 비해 효율성이 올라감. 
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L; //long은 변수타입중 하나 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	// doGet(), doPost(), 모두 service()를 통해서 작동함! 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐(POST방식): 가장위에 적어줘야함!!!
		request.setCharacterEncoding("UTF-8");
		
		Action action = null;
		ActionForward forward = null;  //action에 보낸 forward값이 담겨있음. 
		
		String uri = request.getRequestURI();   // 
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length()); //substring은 문자열값을 빼준다. uri에서  ctx 글씨값을 뺀값이 command다.  
		// url 에서 ctx를 빼면 내가 원하는 소스만 뽑을수 있다.
		
		System.out.println("페이지 이동====>" + command);
		//System.out.println("ctx====>" + ctx);
		//System.out.println("uri====>" + uri);
		
		
		if (command.equals("/index.shs")) {
			action = new IndexAction();  // new IndexAction()객체를 생성
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		}
		
		//--------- 공통분기 작업-----------
		if (forward != null) {
			if(forward.isRedirect()) {  //actionForward class의isRedirect() 함수를 실행! isRedirect()에는 false값이 들어있으므로 실행 X
				                        //page 전환시 redirect방식
				response.sendRedirect(forward.getpath());
			}else {
				// page전환시 forward방식 
				RequestDispatcher rd = request.getRequestDispatcher(forward.getpath());
				rd.forward(request, response);
			}
		}
	
		
		
	}

}
