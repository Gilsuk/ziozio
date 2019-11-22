package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.User;

public interface JoinService {

	
	/**
	 * 회원가입
	 * @param user
	 */
	public void join(User user);
	
	
	/**
	 * 파라미터 얻기
	 * @param req
	 * @return
	 */
	public User getJoinParam(HttpServletRequest req);
	
}
