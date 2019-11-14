package ziozio.dao.face;

import ziozio.dto.User;

public interface SessionDAO {

	boolean insertSessionId();

	void insertUser(User user);

	int selectUsernoBySID(String parameter);

}
