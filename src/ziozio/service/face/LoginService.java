package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

	boolean login(HttpServletRequest req, HttpServletResponse resp);

}
