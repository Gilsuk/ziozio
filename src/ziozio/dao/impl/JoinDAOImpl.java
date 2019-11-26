package ziozio.dao.impl;

import java.sql.SQLException;

import ziozio.dao.Dao;
import ziozio.dao.face.JoinDAO;
import ziozio.dto.AccountIncludeAuthInfo;

public class JoinDAOImpl implements JoinDAO {

	private JoinDAOImpl() { }
    private static class Factory {
        public static final JoinDAO INSTANCE = new JoinDAOImpl();
    }
    public static JoinDAO getInstance() { return Factory.INSTANCE; }

//	@Override
//	public void insertUser(Account user) {
//
//		conn = DBConn.getConnection();	//DB 연결
//		
//		String sql = "";
//		sql += "INSERT into account values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			
//			ps.setString(1, user.getUseremail());
//			ps.setString(2, user.getUserpw());
//			ps.setString(3, user.getUsername());
//			ps.setString(4, user.getUsernick());
//			ps.setString(5, user.getUserbirth_year());
//			ps.setString(6, user.getUserbirth_mon());
//			ps.setString(7, user.getUserbirth_day());
//			ps.setString(8, user.getUserphone());
//			ps.setString(9, user.getUsergender());
//			
//			ps.executeUpdate();
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(ps!=null)	ps.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	
//	}
//
//	@Override
//	public int selectNextUserno() {
//
//		conn = DBConn.getConnection();
//		
//		String sql = "SELECT account_seq.nextval userno FROM dual";
//				
//		int nextval = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);//쿼리 수행 객체
//			rs = ps.executeQuery(); //쿼리 수행 select니까 rs를 씀
//			 
////			rs.next();
//			
////			System.out.println(rs.getInt("nextval"));
////			System.out.println(rs.getInt(1)); //위와 같은 값
//			
//			while(rs.next()) {
//				
//				nextval=rs.getInt("userno");
//				
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs!=null)	rs.close();
//				if(ps!=null)	ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return nextval;
//	}
//
//
//	@Override
//	public String selectUserpwById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public Account selectUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public State selectUserByUserno(int userno) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//
//	@Override
//	public int emailCheck(String useremail) { //중복 이메일(아이디) 확인
//
//		conn = DBConn.getConnection();
//		
//		System.out.println(useremail);
//		String sql = "SELECT * FROM account WHERE useremail = ?";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, useremail);
//			
//			rs = ps.executeQuery();
//			if(rs.next()) { 
////				System.out.println(rs.getString(1));
//				return 0; //이미존재하는 회원
//			}else {
////				System.out.println("none");
//				return 1; //가입가능한 회원
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			
//	
//			try {
//				if(rs!=null)	rs.close();
//				if(ps!=null)	ps.close();
//			} catch (SQLException e) {
//			e.printStackTrace();
//			}
//	
//		}
//		
//	return -1; // 데이터베이스 오류
//
//	}
//
//	@Override
//	public int nickCheck(String usernick) { //중복 닉네임 확인
//		conn = DBConn.getConnection();
//		
//		System.out.println(usernick);
//		String sql = "SELECT * FROM account WHERE usernick = ?";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, usernick);
//			
//			rs = ps.executeQuery();
//			if(rs.next()) { 
////				System.out.println(rs.getString(1));
//				return 0; //이미존재하는 닉네임
//			}else {
////				System.out.println("none");
//				return 1; //가입가능한 닉네임
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			
//	
//			try {
//				if(rs!=null)	rs.close();
//				if(ps!=null)	ps.close();
//			} catch (SQLException e) {
//			e.printStackTrace();
//			}
//	
//		}
//		
//	return -1; // 데이터베이스 오류
//
//	}

	@Override
	public void insert(AccountIncludeAuthInfo account) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO account (");
		sql.append("account_email, account_pw, account_nick, account_gender)");
		sql.append(" VALUES (?, ?, ?, ?)");
 
		Dao.<AccountIncludeAuthInfo>update(sql.toString(), account, (t, u) -> {
				t.setString(1, u.getAccount_email());
				t.setString(2, u.getAccount_pw());
				t.setString(3, u.getAccount_nick());
				t.setString(4, String.valueOf(u.getAccount_gender()));
		});
	}

}
