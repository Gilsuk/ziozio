package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ziozio.dto.face.DTO;
import ziozio.dto.face.Insertable;
import ziozio.dto.face.Selectable;
import ziozio.utils.db.oracle.DBConn;

public class InsertDao <T extends DTO<T> & Insertable<T>> {

	private Connection conn = DBConn.getConnection();
	
	public boolean insert(T dto) {
		String sql = dto.getInsertQuery();

		try ( PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) { e.printStackTrace(); }
		return false;
	}

}
