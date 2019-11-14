package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.MyPageDAO;
import ziozio.dao.impl.MyPageDAOImpl;
import ziozio.dto.MyPage;
import ziozio.dto.User;
import ziozio.service.face.UserService;

public class UserServiceImpl implements UserService {

	private MyPageDAO mDao = MyPageDAOImpl.getInstance();
    private UserServiceImpl() { } 
    private static class Factory {
        public static final UserService INSTANCE = new UserServiceImpl();
    }
    public static UserService getInstance() { return Factory.INSTANCE; }

	@Override
	public MyPage getMyPage(User user) {

		return null;
	}

	@Override
	public String getUserMail(HttpServletRequest req) {
		return null;
	}
}
