package ziozio.service.face;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.service.exception.AccountNotFountException;

public interface AccountService {

	Account getAccountByAccountno(Account account) throws AccountNotFountException;
	
	Account getLoggedInAccount(HttpServletRequest req) throws AccountNotFountException;

	void loginAndRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	void verify(Account account);

}
