package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.service.face.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public Account getAccountByAccountno(Account account) {
		return null;
	}

	@Override
	public Account getLoggedInAccount(HttpServletRequest req) {
		return null;
	}

}
