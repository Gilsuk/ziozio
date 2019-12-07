package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.ClothSet;
import ziozio.dto.Paging;

public interface ClothRecommandationService {
	
	List<ClothSet> recommandClothSets(HttpServletRequest req, Paging paging);

}
