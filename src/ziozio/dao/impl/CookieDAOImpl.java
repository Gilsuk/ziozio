package ziozio.dao.impl;

import ziozio.dao.face.CookieDAO;

public class CookieDAOImpl implements CookieDAO {


    private CookieDAOImpl() {
    }
 
    private static class Factory {
        public static final CookieDAO INSTANCE = new CookieDAOImpl();
    }
 
    public static CookieDAO getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public void insertCookieId() {
	}
}
