package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.LogoutService;
import ziozio.service.impl.LogoutServiceImpl;


@WebServlet("/account/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LogoutService logoutService = LogoutServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logoutService.logout(req, resp);
				
		//리다이렉트
		resp.sendRedirect("/");
	}
}
