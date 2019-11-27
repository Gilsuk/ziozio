package ziozio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import ziozio.dao.exception.NoResultException;
import ziozio.dao.exception.TooManyResultException;
import ziozio.dto.Count;
import ziozio.dto.DTO;
import ziozio.utils.db.oracle.DBConn;

public class Dao {
	
	public static <T extends DTO> T select (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		Connection conn = DBConn.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();
			
			int size = rs.getFetchSize();
			
			if (size == 1) { rs.next(); return dtoGetter.apply(rs); }
			else if (size == 0) { throw new NoResultException(); }
			else { throw new TooManyResultException(); }

		} catch (SQLException e) { e.printStackTrace(); return null; }

	}
	
	public static <T extends DTO, U extends DTO> U select (
			String sql, T inDto, Class<U> outDto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, U> dtoGetter) {
		
		Connection conn = DBConn.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
			stateSetter.accept(ps, inDto);
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			int size = rs.getRow();
			
			if (size == 1) { return dtoGetter.apply(rs); }
			else if (size == 0) { throw new NoResultException(); }
			else { throw new TooManyResultException(); }

		} catch (SQLException e) { e.printStackTrace(); return null;  }

	}
	
	public static <T extends DTO> List<T> selectList (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, T> dtoGetter) {
		
		Connection conn = DBConn.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();
			
			List<T> list = new ArrayList<>();
			while (rs.next())
				list.add(dtoGetter.apply(rs));
			
			return list;

		} catch (SQLException e) { e.printStackTrace(); return null;  }

	}
	
	public static <T extends DTO, U extends DTO> List<U> selectList (
			String sql, T inDto, Class<U> outDto,
			BiConsumerForSQL<T> stateSetter,
			Function<ResultSet, U> dtoGetter) {
		
		Connection conn = DBConn.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, inDto);
			ResultSet rs = ps.executeQuery();
			
			List<U> list = new ArrayList<>();
			while (rs.next())
				list.add(dtoGetter.apply(rs));
			
			return list;

		} catch (SQLException e) { e.printStackTrace(); return null;  }

	}
	
	public static <T extends DTO> Count selectCount (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter) {
		
		Connection conn = DBConn.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
			ResultSet rs = ps.executeQuery();

			rs.next();
			Count count = new Count();
			count.setCount(rs.getInt(1));

			return count;

		} catch (SQLException e) { e.printStackTrace(); return null; }

	}

	public static <T extends DTO> int update (
			String sql, T dto,
			BiConsumerForSQL<T> stateSetter) throws SQLException{
		
		Connection conn = DBConn.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			stateSetter.accept(ps, dto);
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
				stateSetter.accept(ps, dto);
				count += ps.executeUpdate();
			}
			return count;
			
		} catch (SQLException e) { throw e; }

	}
}
