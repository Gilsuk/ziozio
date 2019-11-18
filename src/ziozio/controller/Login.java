package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import ziozio.dto.State;
import ziozio.dto.User;
import ziozio.service.face.StateService;
import ziozio.service.face.UserService;
import ziozio.service.impl.StateServiceImpl;
import ziozio.service.impl.UserServiceImpl;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StateService stateService = StateServiceImpl.getInstance();
	private UserService userService = new UserServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = userService.getLoginParam(req);
		
		
		
		boolean result = userService.login(user);

		HttpSession session = null;
		session = req.getSession();

		if(result) {
			
			User u = userService.getMemberByUserid(user);
			
			//로그인 성공
			session.setAttribute("login", true);//세션 정보 저장
			session.setAttribute("userid", u.getUserid());//세션 정보 저장
			session.setAttribute("usernick", u.getUsernick());//세션 정보 저장
			
			resp.sendRedirect("/main");

		} else {
			req.setAttribute("result", result);
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}

	}
}
