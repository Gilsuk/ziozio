package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.GenderClothDAO;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class GenderClothDAOImpl implements GenderClothDAO{
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
//	public static void main(String[] args) {
//	GenderClothDAOImpl dao = new GenderClothDAOImpl();
//	
//	
//	char gender = 'N';
//	
//	List<Cloth> list = dao.selectAll(gender);
//	
//	for (Cloth cloth : list) {
//		System.out.println(cloth);
//	}
//}
	
	@Override
	public List<Cloth> selectAll(Character gender) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	cloth_name";
		sql += "	, cloth_code";
		sql += "	, cloth_link_url";
		sql += "	, cloth_gender";
		sql += "	, cloth_img";
		sql += "	FROM cloth";
		sql += "	WHERE cloth_gender";
		sql += "	= ?";
		sql += "	ORDER BY cloth_code";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, gender.toString());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth gendercloth = new Cloth();
								
				gendercloth.setCloth_name(rs.getString("cloth_name"));								
				gendercloth.setCloth_code(rs.getInt("cloth_code"));								
				gendercloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				gendercloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				gendercloth.setCloth_img(rs.getString("cloth_img"));

				list.add(gendercloth);
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
//		GenderClothDAOImpl dao = new GenderClothDAOImpl();
//
//
//		char gender = 'M';
//
//		List<Cloth> list = dao.selectAll(gender, ClothCategory.TOP);
//
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(Character gender, ClothCategory category) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	clc.cloth_category_name";
		sql += "	, c.cloth_name";
		sql += "	, c.cloth_code";
		sql += "	, c.cloth_link_url";
		sql += "	, c.cloth_gender";
		sql += "	, c.cloth_img";
		sql += "	FROM cloth C";
		sql += "	, cloth_category CLC";
		sql += "	WHERE c.cloth_category_code";
		sql += "	= clc.cloth_category_code";
		sql += "	AND c.cloth_gender";
		sql += "	= ?";
		sql += "	AND clc.cloth_category_name";
		sql += "	= ?";
		sql += "	ORDER BY cloth_code";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, gender.toString());
			ps.setString(2, category.getDbValue());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth gendercloth = new Cloth();
								
				gendercloth.setCloth_name(rs.getString("cloth_name"));								
				gendercloth.setCloth_code(rs.getInt("cloth_code"));								
				gendercloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				gendercloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				gendercloth.setCloth_img(rs.getString("cloth_img"));

				list.add(gendercloth);
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
//	GenderClothDAOImpl dao = new GenderClothDAOImpl();
//	
//	
//	char gender = 'F';	
//	
//	int selectcntall = dao.selectCntAll(gender);
//	
//	System.out.println(selectcntall);
//	
//}

	@Override
	public int selectCntAll(Character gender) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth WHERE cloth_gender = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, gender.toString());
			
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

	
//	public static void main(String[] args) {
//	GenderClothDAOImpl dao = new GenderClothDAOImpl();
//	
//	
//	char gender = 'N';	
//	
//	int selectcntall = dao.selectCntAll(gender, ClothCategory.OUTER);
//	
//	System.out.println(selectcntall);
//	
//}

	@Override
	public int selectCntAll(Character gender, ClothCategory category) {
		
		//TEST까지 했음

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth C";
		sql += " , cloth_category CLC";
		sql += " WHERE c.cloth_category_code = clc.cloth_category_code";
		sql += " AND c.cloth_gender = ?";
		sql += " AND clc.cloth_category_name = ?";
		

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, gender.toString());
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

	
//	public static void main(String[] args) {
//	GenderClothDAOImpl dao = new GenderClothDAOImpl();
//	
//	
//	char gender = 'F';
//	
//	Paging paging = new Paging(dao.selectCntAll(gender));
//	
//	List<Cloth> list = dao.selectAll(gender, paging);
//	
//	for (Cloth cloth : list) {
//		System.out.println(cloth);
//	}
//}

	@Override
	public List<Cloth> selectAll(Character gender, Paging paging) {
		
		//TEST까지 했음

		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* FROM (";
		sql += "SELECT";
		sql += "	cloth_name";
		sql += "	, cloth_code";
		sql += "	, cloth_link_url";
		sql += "	, cloth_gender";
		sql += "	, cloth_img";
		sql += "	FROM cloth";
		sql += "	WHERE cloth_gender = ?";
		sql += "	ORDER BY cloth_code";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) STYLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, gender.toString());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth gendercloth = new Cloth();
								
				gendercloth.setCloth_name(rs.getString("cloth_name"));								
				gendercloth.setCloth_code(rs.getInt("cloth_code"));								
				gendercloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				gendercloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				gendercloth.setCloth_img(rs.getString("cloth_img"));

				list.add(gendercloth);
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
//	GenderClothDAOImpl dao = new GenderClothDAOImpl();
//	
//	
//	char gender = 'N';
//	
//	Paging paging = new Paging(dao.selectCntAll(gender));
//	
//	List<Cloth> list = dao.selectAll(gender, ClothCategory.OUTER, paging);
//	
//	for (Cloth cloth : list) {
//		System.out.println(cloth);
//	}
//}

	@Override
	public List<Cloth> selectAll(Character gender, ClothCategory category, Paging paging) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* FROM (";
		sql += "SELECT";
		sql += "	clc.cloth_category_name";
		sql += "	, c.cloth_name";
		sql += "	, c.cloth_code";
		sql += "	, c.cloth_link_url";
		sql += "	, c.cloth_gender";
		sql += "	, c.cloth_img";
		sql += "	FROM cloth C";
		sql += "	, cloth_category CLC";
		sql += "	WHERE c.cloth_category_code = clc.cloth_category_code";
		sql += "	AND c.cloth_gender = ?";
		sql += "	AND clc.cloth_category_name = ?";
		sql += "	ORDER BY cloth_code";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) STYLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, gender.toString());
			ps.setString(2, category.getDbValue());
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth gendercloth = new Cloth();
								
				gendercloth.setCloth_name(rs.getString("cloth_name"));								
				gendercloth.setCloth_code(rs.getInt("cloth_code"));								
				gendercloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				gendercloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				gendercloth.setCloth_img(rs.getString("cloth_img"));

				list.add(gendercloth);
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
