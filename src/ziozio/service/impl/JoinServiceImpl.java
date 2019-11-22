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
	
		int nextval = joinDao.selectNextUserno();

		user.setUserno(nextval);
		
		joinDao.insertUser(user);
	
	}



	@Override
	public User getJoinParam(HttpServletRequest req) {

		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String username = req.getParameter("username");
		String usernick = req.getParameter("usernick");
		String userbirth = req.getParameter("userbirth");
		String userphone = req.getParameter("userphone");
		String useremail = req.getParameter("useremail");
		String usergender = req.getParameter("usergender");
		
		
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
