package ziozio.dto;

import java.sql.ResultSet;

public interface DtoFromResultSet<T> {
	
	T setFieldFromResultSet(ResultSet rs);

}
