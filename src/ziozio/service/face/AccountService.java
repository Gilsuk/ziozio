package ziozio.service.face;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
import ziozio.service.exception.AccountNotFountException;

public interface AccountService {

	Account getAccountByAccountno(Account account) throws AccountNotFountException;
	
	Account getLoggedInAccount(HttpServletRequest req) throws AccountNotFountException;

	void loginAndRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	void verify(Account account);

	Account getAccountByEmail(Account account) throws SelectResultException;

	Account getAccountByEmail(String account_email);

	void generateKey(Account account) throws SQLException;

	Verification getVerificationFromParam(HttpServletRequest req);

	boolean verify(Verification veri);

	AccountWithPw getAccountByPwNo(HttpServletRequest req);

	void setpw(AccountWithPw account);

}
