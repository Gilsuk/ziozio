package ziozio.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.CookieDAO;
import ziozio.dao.impl.CookieDAOImpl;
import ziozio.dto.Account;
import ziozio.service.exception.CookieNotFoundException;
import ziozio.service.face.CookieService;

public class CookieServiceImpl implements CookieService {
	
	/*
	 * fields
	 */
	private CookieDAO cookieDao = CookieDAOImpl.getInstance();
	
	/*
	 * Singleton
	 */
	private CookieServiceImpl() { }
    private static class Factory {
        public static final CookieService INSTANCE = new CookieServiceImpl();
    }
    public static CookieService getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public void restoreSessionAccount(HttpServletRequest req, HttpServletResponse resp)
			throws CookieNotFoundException, SelectResultException {
		
		// 클라이언트의 쿠키로부터 쿠키값을 얻어온다.
		// 클라이언트의 쿠키가 없으면 CookieNotFoundException을 던진다.
		String cookie_id = getCookieValue(req, "cookie_id");

		// 쿠키(dto)객체에 쿠키값과 클라이언트의 ip를 넣는다.
		// 이 두 정보는 cookie 테이블을 조회하는데 필요한 primary key이다.
		ziozio.dto.Cookie cookie = getCookieWithPrimaryKeys(req, cookie_id);
		
		// 클라이언트에서 얻은 정보와 서버의 DB를 매칭하여 유효성을 검증한다.
		// 유효한 쿠키라면 Account 객체가 반환되며, SelectResultException 에러를 던진다.
		Account account = cookieDao.selectUserByCookie(cookie);
		
		// 유효한 객체가 반환되면, DB의 마지막 접속 기록을 갱신한다.
		cookieDao.renewLastLoginDate(cookie);
		
		// 세션에 로그인 정보(Account)를 전달한다.
		req.getSession().setAttribute("account", account);
	}

	private ziozio.dto.Cookie getCookieWithPrimaryKeys(HttpServletRequest req, String cookie_id) {
		ziozio.dto.Cookie cookie = new ziozio.dto.Cookie();
		cookie.setCookie_id(cookie_id);
		cookie.setCookie_ip(req.getRemoteAddr());

		return cookie;
	}

	private String getCookieValue(HttpServletRequest req, String cookieName) throws CookieNotFoundException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies)
			if (cookie.getName().equals(cookieName))
				return cookie.getValue();

		throw new CookieNotFoundException();
	}

}
