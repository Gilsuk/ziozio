package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;

public interface StyleClothDAO {
	
	/**
	 * 스타일로 옷 목록 조회
	 * @param style - 스타일 전체 옷 목록
	 * @return
	 */
	List<Cloth> selectAll(Style style);

	/**
	 * 스타일과 카테고리로 옷 목록 조회
	 * @param style
	 * @param category
	 * @return
	 */
	List<Cloth> selectAll(Style style, ClothCategory category);

	/**
	 * 스타일 옷 목록 페이징
	 * @param style
	 * @return
	 */
	int selectCntAll(Style style);

	/**
	 * 스타일과 카테고리로 옷 목록 페이징
	 * @param style
	 * @param category
	 * @return
	 */
	int selectCntAll(Style style, ClothCategory category);

	
	List<Cloth> selectAll(Style style, Paging paging);

	
	List<Cloth> selectAll(Style style, ClothCategory category, Paging paging);

	List<Cloth> selectAll(List<Style> selector, ClothCategory category, Paging paging);

	

}
