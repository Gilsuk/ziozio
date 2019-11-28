package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.service.exception.CookieNotFoundException;
import ziozio.service.face.CookieService;
import ziozio.service.impl.CookieServiceImpl;

/**
 * Servlet implementation class RestoreSessionAccountController
 */
@WebServlet("/account/restoresession")
public class RestoreSessionAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CookieService cookieServ = CookieServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			cookieServ.restoreSessionAccount(req, resp);
			resp.sendRedirect("/main");
		} catch (CookieNotFoundException e) {
			// 클라이언트가 쿠키값을 가지고 있지 않음
			resp.sendRedirect("/account/login");
		} catch (SelectResultException e) {
			// 클라이언트가 쿠키를 가지고 있지만 만료됨
			resp.sendRedirect("/account/login");
		}
	}

}
