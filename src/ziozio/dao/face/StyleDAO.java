package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Style;

public interface StyleDAO {
	
	/**
	 * 전체 스타일 목록 조회
	 * 
	 * @return List - 전체 스타일 목록
	 */
	public List<Style> selectAll();
		
	/**
	 * 사용자 선호 스타일 목록 조회
	 * 
	 * @return List - 사용자 선호 스타일 목록
	 */
	public List<Style> accountSelectAll(Account account);
	

}
