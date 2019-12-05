package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;

public class AccountServiceImpl implements AccountService {

	/*
	 * Fields
	 */
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	
	/*
	 * Singleton
	 */
    private AccountServiceImpl() { }
    private static class Factory {
        public static final AccountService INSTANCE = new AccountServiceImpl();
    }
    public static AccountService getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public Account getAccountByAccountno(Account account) throws AccountNotFountException {
		try {
			return accountDao.select(account);
		} catch (SelectResultException e) {
			throw new AccountNotFountException();
		}
	}

	@Override
	public Account getLoggedInAccount(HttpServletRequest req) throws AccountNotFountException {
		
		try {
			Object account = req.getSession().getAttribute("account");
			if (account == null) throw new NullPointerException();
			return (Account) account;
		} catch (NullPointerException e) {
			throw new AccountNotFountException();
		} catch (ClassCastException e) {
			// session attribute에 account라는 이름으로 다른 객체가 들어있는 경우
			// 발생하면 안되는 심각한 에러
			e.printStackTrace();
			return null;
		}
	}



}
