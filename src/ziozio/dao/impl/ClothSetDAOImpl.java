package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.face.ClothSetDAO;
import ziozio.dto.Account;
import ziozio.dto.ClothSet;
import ziozio.utils.db.oracle.DBConn;

public class ClothSetDAOImpl implements ClothSetDAO{
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	
	/*
	 * Singleton
	 */
	private ClothSetDAOImpl() { }
    private static class Factory {
        public static final ClothSetDAO INSTANCE = new ClothSetDAOImpl();
    }
    public static ClothSetDAO getInstance() { return Factory.INSTANCE; }
	
	
	@Override
	public void insert(Account account, ClothSet set) {

		conn = DBConn.getConnection(); // DB 연결
		
		//수행할 SQL 쿼리
		String sql = "";
		sql += "INSERT INTO account_like ( account_no, cloth_set_no, cloth_category_code)";
		sql += " VALUES ( ?, ? )";
		
		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체
			
			// SQL쿼리의 ? 채우기
			ps.setInt(1, account.getAccount_no());
			ps.setInt(2, set.getClost_set_no());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
