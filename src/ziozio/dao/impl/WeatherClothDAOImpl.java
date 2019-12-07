package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.WeatherClothDAO;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.utils.db.oracle.DBConn;

public class WeatherClothDAOImpl implements WeatherClothDAO{
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	

	/*
	 * Singleton
	 */
	private WeatherClothDAOImpl() { }
    private static class Factory {
        public static final WeatherClothDAO INSTANCE = new WeatherClothDAOImpl();
    }
    public static WeatherClothDAO getInstance() { return Factory.INSTANCE; }

	//test
//	public static void main(String[] args) {
	//	WeatherClothDAOImpl dao = new WeatherClothDAOImpl();
	//	
	//	WeatherInfo weather = new WeatherInfo();
	//
	//	weather.setWeather_name("흐림");
	//	
	//	List<Cloth> list = dao.selectAll(weather);
	//	
	//	for (Cloth cloth : list) {
	//		System.out.println(cloth);
	//	}
	//}

	@Override
	public List<Cloth> selectAll(WeatherInfo weather) {
		
		//TEST까지 했음
		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	W.weather_name";
		sql += "	, C.cloth_code";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, C.cloth_gender";
		sql += " FROM cloth_weather CW, cloth C, weather W";
		sql += " WHERE  CW.cloth_code = C.cloth_code AND CW.weather_code = W.weather_code";
		sql += " AND W.weather_name = ?";
		sql += " ORDER BY W.weather_name DESC";

		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, weather.getWeather_name());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Cloth cloth = new Cloth();

				cloth.setCloth_code(rs.getInt("cloth_code"));
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
		
		return list;
	}

	
	//test
//	public static void main(String[] args) {
	//	WeatherClothDAOImpl dao = new WeatherClothDAOImpl();
	//	WeatherInfo weather = new WeatherInfo();
	//	weather.setWeather_name("흐림");
	//	List<Cloth> list = dao.selectAll(weather, ClothCategory.TOP);
	//	
	//	System.out.println(ClothCategory.TOP.getDbValue());
	//	System.out.println(ClothCategory.BOTTOM.getDbValue());
	//	System.out.println(ClothCategory.OUTER.getDbValue());
	//	for (Cloth cloth : list) {
	//		System.out.println(cloth);
	//	}
	//}

	@Override
	public List<Cloth> selectAll(WeatherInfo weather, ClothCategory category) {
	
		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql += "	W.weather_name";
		sql += "	, C.cloth_code";
		sql += "	, C.cloth_name";
		sql += "	, C.cloth_link_url";
		sql += "	, C.cloth_img";
		sql += "	, C.cloth_gender";
		sql += "	, G.cloth_category_name";
		sql += " FROM cloth_weather CW, cloth C, weather W, cloth_category G";
		sql += " WHERE  CW.cloth_code = C.cloth_code AND CW.weather_code = W.weather_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND W.weather_name = ? AND G.cloth_category_name = ?";
		sql += " ORDER BY W.weather_name DESC";

		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, weather.getWeather_name());
			ps.setString(2, category.getDbValue());
			
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Cloth cloth = new Cloth();

				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setCloth_gender((rs.getString("cloth_gender").charAt(0)));
				cloth.setCloth_category_name((rs.getString("cloth_category_name")));

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
		
		return list;
	}

	
	//test
//	public static void main(String[] args) {
//		WeatherClothDAOImpl dao = new WeatherClothDAOImpl();
//		
//		WeatherInfo weather = new WeatherInfo();
//		weather.setWeather_name("맑음");
//		Paging paging = new Paging(dao.selectCntAll(weather));
//		List<Cloth> list = dao.selectAll(weather, paging);
//	
//
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
//	
	@Override
	public List<Cloth> selectAll(WeatherInfo weather, Paging paging) {

		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "		W.weather_name";
		sql += "		, C.cloth_code";
		sql += "		, C.cloth_name";
		sql += "		, C.cloth_link_url";
		sql += "		, C.cloth_img";
		sql += "		, C.cloth_gender";
		sql += " 		FROM cloth_weather CW, cloth C, weather W";
		sql += " 		WHERE  CW.cloth_code = C.cloth_code AND CW.weather_code = W.weather_code";
		sql += " 		AND W.weather_name = ?";
		sql += " 		ORDER BY W.weather_name DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) WEATHER";
		sql += " WHERE rnum BETWEEN ? AND ?";		
		
		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, weather.getWeather_name());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Cloth cloth = new Cloth();

				cloth.setCloth_code(rs.getInt("cloth_code"));
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
		
		return list;
	}

	//test
//	public static void main(String[] args) {
//		WeatherClothDAOImpl dao = new WeatherClothDAOImpl();
//		
//		WeatherInfo weather = new WeatherInfo();
//		weather.setWeather_name("맑음");
//		Paging paging = new Paging(dao.selectCntAll(weather));
//		List<Cloth> list = dao.selectAll(weather, ClothCategory.TOP, paging);
//	
//
//		for (Cloth cloth : list) {
//			System.out.println(cloth);
//		}
//	}
	
	@Override
	public List<Cloth> selectAll(WeatherInfo weather, ClothCategory category, Paging paging) {

		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "			W.weather_name";
		sql += "			, C.cloth_code";
		sql += "			, C.cloth_name";
		sql += "			, C.cloth_link_url";
		sql += "			, C.cloth_img";
		sql += "			, C.cloth_gender";
		sql += "			, G.cloth_category_name";
		sql += " 		FROM cloth_weather CW, cloth C, weather W, cloth_category G";
		sql += " 		WHERE  CW.cloth_code = C.cloth_code AND CW.weather_code = W.weather_code";
		sql += " 		AND C.cloth_category_code = G.cloth_category_code";
		sql += " 		AND W.weather_name = ? AND G.cloth_category_name = ?";
		sql += " 		ORDER BY W.weather_name DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) WEATHER";
		sql += " WHERE rnum BETWEEN ? AND ?";		
		
		// 최종 결과를 저장할 List
		List<Cloth> list = new ArrayList<Cloth>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			ps.setString(1, weather.getWeather_name());
			ps.setString(2, category.getDbValue());
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Cloth cloth = new Cloth();


				cloth.setCloth_code(rs.getInt("cloth_code"));
				cloth.setCloth_name(rs.getString("cloth_name"));
				cloth.setCloth_link_url(rs.getString("cloth_link_url"));
				cloth.setCloth_img(rs.getString("cloth_img"));
				cloth.setCloth_gender((rs.getString("cloth_gender").charAt(0)));
				cloth.setCloth_category_name((rs.getString("cloth_category_name")));

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
		
		return list;
	}

	@Override
	public int selectCntAll(WeatherInfo weather) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM weather WHERE weather_name = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, weather.getWeather_name());
			
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
	public int selectCntAll(WeatherInfo weather, ClothCategory category) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM cloth_weather CW, cloth C, weather W, cloth_category G";
		sql += " WHERE  CW.cloth_code = C.cloth_code AND CW.weather_code = W.weather_code";
		sql += " AND C.cloth_category_code = G.cloth_category_code";
		sql += " AND W.weather_name = ? AND G.cloth_category_name = ?";
		
		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, weather.getWeather_name());
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
