package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.CookieDAO;
import ziozio.dao.face.SessionDAO;
import ziozio.dao.impl.CookieDAOImpl;
import ziozio.dao.impl.SessionDAOImpl;
import ziozio.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private SessionDAO sDao = new SessionDAOImpl();
	private CookieDAO cDao = new CookieDAOImpl();

	@Override
	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		
		sDao.insertSessionId();
		cDao.insertCookieId();
		
		return false;
	}

}
