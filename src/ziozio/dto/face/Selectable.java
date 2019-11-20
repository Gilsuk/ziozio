package ziozio.dto.face;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Selectable <T> {
	T setFieldFromResultSet(ResultSet rs) throws SQLException;
}
