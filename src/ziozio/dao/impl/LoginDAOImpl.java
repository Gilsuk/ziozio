package ziozio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dao.face.LoginDAO;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.utils.paramparser.InvalidEmailParamException;
import ziozio.utils.paramparser.InvalidGenderParamException;

public class LoginDAOImpl implements LoginDAO {

	/*
	 * Singleton Constructor
	 */
    private LoginDAOImpl() { }
    private static class Factory {
        public static final LoginDAO INSTANCE = new LoginDAOImpl();
    }
    public static LoginDAO getInstance() { return Factory.INSTANCE; }
    
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


}