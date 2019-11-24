package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.impl.JoinDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.JoinService;
import ziozio.service.impl.JoinServiceImpl;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoinService joinService = JoinServiceImpl.getInstance();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/join/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String useremail = req.getParameter("useremail");
		resp.getWriter().write(new JoinDAOImpl().joinCheck(useremail) + "");
		
		User user = joinService.getJoinParam(req);
		
		joinService.join(user);

		
		
		resp.sendRedirect("/main");
	}

}
