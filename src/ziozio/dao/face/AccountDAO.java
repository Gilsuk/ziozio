package ziozio.dao.face;

import java.sql.SQLException;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Count;

public interface AccountDAO {
	void insert(AccountWithPw account) throws SQLException;
	Account select(AccountWithPw account) throws SelectResultException;
	Count selectCountByEmail(Account account);
	Count selectCountByNick(Account account);
}
