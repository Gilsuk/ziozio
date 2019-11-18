package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;


import ziozio.dao.face.JoinDAO;
import ziozio.dao.impl.JoinDAOImpl;
import ziozio.dto.User;
import ziozio.service.face.JoinService;

public class JoinServiceImpl implements JoinService {
	
	private JoinDAO joinDao = new JoinDAOImpl();

 
 
    private static class Factory {
        public static final JoinService INSTANCE = new JoinServiceImpl();
    }
 
    public static JoinService getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public void join(User user) {
	
		joinDao.insertUser(user);
	}



	@Override
	public User getInsertParam(HttpServletRequest req) {

		String userid = req.getParameter("userId");
		String userpw = req.getParameter("userPw");
		String username = req.getParameter("userName");
		String usernick = req.getParameter("userNick");
		String userbirth = req.getParameter("userBirth");
		String userphone = req.getParameter("userPhone");
		String useremail = req.getParameter("userEmail");
		String usergender = req.getParameter("userGender");
		
		
		User user = new User();
		user.setUserid(userid);
		user.setUserpw(userpw);
		user.setUsername(username);
		user.setUsernick(usernick);
		user.setUserbirth(userbirth);
		user.setUserphone(userphone);
		user.setUseremail(useremail);
		user.setUsergender(usergender);
		
		
		return user;
	}
	
	

}
