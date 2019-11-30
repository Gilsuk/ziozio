package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothRecommandationService {
	
	Cloth recommandClothByCategory(HttpServletRequest req, ClothCategory category);
	
	List<Cloth> recommandClothSet(HttpServletRequest req);

	List<List<Cloth>> recommandClothSets(HttpServletRequest req, int count);

}
