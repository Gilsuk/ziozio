package ziozio.controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.impl.JoinDAOImpl;

/**
 * Servlet implementation class NickCheck
 */
@WebServlet("/nickcheck")
public class NickCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usernick = req.getParameter("usernick");
		resp.getWriter().write(new JoinDAOImpl().nickCheck(usernick) + "");
		
	}
}
