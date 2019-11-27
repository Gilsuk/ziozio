package ziozio.service.face;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.utils.param.exception.InvalidParamException;

public interface DuplicateCheckService {

	boolean isDuplicated(HttpServletRequest req) throws InvalidParamException;

	void sendErrorMessage(HttpServletResponse resp) throws IOException;

	void sendOkMessage(HttpServletResponse resp) throws IOException;

}
