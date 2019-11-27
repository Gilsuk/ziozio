package ziozio.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ziozio.dto.DTO;

public interface BiConsumerForSQL<T extends DTO> {
	void accept(PreparedStatement ps, T dto) throws SQLException;
}
