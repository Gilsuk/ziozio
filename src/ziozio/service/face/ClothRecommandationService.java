package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.ClothSet;
import ziozio.dto.Paging;

public interface ClothRecommandationService {
	
	/*
	 * 의상 세트를 여러개 추천한다.
	 */
	List<ClothSet> recommandClothSets(HttpServletRequest req, Paging paging);

}
