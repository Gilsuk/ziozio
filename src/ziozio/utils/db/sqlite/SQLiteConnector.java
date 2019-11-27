package ziozio.utils.db.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB연결객체 - 싱글톤
public class SQLiteConnector {
	private SQLiteConnector() { }
	private static class Factory {
		public static Connection CONNECTION;
		static {
			try {
				CONNECTION = DriverManager.getConnection("jdbc:sqlite:ziozio.db");
			} catch (SQLException e) { e.printStackTrace(); }
		}
	}
	public static Connection getConnection() { 
		return Factory.CONNECTION;
	}
}
