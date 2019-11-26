package ziozio.dao.face;

import java.sql.SQLException;

import ziozio.dto.AccountIncludeAuthInfo;

public interface JoinDAO {

//	String selectUserpwById(String id);
//
//	Account selectUserById(String id);
//
//	State selectUserByUserno(int userno);
//
//	
//	public void insertUser(Account user);
//
//	
//	public int selectNextUserno();
//	
	
//	public int emailCheck(String useremail);
//	
//	
//	public int nickCheck(String usernick);

	void insert(AccountIncludeAuthInfo account) throws SQLException;
	
}
