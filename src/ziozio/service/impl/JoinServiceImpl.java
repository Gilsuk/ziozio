package ziozio.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.service.exception.AccountDuplicateException;
import ziozio.service.face.JoinService;
import ziozio.service.face.VerificationService;
import ziozio.utils.param.ParamCaster;
import ziozio.utils.param.exception.InvalidParamException;

public class JoinServiceImpl implements JoinService {
	
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	private VerificationService verificationService = VerificationServiceImpl.getInstance();
	
	private JoinServiceImpl() { }
    private static class Factory {
        public static final JoinService INSTANCE = new JoinServiceImpl();
    }
    public static JoinService getInstance() { return Factory.INSTANCE; }

	@Override
	public void join(HttpServletRequest req) throws InvalidParamException, AccountDuplicateException {
		AccountWithPw account = getAccountWithPwFromParams(req);

		try {
			accountDao.insert(account);
		} catch (SQLException e) { throw new AccountDuplicateException(); }

		try {
			Account select = accountDao.select(account);
			verificationService.generateKey(select);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
