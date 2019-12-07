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
import ziozio.service.exception.ParamNotAllowedException;

public interface AccountService {

	Account getAccountByAccountno(Account account) throws AccountNotFountException;
	Account getLoggedInAccount(HttpServletRequest req) throws AccountNotFountException;
	Account getAccountByEmail(Account account) throws SelectResultException;
	Account getAccountByEmail(String account_email);
	Verification getVerificationFromParam(HttpServletRequest req) throws ParamNotAllowedException;
	AccountWithPw getAccountByPwNo(HttpServletRequest req);
	boolean verify(Verification veri);
	void verify(Account account);
	void generateKey(Account account) throws SQLException;
	void loginAndRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	void setpw(AccountWithPw account);

}
