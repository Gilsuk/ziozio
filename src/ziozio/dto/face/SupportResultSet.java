package ziozio.dto.face;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SupportResultSet <T> {
	T setFieldFromResultSet(ResultSet rs) throws SQLException;
}
