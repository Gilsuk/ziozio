package ziozio.dao.face;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.dto.Cookie;

public interface CookieDAO {
	Account selectUserByCookie(Cookie cookie) throws SelectResultException;

	int renewLastLoginDate(Cookie cookie);
}
