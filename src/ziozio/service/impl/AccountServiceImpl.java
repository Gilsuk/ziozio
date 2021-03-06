package ziozio.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.AccountDAO;
import ziozio.dao.impl.AccountDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.exception.CookieNotFoundException;
import ziozio.service.exception.ParamNotAllowedException;
import ziozio.service.face.AccountService;
import ziozio.service.face.CookieService;
import ziozio.utils.hash.HashConverter;
import ziozio.utils.hash.SHA256;
import ziozio.utils.param.exception.InvalidEmailParamException;

public class AccountServiceImpl implements AccountService {

	/*
	 * Fields
	 */
	private AccountDAO accountDao = AccountDAOImpl.getInstance();
	private CookieService cookieServ = CookieServiceImpl.getInstance();
	
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

			try {
				cookieServ.restoreSessionAccount(req, null);
				return getLoggedInAccount(req);
			} catch (SelectResultException e1) {
				throw new AccountNotFountException();
			} catch (CookieNotFoundException e1) {
				throw new AccountNotFountException();
			}
			
		} catch (ClassCastException e) {
			// session attribute에 account라는 이름으로 다른 객체가 들어있는 경우
			// 발생하면 안되는 심각한 에러
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void loginAndRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		req.setAttribute("originurl", path);
		req.getRequestDispatcher("/account/login").forward(req, resp);
	}

	@Override
	public void verify(Account account) {
		accountDao.updateToVerify(account);
	}

	@Override
	public Account getAccountByEmail(Account account) throws SelectResultException {
		return accountDao.selectByEmail(account);
	}

	@Override
	public Account getAccountByEmail(String account_email) {
		Account account = new Account();
		try {
			account.setAccount_email(account_email);
		} catch (InvalidEmailParamException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void generateKey(Account account) throws SQLException {
		Verification veri = new Verification();
		veri.setAccount_no(account.getAccount_no());
		veri.setVerification_type('F');
		
		UUID uuid = UUID.randomUUID();
		HashConverter converter = new SHA256(uuid.toString());
		veri.setVerification_code(converter.toHash());

		accountDao.insert(veri);

	}

	@Override
	public Verification getVerificationFromParam(HttpServletRequest req) throws ParamNotAllowedException {
		try {
			int accno = Integer.parseInt(req.getParameter("account_no"));
			String code = req.getParameter("verification_code");
			Verification veri = new Verification();
			veri.setAccount_no(accno);
			veri.setVerification_code(code);
			return veri;
		} catch (Exception e) {
			throw new ParamNotAllowedException();
		}
	}

	@Override
	public boolean verify(Verification veri) {
		return accountDao.selectCount(veri);
	}

	@Override
	public AccountWithPw getAccountByPwNo(HttpServletRequest req) {
		String pw = req.getParameter("pw");
		int accno = Integer.parseInt(req.getParameter("account_no"));
		AccountWithPw account = new AccountWithPw();
		
		account.setAccount_no(accno);
		account.setAccount_pw(pw);
		return account;
	}

	@Override
	public void setpw(AccountWithPw account) {
		accountDao.updatePw(account);
	}
}
