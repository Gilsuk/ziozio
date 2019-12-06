package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.AccountService;
import ziozio.service.face.LoginService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.LoginServiceImpl;


@WebServlet("/account/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountService accountService = AccountServiceImpl.getInstance();
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		if(loginService.isLoggedIn(req))
			req.getRequestDispatcher("/WEB-INF/views/mypage/modify.jsp").forward(req, resp);
		else
			loginService.loginAndRedirect(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
	
		resp.sendRedirect("/account/main");	
	}
	
}
