package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.CookieDAO;
import ziozio.dao.face.SessionDAO;
import ziozio.dao.face.JoinDAO;
import ziozio.dao.impl.CookieDAOImpl;
import ziozio.dao.impl.SessionDAOImpl;
import ziozio.dao.impl.JoinDAOImpl;
import ziozio.dto.State;
import ziozio.service.face.StateService;

public class StateServiceImpl implements StateService {
	
	private CookieDAO cDao = CookieDAOImpl.getInstance();
	private SessionDAO sDao = SessionDAOImpl.getInstance();
	private JoinDAO uDao = JoinDAOImpl.getInstance();
	
    private StateServiceImpl() {
    }
 
    private static class Factory {
        public static final StateService INSTANCE = new StateServiceImpl();
    }
 
    public static StateService getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public State getState(HttpServletRequest req) {
		State state = new State();
		int userno = -1;
		userno = cDao.selectUsernoByCID(req.getParameter("CID"));
		userno = userno > 0 ? userno : sDao.selectUsernoBySID(req.getParameter("SID"));

		if (userno < 0) return state;

		return uDao.selectUserByUserno(userno);
	}


}
