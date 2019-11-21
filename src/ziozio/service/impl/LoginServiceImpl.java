package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;


import ziozio.dao.face.LoginDAO;
import ziozio.dao.impl.LoginDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDao = new LoginDAOImpl();


	@Override
	public User getLoginParam(HttpServletRequest req) {
	
		//전달 파라미터 얻기
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		//전달 파라미터를 DTO(모델)에 담기
		User user = new User();
		user.setUserid(userid);
		user.setUserpw(userpw);
		
		//객체 반환		
		
		return user;
	}

	@Override
	public boolean login(User user) {

		int cnt = 0;
		cnt = loginDao.selectCntLoginByUserid(user);
		
		System.out.println("cnt : " + cnt);
		
		//존재하면 true반환
		//아니면 false반환
		if(cnt==1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getLoginByUserid(User user) {
		return loginDao.selectLoginByUserid(user);
	}
}


