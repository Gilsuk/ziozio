package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.Dao;
import ziozio.dao.face.StyleClothDAO;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class StyleClothDAOImpl implements StyleClothDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/*
	 * Singleton
	 */
	private StyleClothDAOImpl() { }
    private static class Factory {
        public static final StyleClothDAO INSTANCE = new StyleClothDAOImpl();
    }
    public static StyleClothDAO getInstance() { return Factory.INSTANCE; }
	
//	public static void main(String[] args) {
//		StyleClothDAOImpl dao = new StyleClothDAOImpl();
//		
//		Style style = new Style();
//		style.setStyle_code(2);
//		style.setStyle_name("캐쥬얼");
//		
//		List<Cloth> list = dao.selectAll(style);
//		
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(Style style) {
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	S.style_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_code";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_gender";
		sql += "	, C.cloth_img";
		sql += "	FROM cloth_style CST";
		sql += "	, cloth C";
		sql += "	, style S";
		sql += "	WHERE  CST.cloth_code";
		sql += "	=  C.cloth_code";
		sql += "	AND S.style_code";
		sql += "	= CST.style_code";
		sql += "	AND S.style_name";
		sql += "	= ?";
		sql += "	ORDER BY C.cloth_name";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, style.getStyle_name());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth stylecloth = new Cloth();
								
				stylecloth.setCloth_name(rs.getString("cloth_name"));								
				stylecloth.setCloth_code(rs.getInt("cloth_code"));								
				stylecloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				stylecloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				stylecloth.setCloth_img(rs.getString("cloth_img"));

				list.add(stylecloth);
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
//		StyleClothDAOImpl styleDao = new StyleClothDAOImpl();
//		Style style = new Style();
//		style.setStyle_name("캐쥬얼");
//		List<Cloth> selectAll = styleDao.selectAll(style, ClothCategory.TOP);
////		styleDao.selectAll(style, ClothCategory.BOTTOM);
//		
//		for (Cloth cloth : selectAll) {
//			
//			System.out.println(cloth);
//			
//		}
//
//	}
	
	@Override
	public List<Cloth> selectAll(Style style, ClothCategory category) {
		
		//TEST까지 완료했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	s.style_name";
		sql += "	, clc.cloth_category_name";
		sql += "	, c.cloth_name";
		sql += "	, c.cloth_code";
		sql += "	, c.cloth_link_url";
		sql += "	, c.cloth_gender";
		sql += "	, c.cloth_img";
		sql += "	FROM cloth_style CST";
		sql += "	, cloth C";
		sql += "	, style S";
		sql += "	, cloth_category CLC";
		sql += "	WHERE cst.cloth_code";
		sql += "	= c.cloth_code";
		sql += "	AND c.cloth_category_code";
		sql += "	= clc.cloth_category_code";
		sql += "	AND s.style_code";
		sql += "	= cst.style_code";
		sql += "	AND s.style_name";
		sql += "	= ?";
		sql += "	AND clc.cloth_category_name";
		sql += "	= ?";
		sql += "	ORDER BY s.style_name";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, style.getStyle_name());
			ps.setString(2, category.getDbValue());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				
				Cloth stylecloth = new Cloth();
								
				stylecloth.setCloth_name(rs.getString("cloth_name"));								
				stylecloth.setCloth_code(rs.getInt("cloth_code"));								
				stylecloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				stylecloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				stylecloth.setCloth_img(rs.getString("cloth_img"));

				list.add(stylecloth);
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
//		
//		StyleClothDAOImpl styleDao = new StyleClothDAOImpl();
//		
//		Style style = new Style();
//				
//		style.setStyle_name("캐쥬얼");
//		
//		int selectcntall = styleDao.selectCntAll(style);
//		
//		System.out.println(selectcntall);
//		
//	}

	@Override
	public int selectCntAll(Style style) {
		
		//TEST까지 했음

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM style WHERE style_name = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, style.getStyle_name());
			
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
//	
//	StyleClothDAOImpl styleDao = new StyleClothDAOImpl();
//	
//	Style style = new Style();
//			
//	style.setStyle_name("캐쥬얼");
//	
//	ClothCategory category = ClothCategory.TOP;
//	
//	int selectcntall = styleDao.selectCntAll(style, category);
//	
//	System.out.println(selectcntall);
//	
//}
	

	@Override
	public int selectCntAll(Style style, ClothCategory category) {
		
		//TEST 까지 했음
		
		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth_style CST";
		sql += " , cloth C";
		sql += " , cloth_category CLC";
		sql += " , style S";
		sql += " WHERE cst.cloth_code";
		sql += " = c.cloth_code";
		sql += " AND c.cloth_category_code";
		sql += " = clc.cloth_category_code";
		sql += " AND s.style_code";
		sql += " = cst.style_code";
		sql += " AND s.style_name = ?";
		sql += " AND clc.cloth_category_name = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, style.getStyle_name());
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
//	
//	StyleClothDAOImpl styleDao = new StyleClothDAOImpl();
//	
//	Style style = new Style();
//			
//	style.setStyle_name("댄디");
//	
//	Paging paging = new Paging(styleDao.selectCntAll(style));
//	
//	List<Cloth> selectcntall = styleDao.selectAll(style, paging);
//	
//	for (Cloth cloth : selectcntall) {
//		System.out.println(cloth);
//	}
//	
//}


	@Override
	public List<Cloth> selectAll(Style style, Paging paging) {
		
		//TEST까지 했음

		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* FROM (";
		sql += "SELECT";
		sql += "	S.style_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_code";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_gender";
		sql += "	, C.cloth_img";
		sql += "	FROM cloth_style CST, cloth C, style S";
		sql += "	WHERE CST.cloth_code =  C.cloth_code";
		sql += "	AND S.style_code = CST.style_code";
		sql += "	AND S.style_name = ?";
		sql += "	ORDER BY C.cloth_name";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) STYLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, style.getStyle_name());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				Cloth stylecloth = new Cloth();
				
				stylecloth.setCloth_name(rs.getString("cloth_name"));								
				stylecloth.setCloth_code(rs.getInt("cloth_code"));								
				stylecloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				stylecloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				stylecloth.setCloth_img(rs.getString("cloth_img"));

				list.add(stylecloth);
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
		
		return list;
	}

