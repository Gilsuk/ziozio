package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.State;
import ziozio.service.face.LoginService;
import ziozio.service.face.StateService;
import ziozio.service.impl.LoginServiceImpl;
import ziozio.service.impl.StateServiceImpl;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService = LoginServiceImpl.getInstance();
	private StateService stateService = StateServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		State state = stateService.getState(req);
		if (state.isAuthenticated()) {
			// 이미 로그인 상태인 경우
		} else {
			// 비 로그인 상태일 때 로그인 페이지로 연결
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		State state = stateService.getState(req);
		if (state.isAuthenticated()) {
			// 이미 로그인 상태인 경우
		} else {
			// 비 로그인 상태일 때 로그인 처리
			if (loginService.login(req, resp)) {
				// 로그인 성공시
			} else {
				// 로그인 실패
			}
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}
		
	}

}
