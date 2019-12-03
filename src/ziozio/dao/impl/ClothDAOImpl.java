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
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class ClothDAOImpl implements ClothDAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	//test
	
//	public static void main(String[] args) {
//		ClothDAOImpl dao = new ClothDAOImpl();
//		
//		Account account = new Account();
//		account.setAccount_no(1);
//		List<ClothWithColor> list = dao.selectAll(account, ClothCategory.TOP);
//		
//		System.out.println(ClothCategory.TOP.getDbValue());
//		System.out.println(ClothCategory.BOTTOM.getDbValue());
//		System.out.println(ClothCategory.OUTER.getDbValue());
//		for (ClothWithColor clothWithColor : list) {
//			System.out.println(clothWithColor);
//		}
//	}
	
	@Override
	public List<ClothWithColor> selectAll(Account account) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	C.cloth_code";
		sql += "	, G.cloth_category_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, C.cloth_gender";
		sql += "	, R.color_name";
		sql += "	, R.color_hue_rotate";
		sql += "	, R.color_saturate";
		sql += "	, R.color_brightness";
		sql += " FROM account_library A, cloth C, color R, cloth_category G";
		sql += " WHERE  A.cloth_code = C.cloth_code AND A.color_code = R.color_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code AND A.account_no = ?";
		sql += " ORDER BY A.account_no DESC";

		// 최종 결과를 저장할 List
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, account.getAccount_no());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				ClothWithColor cloth = new ClothWithColor();

				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_category_name(rs.getString("cloth_category_name"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setCloth_gender((rs.getString("cloth_gender").charAt(0)));
				cloth.setColor_name(rs.getString("color_name"));
				cloth.setColor_hue_rotate(rs.getInt("color_hue_rotate"));
				cloth.setColor_saturate(rs.getDouble("color_saturate"));
				cloth.setColor_brightness(rs.getDouble("color_brightness"));

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
	public List<ClothWithColor> selectAll(Account account, ClothCategory category) {
		
		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	G.cloth_category_name";
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
		sql += " AND A.account_no = ? AND G.cloth_category_name = ?";
		sql += " ORDER BY A.account_no DESC";		
		
		// 최종 결과를 저장할 List
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setString(2, category.getDbValue());

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				ClothWithColor cloth = new ClothWithColor();

				cloth.setCloth_category_name(rs.getString("cloth_category_name"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setColor_name(rs.getString("color_name"));
				cloth.setColor_hue_rotate(rs.getInt("color_hue_rotate"));
				cloth.setColor_saturate(rs.getDouble("color_saturate"));
				cloth.setColor_brightness(rs.getDouble("color_brightness"));

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

	
	//test
	
//	public static void main(String[] args) {
//		ClothDAOImpl dao = new ClothDAOImpl();
//		
//		Account account = new Account();
//		account.setAccount_no(1);
//		Paging paging = new Paging(dao.selectCntAll(account));
//		List<ClothWithColor> list = dao.selectAll(account, paging);
//
//		for (ClothWithColor clothWithColor : list) {
//			System.out.println(clothWithColor);
//		}
//	}	
	
	
	@Override
	public List<ClothWithColor> selectAll(Account account, Paging paging) {
		
		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "		G.cloth_category_name";
		sql += "		, C.cloth_code";
		sql += "		, C.cloth_name";
		sql += "		, C.cloth_link_url";
		sql += "		, C.cloth_img";
		sql += "		, C.cloth_gender";
		sql += "		, R.color_name";
		sql += "		, R.color_hue_rotate";
		sql += "		, R.color_saturate";
		sql += "		, R.color_brightness";
		sql += " 		FROM account_library A, cloth C, color R, cloth_category G";
		sql += " 		WHERE  A.cloth_code = C.cloth_code AND A.color_code = R.color_code";
		sql += "  		AND C.cloth_category_code = G.cloth_category_code AND A.account_no = ?";
		sql += " 		ORDER BY A.account_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) CLOTH";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();		
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				ClothWithColor cloth = new ClothWithColor();
				
				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_category_name(rs.getString("cloth_category_name"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setCloth_gender((rs.getString("cloth_gender").charAt(0)));
				cloth.setColor_name(rs.getString("color_name"));
				cloth.setColor_hue_rotate(rs.getInt("color_hue_rotate"));
				cloth.setColor_saturate(rs.getDouble("color_saturate"));
				cloth.setColor_brightness(rs.getDouble("color_brightness"));
				
				list.add(cloth);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//최종 결과 반환
		return list;
	}

	@Override
	public List<ClothWithColor> selectAll(Account account, ClothCategory category, Paging paging) {
		conn = DBConn.getConnection(); // DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "		G.cloth_category_name";
		sql += "		, C.cloth_name";
		sql += "		, C.cloth_link_url";
		sql += "		, C.cloth_img";
		sql += "		, R.color_name";
		sql += "		, R.color_hue_rotate";
		sql += "		, R.color_saturate";
		sql += "		, R.color_brightness";
		sql += " 		FROM account_library A, cloth C, color R, cloth_category G";
		sql += " 		WHERE A.cloth_code = C.cloth_code AND A.color_code = R.color_code";
		sql += " 		AND C.cloth_category_code = G.cloth_category_code";
		sql += " 		AND A.account_no = ? AND G.cloth_category_name = ?";
		sql += " 		ORDER BY A.account_no DESC";	
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) CLOTH";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List<ClothWithColor> list = new ArrayList<ClothWithColor>();		
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setString(2, category.getDbValue());
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				ClothWithColor cloth = new ClothWithColor();
				

				cloth.setCloth_category_name(rs.getString("cloth_category_name"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setColor_name(rs.getString("color_name"));
				cloth.setColor_hue_rotate(rs.getInt("color_hue_rotate"));
				cloth.setColor_saturate(rs.getDouble("color_saturate"));
				cloth.setColor_brightness(rs.getDouble("color_brightness"));
				
				list.add(cloth);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//최종 결과 반환
		return list;
	}


	@Override
	public int selectCntAll(Account account) {
	
		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM account_library WHERE account_no = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}


	
	@Override
	public int selectCntAll(Account account, ClothCategory category) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM account_library A , cloth C , cloth_category G ";
		sql += " WHERE A.cloth_code = C.cloth_code AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND A.account_no = ? AND G.cloth_category_name = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setString(2, category.getDbValue());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}

	//test
	
//	public static void main(String[] args) {
//		ClothDAOImpl dao = new ClothDAOImpl();
//		
//		Account account = new Account();
//		account.setAccount_no(1);
//		ClothWithColor cloth = new ClothWithColor();
//		cloth.setCloth_code(1);
//		cloth.setColor_code(1);
//		
//		dao.addToLibrary(account, cloth);
//	}	
	
// 	중복 SQLException 해야됨!!!
	@Override
	public void addToLibrary(Account account, ClothWithColor cloth) {

		conn = DBConn.getConnection(); // DB 연결		
		
		String sql = "";
		sql += "INSERT INTO account_library (account_no, cloth_code, color_code)";
		sql += " VALUES (?, ?, ?)";
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setInt(2, cloth.getCloth_code());
			ps.setInt(3, cloth.getColor_code());
			
			//SQL 수행 및 결과 저장
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

	//test
	
//	public static void main(String[] args) {
//		ClothDAOImpl dao = new ClothDAOImpl();
//		
//		Account account = new Account();
//		account.setAccount_no(3);
//		ClothWithColor cloth = new ClothWithColor();
//		cloth.setCloth_code(1);
//		cloth.setColor_code(1);
//		
//		dao.removeFromLibrary(account, cloth);
//	}
	
	@Override
	public void removeFromLibrary(Account account, ClothWithColor cloth) {

		conn = DBConn.getConnection(); // DB 연결		
		
		String sql = "";
		sql += "DELETE account_library";
		sql += " WHERE  account_no = ? AND cloth_code = ? AND color_code = ?";

		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setInt(2, cloth.getCloth_code());
			ps.setInt(3, cloth.getColor_code());
			
			//SQL 수행 및 결과 저장
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
