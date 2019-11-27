package ziozio.dao.face;

import ziozio.dto.Account;

public interface CookieDAO {

	void insertCookieId();

	void insertUser(Account account);

	int selectUsernoByCID(String parameter);

}
