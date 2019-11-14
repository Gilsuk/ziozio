package ziozio.dao.impl;

import ziozio.dao.face.MyPageDAO;

public class MyPageDAOImpl implements MyPageDAO {

    private MyPageDAOImpl() { } 
    private static class Factory {
        public static final MyPageDAO INSTANCE = new MyPageDAOImpl();
    }
    public static MyPageDAO getInstance() { return Factory.INSTANCE; }
}
