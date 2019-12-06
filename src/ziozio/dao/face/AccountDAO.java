package ziozio.dao.face;

import java.sql.SQLException;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;

public interface AccountDAO {
	void insert(AccountWithPw account) throws SQLException;
	Account select(AccountWithPw account) throws SelectResultException;
	Account select(Account account) throws SelectResultException;
	int selectCountByEmail(Account account);
	int selectCountByNick(Account account);
	void updateToVerify(Account account);
	Account selectByEmail(Account account) throws SelectResultException;
	void insert(Verification veri);

}
