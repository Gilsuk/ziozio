package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.JoinDAO;
import ziozio.dao.impl.JoinDAOImpl;
import ziozio.service.face.EmailService;
import ziozio.service.face.UserService;
import ziozio.service.impl.EmailServiceImpl;
import ziozio.service.impl.UserServiceImpl;


@WebServlet("/findpw")
public class FindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();
	private EmailService emailService = EmailServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String email = userService.getUserMail(req);
		emailService.sendLinkForPW(email);

		
		req.getRequestDispatcher("/WEB-INF/views/findpw/findpw.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		
	}
}
