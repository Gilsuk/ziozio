package ziozio.dao.face;

import ziozio.dto.User;

public interface LoginDAO {

	/**
	 * 유저아이디 존재여부
	 *
	 */	
	public int selectCntLoginByUserid(User user);
	
	/*
	 * 유저 아이디에 맞는 데이터 구하는 메서드
	 */	
	public User selectLoginByUserid(User user);
	
	
	public void insert(User user);
}
