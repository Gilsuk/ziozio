package ziozio.dao.face;

import ziozio.dto.State;
import ziozio.dto.User;

public interface JoinDAO {

	String selectUserpwById(String id);

	User selectUserById(String id);

	State selectUserByUserno(int userno);

	
	public void insertUser(User user);

	
	public int selectNextUserno();
	
	
	public int emailCheck(String useremail);
	
	
	public int nickCheck(String usernick);
	
}
