package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.ClothDAO;
import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class ClothDAOImpl implements ClothDAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	
	@Override
	public List<ClothWithColor> selectAll(Account account) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	*";
		sql += " FROM account_library A, cloth C, color R, cloth_category G";
		sql += " WHERE  A.cloth_code = C.cloth_code AND A.color_code = R.color_code";
		sql += "  AND C.cloth_category_code = G.cloth_category_code";
		sql += " ORDER BY A.account_no DESC";

		// 최종 결과를 저장할 List
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				ClothWithColor cloth = new ClothWithColor();

				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_category_name(rs.getString("cloth_category_name"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
//				cloth.setCloth_gender(rs.getChar("cloth_gender"));


				list.add(cloth);
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

		// 최종 결과 반환
		return list;
	}

	@Override
	public List<ClothWithColor> selectAll(Account account, ClothCategory category, Paging paging) {
		conn = DBConn.getConnection(); // DB 연결
		return null;
	}

	@Override
	public List<ClothWithColor> selectAll(Account account, ClothCategory category) {
		
		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	A.account_no";
		sql += "	, G.cloth_category_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, R.color_name";
		sql += "	, R.color_hue_rotate";
		sql += "	, R.color_saturate";
		sql += "	, R.color_brightness";
		sql += " FROM account_library A, cloth C, color R, cloth_category G";
		sql += " WHERE A.cloth_code = C.cloth_code AND A.color_code = R.color_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND a.account_no = ? AND g.cloth_category_name = ?";
		sql += " ORDER BY account_no DESC";		
		
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();
					
			while (rs.next()) {
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<ClothWithColor> selectAll(Account account, Paging paging) {
		return null;
	}

}
