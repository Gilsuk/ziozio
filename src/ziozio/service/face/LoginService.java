package ziozio.service.face;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.service.exception.AccountNotVerifiedException;
import ziozio.utils.paramparser.InvalidParamException;

public interface LoginService {
	void login(HttpServletRequest req) throws InvalidParamException, SQLException, TooManyResultException, NoResultException, AccountNotVerifiedException;
}
