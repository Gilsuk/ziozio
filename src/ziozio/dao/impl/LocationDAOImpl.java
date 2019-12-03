package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.LocationDAO;
import ziozio.dto.Location;
import ziozio.dto.Style;
import ziozio.utils.db.oracle.DBConn;

public class LocationDAOImpl implements LocationDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/*
	 * Singleton
	 */
    private LocationDAOImpl() { }
    private static class Factory {
        public static final LocationDAO INSTANCE = new LocationDAOImpl();
    }
    public static LocationDAO getInstance() { return Factory.INSTANCE; }

    
    
//    public static void main(String[] args) {
//		LocationDAOImpl loc = new LocationDAOImpl();
//		
//		String locn = "전라남도 완도군 금당면";
//		
//		Location location = loc.select(locn);
//		
//		System.out.println(location);
//	}
    
    
    /*
     * implements
     */
	@Override
	public Location select(String localname) {
		
		//TEST까지 했음
		
		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT";
		sql += "	location_code";
		sql += "	, location_name";
		sql += "	FROM location";
		sql += "	WHERE location_name = ?";
//		sql += "	ORDER BY location_code";
	
//		// 최종 결과를 저장할 List
		Location list = null;
//
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, localname);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();		

			// SQL 수행 결과 처리
			while (rs.next()) {
				Location location = new Location();

				location.setLocation_code(rs.getLong("location_code"));
				location.setLocation_name(rs.getString("location_name"));							

				return location;
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
}
