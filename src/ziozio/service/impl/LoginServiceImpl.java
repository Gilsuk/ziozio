package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.service.face.CookieService;
import ziozio.service.face.LoginService;
import ziozio.utils.param.exception.InvalidParamException;

public class LoginServiceImpl implements LoginService {

	/*
	 * Fields
	 */
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	private CookieService cookieService = CookieServiceImpl.getInstance();

	/*
	 * Singleton Constructor
	 */
    private LoginServiceImpl() { }
    private static class Factory {
        public static final LoginService INSTANCE = new LoginServiceImpl();
    }
    public static LoginService getInstance() { return Factory.INSTANCE; }

    /*
     * implements
     */


	@Override
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws InvalidParamException, AccountNotVerifiedException, SelectResultException {
		AccountWithPw accountWithPw = getAccountWithPwFromParams(req);
		Account account = accountDao.select(accountWithPw);
		
		if (!account.isAccount_verified()) throw new AccountNotVerifiedException();
		
		if (getShouldKeepLoginState(req)) cookieService.setNewCookie(req, resp, account); 
			
		req.getSession().setAttribute("account", account);
	}



	private AccountWithPw getAccountWithPwFromParams(
			HttpServletRequest req) throws InvalidParamException {
		
		AccountWithPw account = new AccountWithPw();
		
		account.setAccount_email(req.getParameter("account_email"));
		account.setAccount_pw(req.getParameter("account_pw"));

		return account;
		
	}

	private boolean getShouldKeepLoginState(HttpServletRequest req) {
		String shouldKeepLogin = req.getParameter("keep_login");
		if (shouldKeepLogin == null || shouldKeepLogin.equals("")) return false;
		return true;
	}


}
