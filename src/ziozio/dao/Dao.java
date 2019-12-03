package ziozio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.SelectResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dto.DTO;
import ziozio.utils.db.oracle.DBConn;

public class Dao {
	
	public static <T extends DTO> T select (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, T> dtoGetter) throws SelectResultException {
		
		Connection conn = DBConn.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			completeStatement(ps, dto, stateSetter);
			ResultSet rs = ps.executeQuery();
			return getDto(dtoGetter, rs, getResultSetSize(rs));

		} catch (SelectResultException e) { throw e; 
		} catch (SQLException e) { e.printStackTrace(); return null; }

	}

	public static <T extends DTO, U extends DTO> U select (
			String sql, T inDto, Class<U> outDto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, U> dtoGetter) throws SelectResultException {
		
		Connection conn = DBConn.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
	
			completeStatement(ps, inDto, stateSetter);
			ResultSet rs = ps.executeQuery();
			return getDto(dtoGetter, rs, getResultSetSize(rs));
	
		} catch (SelectResultException e) { throw e; 
		} catch (SQLException e) { e.printStackTrace(); return null;  }
	
	}

	public static <T extends DTO> List<T> selectList (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		Connection conn = DBConn.getConnection();
	
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
	
			completeStatement(ps, dto, stateSetter);
			ResultSet rs = ps.executeQuery();
			return getListFromResultSet(rs, dtoGetter);
	
		} catch (SQLException e) { e.printStackTrace(); return null;  }
	
	}

	public static <T extends DTO, U extends DTO> List<U> selectList (
			String sql, T inDto, Class<U> outDto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, U> dtoGetter) {
		
		Connection conn = DBConn.getConnection();
	
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			completeStatement(ps, inDto, stateSetter);
			ResultSet rs = ps.executeQuery();
			return getListFromResultSet(rs, dtoGetter);
	
		} catch (SQLException e) { e.printStackTrace(); return null;  }
	
	}

	public static <T extends DTO> int count (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter) {
		
		Connection conn = DBConn.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			completeStatement(ps, dto, stateSetter);
			ResultSet rs = ps.executeQuery();
			rs.next();

			return rs.getInt(1);
	
		} catch (SQLException e) { e.printStackTrace(); return 0; }
	
	}

	public static <T extends DTO> int update (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter) throws SQLException{
		
		Connection conn = DBConn.getConnection();
	
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			completeStatement(ps, dto, stateSetter);
			return ps.executeUpdate();
			
		} catch (SQLException e) { throw e; }
	
	}

	public static <T extends DTO> int massUpdate (
			String sql, List<T> dtoList,
			BiConsumerForSQL<T> stateSetter) throws SQLException {
		
		Connection conn = DBConn.getConnection();
	
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			int count = 0;
			for (T dto : dtoList) {
				completeStatement(ps, dto, stateSetter);
				count += ps.executeUpdate();
			}
			return count;
			
		} catch (SQLException e) { throw e; }
	
	}

	private static <T extends DTO> void completeStatement(PreparedStatement ps, T dto,
			BiConsumerForSQL<T> stateSetter) throws SQLException {
		if (stateSetter != null) stateSetter.accept(ps, dto);
	}
	
	private static int getResultSetSize(ResultSet rs) throws SQLException {
		rs.last();
		return rs.getRow();
	}
	
	private static <T extends DTO> T getDto(Function<ResultSet, T> dtoGetter, ResultSet rs, int size)
			throws NoResultException, TooManyResultException {
		if (size == 1) { return dtoGetter.apply(rs); }
		else if (size == 0) { throw new NoResultException(); }
		else { throw new TooManyResultException(); }
	}

	private static <T extends DTO> List<T> getListFromResultSet(ResultSet rs, Function<ResultSet, T> dtoGetter)
			throws SQLException {

		List<T> list = new ArrayList<>();

		while (rs.next())
			list.add(dtoGetter.apply(rs));
		
		return list;
	}
}
