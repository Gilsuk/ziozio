package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	      HttpSession s = req.getSession();
	      
	      //로그인 세션정보 확인
//	      System.out.println(s.getAttribute("login"));
//	      System.out.println(s.getAttribute("useremail"));
//	      System.out.println(s.getAttribute("usernick"));
		
		req.getRequestDispatcher("/WEB-INF/views/main/main.jsp")
		.forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
	}
}
