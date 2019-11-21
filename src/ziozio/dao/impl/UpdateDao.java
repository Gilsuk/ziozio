package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ziozio.dto.face.DTO;
import ziozio.dto.face.Updatable;
import ziozio.utils.db.oracle.DBConn;

public class UpdateDao <T extends DTO<T> & Updatable<T>>{
	private Connection conn = DBConn.getConnection();
	
	public boolean update(T dto, String[] colNames) {
		return execUpdate(dto, colNames);
	}

	public boolean update(T dto, String colName) {
		return update(dto, new String[] {colName});
	}

	private boolean execUpdate(T dto, String[] colNames) {
		try ( PreparedStatement ps = conn.prepareStatement(dto.getUpdateQuery(colNames))) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) { e.printStackTrace(); }
		return false;
	}	
}
