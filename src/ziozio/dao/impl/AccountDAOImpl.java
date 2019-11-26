package ziozio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dao.face.AccountDAO;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Count;
import ziozio.utils.paramparser.InvalidEmailParamException;
import ziozio.utils.paramparser.InvalidGenderParamException;

public class AccountDAOImpl implements AccountDAO {
	
	/*
	 * Singleton
	 */
	private AccountDAOImpl() { }
    private static class Factory {
        public static final AccountDAO INSTANCE = new AccountDAOImpl();
    }
    public static AccountDAO getInstance() { return Factory.INSTANCE; }
    
	/*
     * implements
     */
	@Override
	public Account select(AccountWithPw account) throws SQLException, TooManyResultException, NoResultException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM account");
		sql.append(" WHERE account_email = ? AND account_pw = ?");
		
		return
		Dao.<AccountWithPw, Account>select(sql.toString(), account, Account.class, (t, u) -> {
			t.setString(1, u.getAccount_email());
			t.setString(2, u.getAccount_pw());
		},this::getAccountFromResultSet);

	}
	
	private Account getAccountFromResultSet(ResultSet rs) {
		Account account = new Account();
		
		try {
			account.setAccount_email(rs.getString("account_email"));
			account.setAccount_gender(rs.getString("account_gender").charAt(0));
			account.setAccount_grade_code(rs.getInt("account_grade_code"));
			account.setAccount_nick(rs.getString("account_nick"));
			account.setAccount_no(rs.getInt("account_no"));
			account.setAccount_signed_date(rs.getDate("account_signed_date"));
			account.setAccount_verified(rs.getBoolean("account_verified"));
		} catch (SQLException | InvalidGenderParamException | InvalidEmailParamException e) {
			e.printStackTrace();
		}
		
		return account;
	}

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

	@Override
	public Count selectCountByEmail(Account account) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM account");
		sql.append(" WHERE account_email = ?");
		
		try {
			return
			Dao.<Account, Count>select(sql.toString(), account, Count.class, (t, u) -> {
				t.setString(1, u.getAccount_email());
			},this::getCountFromResultSet);
		} catch (SQLException | TooManyResultException | NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Count getCountFromResultSet(ResultSet rs) {
		Count count = new Count();
		
		try { count.setCount(rs.getInt(1));
		} catch (SQLException e) { e.printStackTrace(); }

		return count;
	}

	@Override
	public Count selectCountByNick(Account account) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM account");
		sql.append(" WHERE account_nick = ?");
		
		try {
			return
			Dao.<Account, Count>select(sql.toString(), account, Count.class, (t, u) -> {
				t.setString(1, u.getAccount_nick());
			},this::getCountFromResultSet);
		} catch (SQLException | TooManyResultException | NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}
}
