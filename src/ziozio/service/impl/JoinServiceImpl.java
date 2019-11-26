package ziozio.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.JoinDAO;
import ziozio.dao.impl.JoinDAOImpl;
import ziozio.dto.AccountIncludeAuthInfo;
import ziozio.service.face.JoinService;
import ziozio.utils.paramparser.InvalidParamException;
import ziozio.utils.paramparser.ParamCaster;

public class JoinServiceImpl implements JoinService {
	
	private JoinDAO joinDao = JoinDAOImpl.getInstance();
	
	private JoinServiceImpl() { }
    private static class Factory {
        public static final JoinService INSTANCE = new JoinServiceImpl();
    }
    public static JoinService getInstance() { return Factory.INSTANCE; }

	@Override
	public void join(HttpServletRequest req) throws InvalidParamException, SQLException {
		AccountIncludeAuthInfo account = getAccountIncludeAuthInfoFromParams(req);
		joinDao.insert(account);
	}

	private AccountIncludeAuthInfo getAccountIncludeAuthInfoFromParams(
			HttpServletRequest req) throws InvalidParamException {
		
		AccountIncludeAuthInfo account = new AccountIncludeAuthInfo();
		
		account.setAccount_email(req.getParameter("account_email"));
		account.setAccount_gender(ParamCaster.toChar(req.getParameter("account_gender")));
		account.setAccount_nick(req.getParameter("account_nick"));
		account.setAccount_pw(req.getParameter("account_pw"));

		return account;
		
	}

}
