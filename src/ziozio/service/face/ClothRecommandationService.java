package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothRecommandationService {
	
	Cloth recommandClothByCategory(HttpServletRequest req, String category);
	
	List<Cloth> recommandClothSet(HttpServletRequest req);

	List<List<Cloth>> recommandClothSets(HttpServletRequest req, Paging paging);

}
