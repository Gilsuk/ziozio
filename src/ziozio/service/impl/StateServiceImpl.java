package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.State;
import ziozio.service.face.StateService;

public class StateServiceImpl implements StateService {
	
	HttpServletRequest request;
	State state;

	public StateServiceImpl(HttpServletRequest req) {
		this.request = req;
		this.state = new State();
	}

	@Override
	public State getState() {
		return this.state;
	}

}
