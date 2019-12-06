package ziozio.controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import ziozio.service.face.LoginService;
import ziozio.service.impl.LoginServiceImpl;


/**
 * Servlet implementation class Modify
 */
@WebServlet("/account/modify")
public class ModifyAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/account/modify.jsp").forward(req, resp);	

	}
}