//	public static void main(String[] args) {
//	StyleClothDAOImpl styleDao = new StyleClothDAOImpl();
//	Style style = new Style();
//	style.setStyle_name("댄디");
//	
//	Paging paging = new Paging(styleDao.selectCntAll(style));
//	
//	
//	List<Cloth> selectAll = styleDao.selectAll(style, ClothCategory.OUTER, paging);
//
//	
//	for (Cloth cloth : selectAll) {
//		
//		System.out.println(cloth);
//		
//	}
//
//}
	
	@Override
	public List<Cloth> selectAll(Style style, ClothCategory category, Paging paging) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* FROM (";
		sql += "SELECT";
		sql += "	s.style_name";
		sql += "	, clc.cloth_category_name";
		sql += "	, c.cloth_name";
		sql += "	, c.cloth_code";
		sql += "	, c.cloth_link_url";
		sql += "	, c.cloth_gender";
		sql += "	, c.cloth_img";
		sql += "	FROM cloth_style CST";
		sql += "	, cloth C";
		sql += "	, style S";
		sql += "	, cloth_category CLC";
		sql += "	WHERE cst.cloth_code";
		sql += "	= c.cloth_code";
		sql += "	AND c.cloth_category_code";
		sql += "	= clc.cloth_category_code";
		sql += "	AND s.style_code";
		sql += "	= cst.style_code";
		sql += "	AND s.style_name";
		sql += "	= ?";
		sql += "	AND clc.cloth_category_name";
		sql += "	= ?";
		sql += "	ORDER BY s.style_name";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) STYLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
	
//		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, style.getStyle_name());
			ps.setString(2, category.getDbValue());
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				Cloth stylecloth = new Cloth();
				
				stylecloth.setCloth_name(rs.getString("cloth_name"));								
				stylecloth.setCloth_code(rs.getInt("cloth_code"));								
				stylecloth.setCloth_link_url(rs.getString("cloth_link_url"));								
				stylecloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
				stylecloth.setCloth_img(rs.getString("cloth_img"));

				list.add(stylecloth);
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
		
		return list;
	}


//	public static void main(String[] args) {
//		List<Style> list = new ArrayList<>();
//		Style style1 = new Style();
//		Style style2 = new Style();
//		Paging paging = new Paging(10);
//		style1.setStyle_name("캐쥬얼");
//		style2.setStyle_name("비즈니스");
//		list.add(style1);
//		list.add(style2);
//		
//		StyleClothDAO dao = new StyleClothDAOImpl();
//		List<Cloth> selectAll = dao.selectAll(list, ClothCategory.TOP, paging);
//		
//		for (Cloth cloth : selectAll) {
//			System.out.println(cloth);
//		}
//		
//	}

	@Override
	public List<Cloth> selectAll(List<Style> selector, ClothCategory category, Paging paging) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM (");
		sql.append(" SELECT C.cloth_name,");
		sql.append(" C.cloth_code, C.cloth_link_url, C.cloth_gender, C.cloth_img");
		sql.append(" FROM cloth_style CS");
		sql.append(" INNER JOIN cloth C ON CS.cloth_code = C.cloth_code");
		sql.append(" INNER JOIN style S ON S.style_code = CS.style_code");
		sql.append(" INNER JOIN cloth_category CC ON CC.cloth_category_code = C.cloth_category_code");
		sql.append(" WHERE S.style_name IN (");
		insertKeywordsIntoSql(sql, selector);
		sql.append(" )");
		sql.append(" AND CC.cloth_category_name = ?");
		sql.append(" ORDER BY DBMS_RANDOM.RANDOM");
		sql.append(" ) where rownum BETWEEN ? AND ?");

		return
		Dao.<Style, Cloth>selectList(sql.toString(), null, null, (t, u) -> {
			t.setString(1, category.getDbValue());
			t.setInt(2, paging.getStartNo());
			t.setInt(3, paging.getEndNo());
		}, this::getClothByResultSet);
	}
	
	private void insertKeywordsIntoSql(StringBuilder sql, List<Style> selector) {
		for (int i = 0; i < selector.size(); i++)
			if (i == 0) 
				sql.append("'").append(selector.get(0).getStyle_name()).append("'");
			else
				sql.append(",'").append(selector.get(i).getStyle_name()).append("'");
	}


	private Cloth getClothByResultSet(ResultSet rs) {
		Cloth cloth = new Cloth();

		try {
			cloth.setCloth_name(rs.getString("cloth_name"));								
			cloth.setCloth_code(rs.getInt("cloth_code"));								
			cloth.setCloth_link_url(rs.getString("cloth_link_url"));								
			cloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
			cloth.setCloth_img(rs.getString("cloth_img"));
		} catch (SQLException e) { e.printStackTrace(); }

		return cloth;
	}


	@Override
	public List<Cloth> selectAll(List<Style> selector, ClothCategory category) {
		return null;
	}

}
