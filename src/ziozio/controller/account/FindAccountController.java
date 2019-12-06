package ziozio.controller.account;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.enumeration.VerificationType;
import ziozio.service.face.AccountService;
import ziozio.service.face.VerificationService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.VerificationServiceImpl;


@WebServlet("/account/find")
public class FindAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService = AccountServiceImpl.getInstance();
	private VerificationService verificationService = VerificationServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/account/find.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String account_email = req.getParameter("account_email");
		Account account = accountService.getAccountByEmail(account_email);
		try {
			account = accountService.getAccountByEmail(account);
			accountService.generateKey(account);
		}  catch (SQLException e) {

		} 
		try {
			String queryString = verificationService.getQueryString(account, VerificationType.FIND);
			resp.getWriter().println("/account/verify?" + queryString);
		} catch (SelectResultException e) {
			resp.sendRedirect("/main");
		}

	}
}
