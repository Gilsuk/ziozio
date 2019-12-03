package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

//	public static void main(String[] args) {
//		        				 		
//		 
//	}
	
	@Override
	public WeatherInfo selectAll(Location loc) {

		conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql +="		wi.weather_info_date";
		sql +="     , l.location_name";
		sql +="     , w.weather_name";
		sql +="     , wi.weather_info_temperature";
		sql +="     , wi.weather_info_finedust";
		sql +="     FROM location L, weather_info WI, weather W";
		sql +="     WHERE l.location_code = wi.location_code";
		sql +="     AND W.weather_code = wi.weather_code";
		sql +="     AND W.weather_info_date = to_date(?, 'yyyy-mm-dd hh24')";

		// 최종 결과를 저장할 List
		WeatherInfo info = new WeatherInfo();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH");
			String format_time = format.format (System.currentTimeMillis());
			
			ps.setString(1, format_time);
			
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
		
		return info;
	}

	@Override
	public List<WeatherInfo> selectAll(Location loc, int count) {
		
conn = DBConn.getConnection(); // DB 연결
		
		String sql = "";
		sql += "SELECT ";
		sql +="		wi.weather_info_date";
		sql +="     , l.location_name";
		sql +="     , w.weather_name";
		sql +="     , wi.weather_info_temperature";
		sql +="     , wi.weather_info_finedust";
		sql +="     FROM location L, weather_info WI, weather W";
		sql +="     WHERE l.location_code = wi.location_code";
		sql +="     AND W.weather_code = wi.weather_code";
		sql +="     AND W.weather_info_date = to_date(?, 'yyyy-mm-dd hh24')";

		// 최종 결과를 저장할 List
		List<WeatherInfo> list = new ArrayList<WeatherInfo>();		
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH");
			String format_time = format.format (System.currentTimeMillis());
			
			ps.setString(1, format_time);
			
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

				list.add(weather);
				
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
