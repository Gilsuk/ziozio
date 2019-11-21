package ziozio.dto.face;

public interface Updatable<T> {
	String getUpdateQuery(String[] colNames);
}
