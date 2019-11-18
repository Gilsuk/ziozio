package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dao.face.JoinDAO;
import ziozio.dbutil.DBConn;
import ziozio.dto.State;
import ziozio.dto.User;

public class JoinDAOImpl implements JoinDAO {

	//DB연결 객체
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL 수행 결과 객체

	
	
 
    private static class Factory {
        public static final JoinDAO INSTANCE = new JoinDAOImpl();
    }
 
    public static JoinDAO getInstance() {
        return Factory.INSTANCE;
    }

	@Override
	public String selectUserpwById(String id) {
		return null;
	}

	@Override
	public User selectUserById(String id) {
		return null;
	}

	@Override
	public State selectUserByUserno(int userno) {
		return null;
	}

	@Override
	public void insertUser(User user) {

		conn = DBConn.getConnection();	//DB 연결
		
		String sql = "";
		sql += "INSERT into user values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getUsernick());
			ps.setString(5, user.getUserbirth());
			ps.setString(6, user.getUserphone());
			ps.setString(7, user.getUseremail());
			ps.setString(8, user.getUsergender());
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)	ps.close();
			}catch (Exception e) {
			}
		}
	
	}
}
