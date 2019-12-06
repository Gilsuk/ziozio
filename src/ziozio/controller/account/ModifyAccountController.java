package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/account/modify")
public class ModifyAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		
		
		req.getRequestDispatcher("/WEB-INF/views/account/modify.jsp").forward(req, resp);	
	}
}
