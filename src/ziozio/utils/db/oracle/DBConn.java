package ziozio.utils.db.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	private final Connection conn;
	
	//private 생성자
	private DBConn() {
		try { Class.forName(DRIVER); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }

		Connection tmpConn = null;
		try { tmpConn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) { e.printStackTrace(); }

		conn = tmpConn;
	}
	
    private static class Factory {
    	public static final Connection CONN = new DBConn().conn;
    }

    public static Connection getConnection() {
        return Factory.CONN;
    }
    
}
