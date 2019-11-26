package ziozio.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Count;
import ziozio.service.face.DuplicateCheckService;
import ziozio.utils.param.exception.InvalidEmailParamException;

public class EmailCheckService implements DuplicateCheckService {
	/*
	 * fields
	 */
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	
	/*
	 * Singleton
	 */
	private EmailCheckService() { }
    private static class Factory {
        public static final DuplicateCheckService INSTANCE = new EmailCheckService();
    }
    public static DuplicateCheckService getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public boolean isDuplicated(HttpServletRequest req) throws InvalidEmailParamException {
		Account account = getAccountByReqEmailParam(req);
		Count count = accountDao.selectCountByEmail(account);

		if (count.getCount() == 1) return true;
		return false;
	}

	private Account getAccountByReqEmailParam(HttpServletRequest req) throws InvalidEmailParamException {
		Account account = new Account();
		account.setAccount_email(req.getParameter("account_email"));

		return account;
	}

	@Override
	public void sendErrorMessage(HttpServletResponse resp) throws IOException {
		resp.getWriter().println("이미 가입된 이메일 입니다.");
	}
	@Override
	public void sendOkMessage(HttpServletResponse resp) throws IOException {
		resp.getWriter().println("가입할 수 있는 이메일 입니다.");
	}
}
