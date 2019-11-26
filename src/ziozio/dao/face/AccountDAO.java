package ziozio.dao.face;

import java.sql.SQLException;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Count;

public interface AccountDAO {
	void insert(AccountWithPw account) throws SQLException;
	Account select(AccountWithPw account) throws SQLException, TooManyResultException, NoResultException;
	Count selectCountByEmail(Account account);
	Count selectCountByNick(Account account);
}
