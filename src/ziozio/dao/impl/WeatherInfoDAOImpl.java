package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ziozio.dao.face.WeatherInfoDAO;
import ziozio.dto.Cloth;
import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.utils.db.oracle.DBConn;

public class WeatherInfoDAOImpl implements WeatherInfoDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/*
	 * Singleton
	 */
	private WeatherInfoDAOImpl() { }
    private static class Factory {
        public static final WeatherInfoDAO INSTANCE = new WeatherInfoDAOImpl();
    }
    public static WeatherInfoDAO getInstance() { return Factory.INSTANCE; }

//	public static void main(String[] args) {
//		        		
//		WeatherInfoDAOImpl infoDao = new WeatherInfoDAOImpl();
//		
//		Location loc = new Location();
//		loc.setLocation_name("서울특별시 서초구 서초2동");
////		loc.setLocation_code(1165090200);
//		WeatherInfo info = infoDao.selectAll(loc);
//		
//		System.out.println(info);
//	}
	
	@Override
	public WeatherInfo selectAll(Location loc) {
		
		//TEST까지 했음

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql +="		wi.weather_info_date";
		sql +="     , wi.temperature_grade_code";
		sql +="     , l.location_name";
		sql +="     , l.location_code";
		sql +="     , w.weather_name";
		sql +="     , wi.weather_info_temperature";
		sql +="     , wi.weather_info_finedust";
		sql +="     FROM location L, weather_info WI, weather W";
		sql +="     WHERE l.location_code = wi.location_code";
		sql +="     AND W.weather_code = wi.weather_code";
		sql +="     AND L.location_name = ?";
		sql +="     AND WI.weather_info_date = to_date(?, 'yyyy.mm.dd hh24')";

		// 최종 결과를 저장할 List
		WeatherInfo info = new WeatherInfo();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy.MM.dd HH");
			String format_time = format.format (System.currentTimeMillis());
			
			ps.setString(1, loc.getLocation_name());
			ps.setString(2, format_time);
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				WeatherInfo weather = new WeatherInfo();
				weather.setWeahter_info_date(new java.util.Date(rs.getDate("weather_info_date").getTime()));
				weather.setLocation_name(rs.getString("location_name"));
				weather.setWeather_name(rs.getString("weather_name"));
				weather.setWeather_info_temperature(rs.getDouble("weather_info_temperature"));
				weather.setWeather_info_finedust(rs.getDouble("weather_info_finedust"));
				weather.setTemperature_grade_code(rs.getInt("temperature_grade_code"));

				
				return weather;
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
		
		return null;
	}

	
//	public static void main(String[] args) {
//
//		WeatherInfoDAOImpl infoDao = new WeatherInfoDAOImpl();
//
//		Location loc = new Location();
//		loc.setLocation_name("서울특별시 서초구 서초2동");
//		List<WeatherInfo> list = infoDao.selectAll(loc, 10);
//		
//		for (WeatherInfo weatherInfo : list) {
//			System.out.println(weatherInfo);
//		}
//
//	}
	
	
	@Override
	public List<WeatherInfo> selectAll(Location loc, int count) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "SELECT rownum rnum, B.* FROM (";
		sql += "SELECT ";
		sql +="		wi.weather_info_date";
		sql +="     , wi.temperature_grade_code";
		sql +="     , l.location_name";
		sql +="     , w.weather_name";
		sql +="     , wi.weather_info_temperature";
		sql +="     , wi.weather_info_finedust";
		sql +="     , to_char(wi.weather_info_date, 'yyyy-mm-dd hh24') weather_info_date_str ";
		sql +="     FROM location L, weather_info WI, weather W";
		sql +="     WHERE l.location_code = wi.location_code";
		sql +="     AND W.weather_code = wi.weather_code";
		sql +="     AND L.location_name = ?";
		sql +="     AND WI.weather_info_date BETWEEN to_date( ?, 'yyyy-mm-dd hh24')";
		sql +="     AND to_date( ?, 'yyyy-mm-dd hh24')+1";
		sql += "    ORDER BY wi.weather_info_date";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) WEATHER";
		sql += " WHERE rnum <= ?";

		// 최종 결과를 저장할 List
		List<WeatherInfo> weatherinfos = new ArrayList<WeatherInfo>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy.MM.dd HH");
			String format_time = format.format(System.currentTimeMillis());
//			System.out.println(format_time);
			ps.setString(1, loc.getLocation_name());
			ps.setString(2, format_time);
			ps.setString(3, format_time);
			ps.setInt(4, count);
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				WeatherInfo weather = new WeatherInfo();

				weather.setWeahter_info_date(rs.getDate("weather_info_date"));
				weather.setLocation_name(rs.getString("location_name"));
				weather.setWeather_name(rs.getString("weather_name"));
				weather.setWeather_info_temperature(rs.getDouble("weather_info_temperature"));
				weather.setWeather_info_finedust(rs.getDouble("weather_info_finedust"));
				weather.setTemperature_grade_code(rs.getInt("temperature_grade_code"));
				weather.setWeahter_info_date_str(rs.getString("weather_info_date_str")); //날짜, 시간 (JSP 출력하기 위해 추가됨)
				

				weatherinfos.add(weather);
//				System.out.println( weather.getWeahter_info_date());
//				System.out.println( weather.getWeahter_info_date_str() );
				
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
		
		return weatherinfos;
	}	

}
