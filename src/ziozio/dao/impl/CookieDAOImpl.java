package ziozio.dao.impl;

import ziozio.dao.face.CookieDAO;
import ziozio.dto.Account;

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

	@Override
	public void insertUser(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectUsernoByCID(String parameter) {
		return 0;
	}
}
