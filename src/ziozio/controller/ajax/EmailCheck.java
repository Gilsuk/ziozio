package ziozio.controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.impl.JoinDAOImpl;

/**
 * Servlet implementation class EmailCheck
 */
@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//중복 이메일(아이디) 확인
		
		String useremail = req.getParameter("useremail");
		resp.getWriter().write(new JoinDAOImpl().emailCheck(useremail) + "");
		
	}
	
}
