package ziozio.dto;

public class State {
	
	private boolean authenticated;
	private User user;

	public State() {
		this.authenticated = false;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
