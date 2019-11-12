package ziozio.dao.face;

import ziozio.dto.State;
import ziozio.dto.User;

public interface UserDAO {

	String selectUserpwById(String id);

	User selectUserById(String id);

	State selectUserByUserno(int userno);

}
