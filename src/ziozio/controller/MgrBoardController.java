package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.impl.AccountServiceImpl;

@WebServlet("/Mgr")
public class MgrBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private AccountService accountService= AccountServiceImpl.getInstance();
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Account account = null;
//		
//		try {
//			account = accountService.getLoggedInAccount(req);
//		} catch (AccountNotFountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if (account.getAccount_grade_code()==1) {
//			System.out.println("관리자");
//		}
		//관리자 권한으로만 로그인 가능하게...관리자 페이지 로그인해서 board, member로 넘기기
		req.getRequestDispatcher("/WEB-INF/views/mgr/mgr.jsp").forward(req, resp);

		}

}
