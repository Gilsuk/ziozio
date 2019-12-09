package ziozio.controller.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.enumeration.VerificationType;
import ziozio.service.exception.TypeNotAllowedException;
import ziozio.service.face.AccountService;
import ziozio.service.face.VerificationService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.VerificationServiceImpl;

/**
 * Servlet implementation class AccountVerifyController
 */
@WebServlet("/account/verify")
public class AccountVerifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VerificationService verificationService = VerificationServiceImpl.getInstance();
	private AccountService accountService = AccountServiceImpl.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account account = verificationService.getAccountno(request);
		VerificationType type;
		try {
			type = verificationService.getType(request);
		} catch (TypeNotAllowedException e) {
			response.sendRedirect("/main");
			return;
		}

		try {
			String queryString = verificationService.getQueryString(account, type);
			System.out.println(queryString);
			if (queryString.equals(request.getQueryString())) {
				if (type == VerificationType.EMAIL) {
					accountService.verify(account);
					response.getWriter().println("verified");
					return;
				} else if (type == VerificationType.FIND) {
					request.getRequestDispatcher("/WEB-INF/views/account/changepw.jsp")
					.forward(request, response);
					return;
				}
			}
		} catch (SelectResultException e) {
			response.sendRedirect("/main");
			return;
		}
		response.sendRedirect("/main");

	}

}
