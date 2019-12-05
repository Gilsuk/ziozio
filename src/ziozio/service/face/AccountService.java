package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.service.exception.AccountNotFountException;

public interface AccountService {

	Account getAccountByAccountno(Account account) throws AccountNotFountException;
	
	Account getLoggedInAccount(HttpServletRequest req) throws AccountNotFountException;
	

}
