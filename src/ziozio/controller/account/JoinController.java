package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.exception.AccountDuplicateException;
import ziozio.service.face.JoinService;
import ziozio.service.face.LoginService;
import ziozio.service.impl.JoinServiceImpl;
import ziozio.service.impl.LoginServiceImpl;
import ziozio.utils.param.exception.InvalidParamException;

/**
 * Servlet implementation class Join
 */
@WebServlet("/account/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoinService joinService = JoinServiceImpl.getInstance();
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (loginService.isLoggedIn(req))
			resp.sendRedirect("/main");
		else
			req.getRequestDispatcher("/WEB-INF/views/account/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		try {
			joinService.join(req);
		} catch (InvalidParamException e) {
			// 인풋 파라미터가 유효하지 않을 때 처리(email 값을 이상한 것으로 넘긴다던지 패스워드가 너무 짧을 때 등)
			resp.getWriter().println("invalid parameter");
		} catch (AccountDuplicateException e) {
			// DB에 저장이 안될 때 처리(email, nick 중복, 등)
			resp.getWriter().println("duplicate");
		}
	}

}
