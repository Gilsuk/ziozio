package ziozio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import ziozio.dto.DTO;
import ziozio.utils.db.oracle.DBConn;

public class Dao {
	
	public static <T extends DTO> T select(
			String sql, T dto,
			BiConsumer<PreparedStatement, T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		Connection conn = DBConn.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();
			
			return dtoGetter.apply(rs);

		} catch (SQLException e) { e.printStackTrace(); }

		return null;
	}

	public static <T extends DTO> List<T> selectList(
			String sql, T dto,
			BiConsumer<PreparedStatement, T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		Connection conn = DBConn.getConnection();

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

	public static <T extends DTO> int update(
			String sql, T dto,
			BiConsumer<PreparedStatement, T> stateSetter) {
		
		Connection conn = DBConn.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			return ps.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace(); }

		return 0;
	}

	public static <T extends DTO> int massUpdate(
			String sql, List<T> dtoList,
			BiConsumer<PreparedStatement, T> stateSetter) {
		
		Connection conn = DBConn.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			int count = 0;
			for (T dto : dtoList) {
				stateSetter.accept(ps, dto);
				count += ps.executeUpdate();
			}
			return count;
			
		} catch (SQLException e) { e.printStackTrace(); }

		return 0;
	}
}