package ziozio.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.service.face.DuplicateCheckService;

public class NickCheckService implements DuplicateCheckService {

	/*
	 * fields
	 */
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	
	/*
	 * Singleton
	 */
	private NickCheckService() { }
    private static class Factory {
        public static final DuplicateCheckService INSTANCE = new NickCheckService();
    }
    public static DuplicateCheckService getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public boolean isDuplicated(HttpServletRequest req) {
		Account account = getAccountByReqNickParam(req);
		int count = accountDao.selectCountByNick(account);

		if (count == 1) return true;
		return false;
	}

	private Account getAccountByReqNickParam(HttpServletRequest req) {
		Account account = new Account();
		account.setAccount_nick(req.getParameter("account_nick"));

		return account;
	}

	@Override
	public void sendErrorMessage(HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("이미 가입된 별명 입니다.");
	}

	@Override
	public void sendOkMessage(HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("사용할 수 있습니다.");
	}

}
