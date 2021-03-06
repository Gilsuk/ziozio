package ziozio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.AccountDAO;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
import ziozio.utils.param.exception.InvalidParamException;

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
	public Account select(AccountWithPw account) throws SelectResultException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM account");
		sql.append(" WHERE account_email = ? AND account_pw = ?");
		
		return
		Dao.<AccountWithPw, Account>select(sql.toString(), account, Account.class,
				this::completeStateFromAccountWithPw, this::getAccountFromResultSet);
	}
	
	private void completeStateFromAccountWithPw(PreparedStatement ps, AccountWithPw account) {
		try {
			ps.setString(1, account.getAccount_email());
			ps.setString(2, account.getAccount_pw());
		} catch (SQLException e) { e.printStackTrace(); }
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
		} catch (SQLException e) { e.printStackTrace();
		} catch (InvalidParamException e) { e.printStackTrace(); }
		
		return account;
	}

	@Override
	public Account select(Account account) throws SelectResultException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM account");
		sql.append(" WHERE account_no = ?");
		
		return
		Dao.<Account, Account>select(sql.toString(), account, Account.class,
				this::completeStateFromAccount, this::getAccountFromResultSet);
	}

	private void completeStateFromAccount(PreparedStatement ps, Account account) {
		try {
			ps.setInt(1, account.getAccount_no());
		} catch (SQLException e) { e.printStackTrace(); }
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
	public int selectCountByEmail(Account account) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM account");
		sql.append(" WHERE account_email = ?");
		
		return
		Dao.<Account>count(sql.toString(), account, (t, u) -> {
			t.setString(1, u.getAccount_email());
		});
	}

	@Override
	public int selectCountByNick(Account account) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM account");
		sql.append(" WHERE account_nick = ?");
		
		return
		Dao.<Account>count(sql.toString(), account, (t, u) -> {
			t.setString(1, u.getAccount_nick());
		});
	}

	@Override
	public void updateToVerify(Account account) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE account SET account_verified = 1");
		sql.append(" WHERE account_no = ?");
		
		try {
			Dao.<Account>update(sql.toString(), account, (t, u) -> {
				t.setInt(1, account.getAccount_no());
			});
		} catch (SQLException e) { e.printStackTrace(); }
	}

	@Override
	public Account selectByEmail(Account account) throws SelectResultException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT account_no FROM account");
		sql.append(" WHERE account_email = ?");
		
		return
		Dao.<Account>select(sql.toString(), account, (t, u) -> {
			t.setString(1, account.getAccount_email());
		}, this::getAccountnoFromResultSet);
	}
	
	private Account getAccountnoFromResultSet(ResultSet rs) {
		Account account = new Account();
		try {
			account.setAccount_no(rs.getInt("account_no"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;

	}

	@Override
	public void insert(Verification veri) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO verification (verification_type, account_no, verification_code)");
		sql.append(" VALUES (?, ?, ?)");
		
		try {
			Dao.<Verification>update(sql.toString(), veri, (t, u) -> {
				t.setString(1, String.valueOf(u.getVerification_type()));
				t.setInt(2, u.getAccount_no());
				t.setString(3, u.getVerification_code());
			});
		} catch (SQLException e) { throw e; }
	}

	@Override
	public boolean selectCount(Verification veri) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM verification");
		sql.append(" WHERE account_no = ?");
		sql.append(" AND verification_code = ?");


		int cnt = 
		Dao.<Verification>count(sql.toString(), veri, (t, u) -> {
			t.setInt(1, u.getAccount_no());
			t.setString(2, u.getVerification_code());
		});
		
		return cnt == 1 ? true : false;
	}

	@Override
	public void updatePw(AccountWithPw account) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE account SET account_pw = ?");
		sql.append(" WHERE account_no = ?");
		
		try {
			Dao.<AccountWithPw>update(sql.toString(), account, (t, u) -> {
				t.setString(1, u.getAccount_pw());
				t.setInt(2, u.getAccount_no());
			});
		} catch (SQLException e) { e.printStackTrace(); }
	}
}
