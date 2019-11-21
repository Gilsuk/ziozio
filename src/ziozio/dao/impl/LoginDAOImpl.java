package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ziozio.dao.face.LoginDAO;
import ziozio.dto.User;
import ziozio.utils.db.oracle.DBConn;

public class LoginDAOImpl implements LoginDAO {

	//DB연결 객체
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL 수행 결과 객체	
	
	
	@Override
	public int selectCntLoginByUserid(User user) {

		conn = DBConn.getConnection();	//DB 연결
		//수행할 SQL 쿼리
		String sql = "";
		sql += "SELECT userid FROM user";
		sql += " WHERE userpw = ?";
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);	//수행 객체 얻기
			ps.setString(1, user.getUserpw());	//SQL쿼리의 ? 채우기
			rs = ps.executeQuery();				//SQL 수행 결과 얻기
			
			//SQL 수행결과 처리
			while(rs.next()) {
				
				//아이디 비밀번호 일치 검사
				if(rs.getString(1).equals(user.getUserid()))
				cnt++;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs != null) rs.close();
					if(ps!= null) ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return cnt;
	}		


	@Override
	public User selectLoginByUserid(User user) {

		conn = DBConn.getConnection();	//DB 연결
		User user2 = new User();		//각 행을 처리할 DTO
		//수행할 SQL 쿼리
		String sql = "";
		sql += "SELECT * FROM user";
		sql += " WHERE userpw = ?";
		
		try {
			ps = conn.prepareStatement(sql);	//수행 객체 얻기
			ps.setString(1, user.getUserpw());		//SQL쿼리의 ? 채우기
			rs = ps.executeQuery();				//SQL 수행 결과 얻기
			
			//SQL 수행결과 처리
			while(rs.next()) {
				
				user2.setUserid(rs.getString("userId"));
				user2.setUserpw(rs.getString("userPw"));
				user2.setUsernick(rs.getString("userNick"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs != null) rs.close();
					if(ps!= null) ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return user2;
	}
		


	@Override
	public void insert(User user) {

		conn = DBConn.getConnection();	//DB 연결
		
		String sql = "";
		sql += "INSERT into user values (?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsernick());
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)	ps.close();
			}catch (Exception e) {
			}
		}		
	}

}