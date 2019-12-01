package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Style;

public interface ClothDAO {
	
	/**
	 * 전체 옷 목록 조회
	 * 
	 * @return List - 조회된 옷 목록
	 */
	public List<Style> selectAll();
	

}
