package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.State;

public interface StateService {

	State getState(HttpServletRequest req);

}
