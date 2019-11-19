package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.LoginDAO;
import ziozio.dao.impl.LoginDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDao = new LoginDAOImpl();


	@Override
	public User getLoginParam(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByUserid(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}


