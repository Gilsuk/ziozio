package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
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
	
	req.getRequestDispatcher("/WEB-INF/views/account/changepw.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		verification_code
//		account_no
//		pw
		Verification veri = accountService.getVerificationFromParam(req);
		AccountWithPw account = accountService.getAccountByPwNo(req);
		if (accountService.verify(veri)) {
			accountService.setpw(account);
			
		}
		
		resp.sendRedirect("/main");
		
	}

}
