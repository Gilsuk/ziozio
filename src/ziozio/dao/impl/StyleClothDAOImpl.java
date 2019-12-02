package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.StyleClothDAO;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class StyleClothDAOImpl implements StyleClothDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
//	public static void main(String[] args) {
//		StyleClothDAOImpl dao = new StyleClothDAOImpl();
//		
//		Style style = new Style();
//		style.setStyle_code(1);
//		style.setStyle_name("댄디");
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
//		style.setStyle_name("댄디");
//		List<Cloth> selectAll = styleDao.selectAll(style, ClothCategory.OUTER);
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
		sql += "	style_name";
		sql += "	, cloth_category_name";
		sql += "	, cloth_name";
		sql += "	, cloth_link_url";
		sql += "	, cloth_gender";
		sql += "	, cloth_img";
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
//	ClothCategory category = ClothCategory.BOTTOM;
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


	@Override
	public List<Cloth> selectAll(Style style, Paging paging) {

conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* (";
		sql += "SELECT";
		sql += "	S.style_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_gender";
		sql += "	, C.cloth_img";
		sql += "	FROM cloth_style CST, cloth C, style S";
		sql += "	WHERE  CST.cloth_code =  C.cloth_code";
		sql += "	AND S.style_code = CST.style_code";
		sql += "	AND S.style_name = ?";
		sql += "	ORDER BY C.cloth_name";
		sql += "        ORDER BY qna_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) QNA";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List list = new ArrayList();
		
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
				QnA qna = new QnA();
				
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("account_nick") );
//				qna.setQna_content( rs.getString("qna_content") );
				qna.setQna_writtendate( rs.getDate("qna_writtendate") );
				
				list.add(qna);
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

}
