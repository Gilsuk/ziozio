package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Style;

public interface StyleDAO {
	
	/**
	 * 전체 스타일 목록 조회
	 * 
	 * @return List - 전체 스타일 목록
	 */
	public List<Style> selectAll();
	

}
