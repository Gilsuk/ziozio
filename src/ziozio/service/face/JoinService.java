package ziozio.service.face;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.utils.paramparser.InvalidParamException;

public interface JoinService {

	public void join(HttpServletRequest req) throws InvalidParamException, SQLException;
	
}
