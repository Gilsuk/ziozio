package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.MyPage;
import ziozio.dto.State;
import ziozio.dto.User;
import ziozio.service.face.StateService;
import ziozio.service.face.UserService;
import ziozio.service.impl.StateServiceImpl;
import ziozio.service.impl.UserServiceImpl;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StateService stateService = StateServiceImpl.getInstance();
	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		State state = stateService.getState(req);
		User user = state.getUser();
		
		if (state.isAuthenticated()) {
			MyPage myPage = userService.getMyPage(user);
			req.setAttribute("myPage", myPage);
		}

	}

}
