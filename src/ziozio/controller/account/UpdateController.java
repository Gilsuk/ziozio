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
import ziozio.service.impl.AccountServiceImpl;
import ziozio.utils.param.exception.InvalidEmailParamException;


@WebServlet("/account/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/modify.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	     resp.setContentType("text/html; charset=UTF-8");
	      
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
	      
	      
	      System.out.println(pw);
	      
//	      boolean curpw = accountService.
//	      
//	      if(curpw) { // 비밀번호가 일치하면
//	    	 pw.setAccount_pw(req.getParameter("account_pw1")); //파라미터(req) pw값 수정할 비밀번호로 바꿔주기
//	         accountService.(pw); // 새로운비밀번호
//	         System.out.println();         
//	         resp.sendRedirect("/mypage");
//	      } else {
//	         // 비밀번호가 일치하지 않는다면
//	         
//	     
//		
//
//	
//		req.setCharacterEncoding("UTF-8");
//	
//		resp.sendRedirect("/account/main");	
//	}
	}
}
