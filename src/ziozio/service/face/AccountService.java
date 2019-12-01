package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;

public interface AccountService {

	Account getAccountByAccountno(Account account);
	
	Account getLoggedInAccount(HttpServletRequest req);
}
