package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.CookieDAO;
import ziozio.dao.face.SessionDAO;
import ziozio.dao.face.JoinDAO;
import ziozio.dao.impl.CookieDAOImpl;
import ziozio.dao.impl.SessionDAOImpl;
import ziozio.dao.impl.JoinDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private SessionDAO sDao = SessionDAOImpl.getInstance();
	private CookieDAO cDao = CookieDAOImpl.getInstance();
	private JoinDAO uDao = JoinDAOImpl.getInstance();

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
		
		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");
		boolean shouldKeepLogin = Boolean.parseBoolean(req.getParameter("keeplogin"));
		
		String userpw = uDao.selectUserpwById(id);
		
		if (!pw.equals(userpw)) return false;
		
		User user = uDao.selectUserById(id);
		
		sDao.insertUser(user);
		
		if (shouldKeepLogin) cDao.insertUser(user); 

		return false;
	}
}


