package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.CookieDAO;
import ziozio.dao.face.SessionDAO;
import ziozio.dao.impl.CookieDAOImpl;
import ziozio.dao.impl.SessionDAOImpl;
import ziozio.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private SessionDAO sDao = SessionDAOImpl.getInstance();
	private CookieDAO cDao = CookieDAOImpl.getInstance();

    private LoginServiceImpl() {
    }
 
    private static class Factory {
        public static final LoginService INSTANCE = new LoginServiceImpl();
    }
 
    public static LoginService getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		return false;
	}
}


