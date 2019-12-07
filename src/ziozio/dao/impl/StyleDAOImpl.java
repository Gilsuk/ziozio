package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.Dao;
import ziozio.dao.face.StyleDAO;
import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.utils.db.oracle.DBConn;

public class StyleDAOImpl implements StyleDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/*
	 * Singleton
	 */
	private StyleDAOImpl() { }
    private static class Factory {
        public static final StyleDAO INSTANCE = new StyleDAOImpl();
    }
    public static StyleDAO getInstance() { return Factory.INSTANCE; }

//	public static void main(String[] args) {
//		StyleDAOImpl styleDao = new StyleDAOImpl();
//				
//		List<Style> list = styleDao.selectAll();
//		
//		for (Style style : list) {
//			
//			System.out.println(style);
//			
//		}
//	}

	@Override
	public List<Style> selectAll() {
		
		//TEST까지 완료했음
		
		/*
		 * 옷(Cloth)까지 조회 하실 필요는 없고
		 * style 테이블에서 style_name 까지만 가져오면 됩니다.
		 * 옷 조회는 ClothService에서 구현할거에요
		 */
		
//		conn = DBConn.getConnection(); // DB 연결
//
//		// 수행할 SQL
//		String sql = "";
//		sql += "SELECT";
//		sql += "	clst.style_code";
//		sql += "	, style_name";
//		sql += "	, clc.cloth_category_name";
//		sql += "	, cl.cloth_name";
//		sql += "	, color_name";
////		sql += " *";
//		sql += " FROM cloth_set Cls, color Col";
//		sql += "	, cloth_category Clc, cloth Cl, cloth_style clst";
//		sql += "	, style St";
//		sql += " WHERE cls.color_code = col.color_code";
//		sql += " AND cls.cloth_category_code = clc.cloth_category_code";
//		sql += " AND cls.cloth_code = cl.cloth_code";
//		sql += " AND cl.cloth_code = clst.cloth_code";
//		sql += " AND clst.style_code = st.style_code";
//		sql += " ORDER BY clc.cloth_category_name DESC";

		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	style_code";
		sql += "	,style_name";
		sql += "	FROM style";
		sql += "	ORDER BY style_code";
	
//		// 최종 결과를 저장할 List
		List<Style> list = new ArrayList<Style>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				Style style = new Style();

				style.setStyle_code(rs.getInt("style_code"));
				style.setStyle_name(rs.getString("style_name"));								

				list.add(style);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

//	public static void main(String[] args) {
//		StyleDAOImpl styleDao = new StyleDAOImpl();
//		
//		Account account = new Account();
//		account.setAccount_no(2);
//		
//		List<Style> list = styleDao.accountSelectAll(account);
//		
//		for (Style style : list) {
//			System.out.println(style);
//			
//		}
//	}
	
	@Override
	public List<Style> accountSelectAll(Account account) {
		
		//TEST까지 완료했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	ST.style_code";
		sql += "	, ST.style_name";
		sql += "	FROM style ST";
		sql += "	, account_style AST";
		sql += "	WHERE st.style_code";
		sql += "	= ast.style_code";
		sql += "	AND AST.account_no = ?";
		sql += "	ORDER BY ST.style_code";
	
//		// 최종 결과를 저장할 List
		List<Style> list = new ArrayList<Style>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				Style style = new Style();

				style.setStyle_code(rs.getInt("style_code"));
				style.setStyle_name(rs.getString("style_name"));								

				list.add(style);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

	@Override
	public int insert(Account account, List<Style> styles) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO account_style");
		sql.append(" (account_no, style_code)");
		sql.append(" VALUES (?, ?)");
		
		return
		Dao.<Style>massUpdate(sql.toString(), styles, (t, u) -> {
			t.setInt(1, account.getAccount_no());
			t.setInt(2, u.getStyle_code());
		});
	}

	@Override
	public List<Style> selectAll(List<Style> styles) {
		
		if (styles == null || styles.size() == 0)
			return new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM style");
		sql.append(" WHERE style_name IN (");
		for (int i = 0; i < styles.size(); i++)
			if (i == 0)
				sql.append("'").append(styles.get(i).getStyle_name()).append("'");
			else
				sql.append(",'").append(styles.get(i).getStyle_name()).append("'");
		sql.append(")");
		
		return
		Dao.<Style>selectList(sql.toString(), null, null, this::getStyleFromResultSet);
	}
	
	private Style getStyleFromResultSet(ResultSet rs) {
		Style style = new Style();
		
		try {
			style.setStyle_code(rs.getInt("style_code"));
			style.setStyle_name(rs.getString("style_name"));
		} catch (SQLException e) { e.printStackTrace(); }
		
		return style;
		
	}


}
