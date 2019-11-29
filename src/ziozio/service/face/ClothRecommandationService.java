package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;

public interface ClothRecommandationService {
	
	List<Cloth> recommandClothSet(HttpServletRequest req);

	List<Cloth> recommandClothSets(HttpServletRequest req, int count);

}
