package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.exception.AccountNotFountException;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.utils.param.exception.InvalidParamException;

public interface LoginService {
	void login(HttpServletRequest req, HttpServletResponse resp) throws InvalidParamException, AccountNotVerifiedException, AccountNotFountException;

	boolean isLoggedIn(HttpServletRequest req);
}
