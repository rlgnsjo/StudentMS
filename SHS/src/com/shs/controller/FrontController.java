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
import com.shs.action.DeletePlayAction;
import com.shs.action.IndexAction;
import com.shs.action.InsertAction;
import com.shs.action.InsertPlayAction;
import com.shs.action.IntroduceAction;
import com.shs.action.SearchAction;
import com.shs.action.SearchPlayAction;
import com.shs.action.SelectPlayAction;
import com.shs.action.UpdateAction;
import com.shs.action.UpdatePlayAction;
import com.shs.action.WelcomeAction;


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
		
		//4(4).uri와 ctx를 뻬서 남은 경로를 생성한다. 
		// uri = /SHS/insert.shs
		// ctx/SHS
		//uri - ctx = /insert.shs =command
		
		

		//(4).uri와 ctx를 뻬서 남은 경로를 생성한다. 
		// uri = /SHS/insertPlay.shs
		// ctx/SHS
		//uri - ctx = /insertPlay.shs =command
		
		
		String uri = request.getRequestURI();   // 
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length()); //substring은 문자열값을 빼준다. uri에서  ctx 글씨값을 뺀값이 command다.  
		// url 에서 ctx를 빼면 내가 원하는 소스만 뽑을수 있다.
		
		System.out.println("페이지 이동====>" + command);
		//System.out.println("ctx====>" + ctx);
		//System.out.println("uri====>" + uri);
		
		// 5.if문을 돌면서 생성한 url주소(/insert.shs)와 같은 조건문을 탐색 
		
		// (5).if문을 돌면서 생성한 url주소(/insertPlay.shs)와 같은 조건문을 탐색 
		if (command.equals("/index.shs")) {
			action = new IndexAction();  // new IndexAction()객체를 생성
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/insert.shs")) {
			// 6.InsertAction 클래스 객체 생성후 생성된action 인스턴스를 사용하여 execute(request, response) 함수를 실행
			// 매개변수로 request와 response를 전송.
			action = new InsertAction();  
			
			//9. InsertAction 클래스에서 보낸 return값 (forward)를 전역변수 forward에 담음.
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/insertplay.shs")) {
			// (6).InsertPlayAction 클래스 객체 생성후 생성된action 인스턴스를 사용하여 execute(request, response) 함수를 실행
			// 매개변수로 request와 response를 전송. 현재 jsp에서 보낸 input태그들의 값은 request에 담겨있음. 
			// execute()함수를 실행할 때 매개변수로 request를 전송함으로 InsertPlayAction 클래스에서 input태그들의 값을 사용할수 있음.
			action = new InsertPlayAction();  //
			//(20). InsertPlayAction 클래스에서 보낸 return값 (forward)를 전역변수 forward에 담음.
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/welcome.shs")) {
			action = new WelcomeAction();  //
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/search.shs")) {
			action = new SearchAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/searchPlay.shs")) {
			action = new SearchPlayAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/introduce.shs")) {
			action = new IntroduceAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/select.shs")) {
			action = new SelectPlayAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/update.shs")) {
			action = new UpdateAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		}  else if (command.equals("/updatePlay.shs")) {
			action = new UpdatePlayAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} else if (command.equals("/delete.shs")) {
			action = new DeletePlayAction();  // 
			forward = action.execute(request, response); // 인스턴스를 사용해서 execute함수를 사용해서	request, response를 매개변수로 반환		
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		//--------- 공통분기 작업-----------
		
		// 10. InsertAction에서 보낸 return값 forward를 사용하여 페이지 이동경로와 방법 데이터를 전송
		// forward.getPath() = "shs_insert.jsp"     forward.isRedirect() = false;
		// forward가 null이 아니기 때문에 if문 실행. 
		
		
		// (21). InsertPlayAction에서 보낸 return값 forward를 사용하여 페이지 이동경로와 방법 데이터를 전송
				// forward.getPath() = "welcome.jsp"     forward.isRedirect() = true;
				// forward가 null이 아니기 때문에 if문 실행. 
		if (forward != null) {
			
			//  11. forward.isRedirect() 가 false 이기 때문에 if문을 실행하지않고 else문 실행
			
			//  (22). forward.isRedirect() 가 true 이기 때문에 if문을 실행하지않고 else문 실행
			if(forward.isRedirect()) {  
				//(23). sendRedirect방식으로 'welcome.jsp'페이지 이동
				response.sendRedirect(forward.getpath());
			}else {
				// 12. forward방식으로 'shs_insert.jsp'페이지 이동
				RequestDispatcher rd = request.getRequestDispatcher(forward.getpath());
				rd.forward(request, response);
			}
		}
	
		
		
	}

}
