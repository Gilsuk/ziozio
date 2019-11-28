package ziozio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.CookieDAO;
import ziozio.dto.Account;
import ziozio.dto.Cookie;
import ziozio.utils.param.exception.InvalidParamException;

public class CookieDAOImpl implements CookieDAO {

	/*
	 * Singleton
	 */
    private CookieDAOImpl() { }
    private static class Factory {
        public static final CookieDAO INSTANCE = new CookieDAOImpl();
    }
    public static CookieDAO getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public Account selectUserByCookie(Cookie cookie) throws SelectResultException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" A.account_no no, A.account_email email, A.account_nick nick,");
		sql.append(" A.account_gender gender, A.account_signed_date signed_date,");
		sql.append(" A.account_verified verified, A.account_grade_code grade_code");
		sql.append(" FROM cookie C");
		sql.append(" INNER JOIN account A ON A.account_no = C.account_no");
		sql.append(" WHERE cookie_id = ?");
		sql.append(" AND cookie_ip = ?");
		sql.append(" AND cookie_last_login >= sysdate - 30"); // 30일이 지나면 유효하지 않은 쿠키로 판단

		return
		Dao.<Cookie, Account>select(sql.toString(), cookie, Account.class,
				this::completeStateFromCookie, this::getAccountFromResultSet);
	}
	
	private void completeStateFromCookie(PreparedStatement ps, Cookie cookie) {
		try {
			ps.setString(1, cookie.getCookie_id());
			ps.setString(2, cookie.getCookie_ip());
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	private Account getAccountFromResultSet(ResultSet rs) {
		Account account = new Account();
		try {
			account.setAccount_email(rs.getString("email"));
			account.setAccount_gender(rs.getString("gender").charAt(0));
			account.setAccount_grade_code(rs.getInt("grade_code"));
			account.setAccount_nick(rs.getString("nick"));
			account.setAccount_no(rs.getInt("no"));
			account.setAccount_signed_date(rs.getDate("signed_date"));
			account.setAccount_verified(rs.getBoolean("verified"));
		} catch (SQLException | InvalidParamException e) { e.printStackTrace(); } 		

		return account;
	}

	@Override
	public int renewLastLoginDate(Cookie cookie) {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cookie");
		sql.append(" SET cookie_last_login = sysdate");
		sql.append(" WHERE cookie_id = ?");
		sql.append(" AND cookie_ip = ?");
		
		try {
			return
			Dao.<Cookie>update(sql.toString(), cookie, this::completeStateFromCookie);
		} catch (SQLException e) {e.printStackTrace(); return 0; }
	}
}
