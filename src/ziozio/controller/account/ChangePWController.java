package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.exception.ParamNotAllowedException;
import ziozio.service.face.AccountService;
import ziozio.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class ChangePWController
 */
@WebServlet("/account/changepw")
public class ChangePWController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			accountService.getLoggedInAccount(req);
			req.getRequestDispatcher("/WEB-INF/views/account/changepw.jsp").forward(req, resp);
		} catch (AccountNotFountException e) {
			resp.sendRedirect("/main");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Verification veri = accountService.getVerificationFromParam(req);
			AccountWithPw account = accountService.getAccountByPwNo(req);
			if (accountService.verify(veri)) {
				accountService.setpw(account);
			}
		} catch (ParamNotAllowedException e) {
		}
		
		resp.sendRedirect("/main");
		
	}

}
