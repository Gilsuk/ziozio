package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.State;
import ziozio.service.face.StateService;

public class StateServiceImpl implements StateService {
	
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
		return null;
	}


}
