package ziozio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.VerificationDAO;
import ziozio.dto.Verification;

public class VerificationDAOImpl implements VerificationDAO {

	/*
	 * Singleton
	 */
    private VerificationDAOImpl() { }
    private static class Factory {
        public static final VerificationDAO INSTANCE = new VerificationDAOImpl();
    }
    public static VerificationDAO getInstance() { return Factory.INSTANCE; }

	@Override
	public Verification select(Verification veri) throws SelectResultException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM verification");
		sql.append(" WHERE account_no = ?");
		sql.append(" AND verification_type = ?");
		
		return
		Dao.<Verification>select(sql.toString(), veri, (t, u) -> {
			t.setInt(1, u.getAccount_no());
			t.setString(2, String.valueOf(u.getVerification_type()));
		}, this::getVerificationFromResultSet);
	}
	
	private Verification getVerificationFromResultSet(ResultSet rs) {
		Verification veri = new Verification();
		try {
			veri.setAccount_no(rs.getInt("account_no"));
			veri.setVerification_code(rs.getString("verification_code"));
			veri.setVerification_type(rs.getString("verification_type").charAt(1));
		} catch (SQLException e) { e.printStackTrace(); }
		
		return veri;
	}

}
