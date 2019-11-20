package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dto.face.DTO;
import ziozio.dto.face.SupportResultSet;
import ziozio.utils.db.oracle.DBConn;

public class SelectDaoOracle <T extends DTO<T> & SupportResultSet<T>>{
	private Connection conn = DBConn.getConnection();
	
	public List<T> select(String sql, Class<T> type) {

		try ( PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			return getListFromResultSet(rs, type);
		} catch (SQLException e) { e.printStackTrace(); }

		return null;
	}

	private List<T> getListFromResultSet(ResultSet rs, Class<T> type) throws SQLException {
		List<T> list = new ArrayList<T>();

		while(rs.next())
			list.add(getDtoFromResultSet(rs, type));

		return list;
	}

	private T getDtoFromResultSet(ResultSet rs, Class<T> type) throws SQLException {
		try {
			return type.getDeclaredConstructor().newInstance().setFieldFromResultSet(rs);
		} catch (Exception e) { e.printStackTrace(); }	
		return null;
	}
}
