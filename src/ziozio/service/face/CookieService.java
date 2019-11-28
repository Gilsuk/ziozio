package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.service.exception.CookieNotFoundException;

public interface CookieService {

	void restoreSessionAccount(HttpServletRequest req, HttpServletResponse resp) throws CookieNotFoundException, SelectResultException;

	void setNewCookie(HttpServletRequest req, HttpServletResponse resp, Account account);

	void removeLoginCookie(HttpServletRequest req, HttpServletResponse resp);

}
