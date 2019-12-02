package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.StyleDAO;
import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.utils.db.oracle.DBConn;

public class StyleDAOImpl implements StyleDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Style> selectAll() {
		
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

	@Override
	public List<Style> accountSelectAll(Account account) {
		
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	style_code";
		sql += "	,style_name";
		sql += "	FROM style ST";
		sql += "	, account_style AST";
		sql += "	WHERE st.style_code";
		sql += "	= ast.style_code";
		sql += "	AND ast.account_no = ?";
		sql += "	ORDER BY style_code";
	
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


}
