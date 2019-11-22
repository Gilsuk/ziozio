package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ziozio.dto.User;
import ziozio.service.face.LoginService;
import ziozio.service.impl.LoginServiceImpl;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		
		User user = loginService.getLoginParam(req);
		
		boolean result = loginService.login(user);

		HttpSession session = null;
		session = req.getSession();

		if(result) {
			
			User u = loginService.getLoginByUserid(user);
			
			//로그인 성공
			session.setAttribute("login", true);//세션 정보 저장
			session.setAttribute("useremail", u.getUseremail());//세션 정보 저장
			session.setAttribute("usernick", u.getUsernick());//세션 정보 저장
			
			resp.sendRedirect("/main");

		} else {
			req.setAttribute("result", result);
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}

	}
}
