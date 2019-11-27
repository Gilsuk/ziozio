package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.SelectResultException;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.utils.param.exception.InvalidParamException;

public interface LoginService {
	void login(HttpServletRequest req) throws InvalidParamException, AccountNotVerifiedException, SelectResultException;
}
