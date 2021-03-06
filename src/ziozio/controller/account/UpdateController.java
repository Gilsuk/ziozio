package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ziozio.dto.Account;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.LoginService;
import ziozio.service.impl.AccountServiceImpl;

import ziozio.utils.param.exception.InvalidEmailParamException;

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

		
	     resp.setContentType("text/html; charset=UTF-8");
	     req.setCharacterEncoding("UTF-8");
	     
	      HttpSession session = req.getSession();
	   
	      Account pw = null;
		try {
			pw = accountService.getLoggedInAccount(req);
			pw.setAccount_no((Integer) session.getAttribute("Account_no"));  
			pw.setAccount_email((String) session.getAttribute("Account_email"));
		} catch (AccountNotFountException | InvalidEmailParamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      

	
		
	
		resp.sendRedirect("/account/main");	
	}


	
}
