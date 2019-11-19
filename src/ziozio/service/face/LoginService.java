package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.User;

public interface LoginService {

	/**
	 * 요청 파라미터 얻기
	 * @param req
	 * @return
	 */
	public User getLoginParam(HttpServletRequest req);
	
	/**
	 * 로그인 수행
	 * @param user
	 * @return - 성공/실패
	 */
	boolean login(User user);

	/**
	 * 유저의 아이디 구하기
	 * @param user
	 * @return
	 */
	public User getUserByUserid(User user);
	
}
