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

		
		String useremail = req.getParameter("useremail");
		String userpw = req.getParameter("userpw");
		String username = req.getParameter("username");
		String usernick = req.getParameter("usernick");
		String userbirth_year = req.getParameter("userbirth_year");
		String userbirth_mon = req.getParameter("userbirth_mon");
		String userbirth_day = req.getParameter("userbirth_day");
		String userphone = req.getParameter("userphone");
		String usergender = req.getParameter("usergender");
		
		
		
		User user = new User();
		
		user.setUseremail(useremail);
		user.setUserpw(userpw);
		user.setUsername(username);
		user.setUsernick(usernick);
		user.setUserbirth_year(userbirth_year);
		user.setUserbirth_mon(userbirth_mon);
		user.setUserbirth_day(userbirth_day);
		user.setUserphone(userphone);
		user.setUsergender(usergender);
		
		
		return user;
	}
	
	

}
