package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.exception.AccountNotFountException;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.service.face.LoginService;
import ziozio.service.impl.LoginServiceImpl;
import ziozio.utils.param.exception.InvalidParamException;


@WebServlet("/account/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (loginService.isLoggedIn(req)) {
			// 이미 로그인된 경우
			resp.sendRedirect("/main");
			return;
		}
		try {
			loginService.login(req, resp);
			// 로그인 성공시 처리
			resp.sendRedirect("/main");
		} catch (InvalidParamException e) {
			// 사용자가 입력한 값이 잘못됐을 때 처리
			resp.getWriter().println("Invalid Param");
		} catch (AccountNotFountException e) {
			// ID & PW가 일치하지 않을 때 처리
			resp.getWriter().println("Id or Pw not match");
		} catch (AccountNotVerifiedException e) {
			// 계정이 미인증된 상태일 때 처리
			resp.getWriter().println("Not email-verified user");
		}
	}
}
