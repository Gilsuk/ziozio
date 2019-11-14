package ziozio.dao.face;

import ziozio.dto.User;

public interface CookieDAO {

	void insertCookieId();

	void insertUser(User user);

	int selectUsernoByCID(String parameter);

}
