package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothRecommandationService {
	
	/*
	 * 카테고리별 의상을 '하나' 추천한다.
	 */
	Cloth recommandClothByCategory(HttpServletRequest req, String category);
	
	/*
	 * 의상 세트를 한 벌 추천한다.
	 */
	List<Cloth> recommandClothSet(HttpServletRequest req);

	/*
	 * 의상 세트를 여러개 추천한다.
	 */
	List<List<Cloth>> recommandClothSets(HttpServletRequest req, Paging paging);

}
