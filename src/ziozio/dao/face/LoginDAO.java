package ziozio.dao.face;

import java.sql.SQLException;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;

public interface LoginDAO {

	Account select(AccountWithPw account) throws SQLException, TooManyResultException, NoResultException;

}
