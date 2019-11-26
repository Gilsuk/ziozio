package ziozio.dao.impl;

import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.face.JoinDAO;
import ziozio.dto.AccountWithPw;

public class JoinDAOImpl implements JoinDAO {

	private JoinDAOImpl() { }
    private static class Factory {
        public static final JoinDAO INSTANCE = new JoinDAOImpl();
    }
    public static JoinDAO getInstance() { return Factory.INSTANCE; }

	@Override
	public void insert(AccountWithPw account) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO account (");
		sql.append("account_email, account_pw, account_nick, account_gender)");
		sql.append(" VALUES (?, ?, ?, ?)");
 
		Dao.<AccountWithPw>update(sql.toString(), account, (t, u) -> {
				t.setString(1, u.getAccount_email());
				t.setString(2, u.getAccount_pw());
				t.setString(3, u.getAccount_nick());
				t.setString(4, String.valueOf(u.getAccount_gender()));
		});
	}

}
