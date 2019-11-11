package ziozio.dao.impl;

import ziozio.dao.face.SessionDAO;
import ziozio.dto.User;

public class SessionDAOImpl implements SessionDAO {

    private SessionDAOImpl() {
    }
 
    private static class Factory {
        public static final SessionDAO INSTANCE = new SessionDAOImpl();
    }
 
    public static SessionDAO getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public boolean insertSessionId() {
		return false;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
