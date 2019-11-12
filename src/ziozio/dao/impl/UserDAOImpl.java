package ziozio.dao.impl;

import ziozio.dao.face.UserDAO;
import ziozio.dto.State;
import ziozio.dto.User;

public class UserDAOImpl implements UserDAO {

    private UserDAOImpl() {
    }
 
    private static class Factory {
        public static final UserDAO INSTANCE = new UserDAOImpl();
    }
 
    public static UserDAO getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public String selectUserpwById(String id) {
		return null;
	}

	@Override
	public User selectUserById(String id) {
		return null;
	}

	@Override
	public State selectUserByUserno(int userno) {
		return null;
	}
}
