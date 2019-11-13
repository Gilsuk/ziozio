package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.UserDAO;
import ziozio.dao.impl.UserDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.JoinService;

public class JoinServiceImpl implements JoinService {
	
	private UserDAO uDao = UserDAOImpl.getInstance();

    private JoinServiceImpl() {
    }
 
    private static class Factory {
        public static final JoinService INSTANCE = new JoinServiceImpl();
    }
 
    public static JoinService getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public void join(HttpServletRequest req) {
		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");

		uDao.insertUser(id, pw);
	}
	
	

}
