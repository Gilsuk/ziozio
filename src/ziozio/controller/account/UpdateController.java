package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.AccountService;
import ziozio.service.impl.AccountServiceImpl;


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
		
		
		

	
		req.setCharacterEncoding("UTF-8");
	
		resp.sendRedirect("/account/main");	
	}
	
}
