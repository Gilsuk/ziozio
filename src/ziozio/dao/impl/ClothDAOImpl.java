package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.ClothDAO;
import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class ClothDAOImpl implements ClothDAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	
	@Override
	public List<Cloth> selectAll() {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	account_no";
		sql += "	, cloth_code";
		sql += "	, color_code";
		sql += " FROM account_library";
		sql += " ORDER BY account_no DESC";

		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();		
		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Cloth cloth = new Cloth();

				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_category_code(rs.getInt("cloth_category_code"));
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
	public List<Cloth> selectAll(Account account, ClothCategory category, Paging paging) {
		conn = DBConn.getConnection(); // DB 연결
		return null;
	}

}
