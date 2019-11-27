package ziozio.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.service.face.LoginService;
import ziozio.service.impl.LoginServiceImpl;
import ziozio.utils.param.exception.InvalidParamException;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = LoginServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			loginService.login(req);
		} catch (InvalidParamException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (TooManyResultException e) {
			e.printStackTrace();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (AccountNotVerifiedException e) {
			e.printStackTrace();
		}
	}
}
