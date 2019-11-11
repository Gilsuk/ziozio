package ziozio.dao.impl;

import ziozio.dao.face.UserDAO;

public class UserDAOImpl implements UserDAO {

    private UserDAOImpl() {
    }
 
    private static class Factory {
        public static final UserDAO INSTANCE = new UserDAOImpl();
    }
 
    public static UserDAO getInstance() {
        return Factory.INSTANCE;
    }
}
