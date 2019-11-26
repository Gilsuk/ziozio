package ziozio.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dao.face.LoginDAO;
import ziozio.dao.impl.LoginDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.service.face.LoginService;
import ziozio.utils.paramparser.InvalidParamException;
import ziozio.utils.paramparser.ParamCaster;

public class LoginServiceImpl implements LoginService {

	/*
	 * Fields
	 */
	private LoginDAO loginDao = LoginDAOImpl.getInstance();

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
	public void login(HttpServletRequest req) throws InvalidParamException, SQLException, TooManyResultException, NoResultException, AccountNotVerifiedException {
		AccountWithPw accountWithPw = getAccountWithPwFromParams(req);
		Account account = loginDao.select(accountWithPw);
		
		if (!account.isAccount_verified()) throw new AccountNotVerifiedException();
		
		req.getSession().setAttribute("account", account);
	}

	private AccountWithPw getAccountWithPwFromParams(
			HttpServletRequest req) throws InvalidParamException {
		
		AccountWithPw account = new AccountWithPw();
		
		account.setAccount_email(req.getParameter("account_email"));
		account.setAccount_gender(ParamCaster.toChar(req.getParameter("account_gender")));
		account.setAccount_nick(req.getParameter("account_nick"));
		account.setAccount_pw(req.getParameter("account_pw"));

		return account;
		
	}

}
