package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.service.exception.AccountDuplicateException;
import ziozio.utils.param.exception.InvalidParamException;

public interface JoinService {

	public void join(HttpServletRequest req) throws InvalidParamException, AccountDuplicateException;
	
}
