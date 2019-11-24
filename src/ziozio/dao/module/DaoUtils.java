package ziozio.dao.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import ziozio.utils.db.oracle.DBConn;

public class DaoUtils<T> {
	
	private Connection conn = DBConn.getConnection();
	
	public T select(
			String sql, T dto,
			BiConsumer<PreparedStatement, T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();
			
			return dtoGetter.apply(rs);

		} catch (SQLException e) { e.printStackTrace(); }

		return null;
	}

	public List<T> selectList(
			String sql, T dto,
			BiConsumer<PreparedStatement, T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();
			
			List<T> list = new ArrayList<>();
			while (rs.next())
				list.add(dtoGetter.apply(rs));
			
			return list;

		} catch (SQLException e) { e.printStackTrace(); }

		return null;
	}
}
