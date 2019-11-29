package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.CookieService;
import ziozio.service.face.LogoutService;

public class LogoutServiceImpl implements LogoutService {
	/*
	 * fields
	 */
	private CookieService cookieService = CookieServiceImpl.getInstance();

	/*
	 * Singleton
	 */
    private LogoutServiceImpl() { }
    private static class Factory {
        public static final LogoutService INSTANCE = new LogoutServiceImpl();
    }
    public static LogoutService getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		cookieService.removeLoginCookie(req, resp);
		req.getSession().removeAttribute("account");
	}
}
