package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.TemperatureClothDAO;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class TemperatureClothDAOImpl implements TemperatureClothDAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/*
	 * Singleton
	 */
	private TemperatureClothDAOImpl() { }
    private static class Factory {
        public static final TemperatureClothDAO INSTANCE = new TemperatureClothDAOImpl();
    }
    public static TemperatureClothDAO getInstance() { return Factory.INSTANCE; }

	//test
//	public static void main(String[] args) {
//		TemperatureClothDAOImpl dao = new TemperatureClothDAOImpl();
//		WeatherInfo selector = new WeatherInfo();
//		selector.setTemperature_grade_code(1);
//		
//		List<Cloth> list = dao.selectAll(selector);
//		
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(WeatherInfo selector) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	C.cloth_code";
		sql += "	, T.temperature_grade_code";
		sql += "	, G.cloth_category_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, C.cloth_gender";
		sql += " FROM cloth_temperature_grade T, cloth C, cloth_category G";
		sql += " WHERE  T.cloth_code = C.cloth_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND T.temperature_grade_code = ?";
		
		List<Cloth> list = new ArrayList<Cloth>(); 
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, selector.getTemperature_grade_code());
			
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
//		TemperatureClothDAOImpl dao = new TemperatureClothDAOImpl();
//		
//		WeatherInfo selector = new WeatherInfo();
//	
//		selector.setTemperature_grade_code(1);
//		List<Cloth> list = dao.selectAll(selector,ClothCategory.TOP);
//	
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(WeatherInfo selector, ClothCategory category) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	C.cloth_code";
		sql += "	, G.cloth_category_name";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, C.cloth_gender";
		sql += " FROM cloth_temperature_grade T, cloth C, cloth_category G";
		sql += " WHERE  T.cloth_code = C.cloth_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND T.temperature_grade_code = ? AND G.cloth_category_name = ?";
		
		List<Cloth> list = new ArrayList<Cloth>(); 
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, selector.getTemperature_grade_code());
			ps.setString(2, category.getDbValue());
			
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
//		TemperatureClothDAOImpl dao = new TemperatureClothDAOImpl();
//		
//		WeatherInfo selector = new WeatherInfo();
//		selector.setTemperature_grade_code(1);
//		Paging paging = new Paging(dao.selectCntAll(selector));
//		List<Cloth> list = dao.selectAll(selector, paging);
//	
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(WeatherInfo selector, Paging paging) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "			C.cloth_code";
		sql += "			, G.cloth_category_name";
		sql += "			, C.cloth_name";
		sql += "			, C.cloth_link_url";
		sql += "			, C.cloth_img";
		sql += "			, C.cloth_gender";
		sql += " 		FROM cloth_temperature_grade T, cloth C, cloth_category G";
		sql += " 		WHERE  T.cloth_code = C.cloth_code";
		sql += " 		AND C.cloth_category_code = G.cloth_category_code";
		sql += " 		AND T.temperature_grade_code = ?";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) SELECTOR";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Cloth> list = new ArrayList<Cloth>(); 
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, selector.getTemperature_grade_code());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
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
	public List<Cloth> selectAll(WeatherInfo selector, ClothCategory category, Paging paging) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT ";
		sql += "			C.cloth_code";
		sql += "			, G.cloth_category_name";
		sql += "			, C.cloth_name";
		sql += "			, C.cloth_link_url";
		sql += "			, C.cloth_img";
		sql += "			, C.cloth_gender";
		sql += " 		FROM cloth_temperature_grade T, cloth C, cloth_category G";
		sql += "		 WHERE  T.cloth_code = C.cloth_code";
		sql += " 		AND C.cloth_category_code = G.cloth_category_code";
		sql += " 		AND T.temperature_grade_code = ? AND G.cloth_category_name = ?";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) SELECTOR";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Cloth> list = new ArrayList<Cloth>(); 
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setInt(1, selector.getTemperature_grade_code());
			ps.setString(2, category.getDbValue());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
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
	public int selectCntAll(WeatherInfo selector) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth_temperature_grade WHERE temperature_grade_code = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, selector.getTemperature_grade_code());
			
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
	public int selectCntAll(WeatherInfo selector, ClothCategory category) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth_temperature_grade T, cloth C, cloth_category G";
		sql += " WHERE  T.cloth_code = C.cloth_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND T.temperature_grade_code = ? AND G.cloth_category_name = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, selector.getTemperature_grade_code());
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

}
