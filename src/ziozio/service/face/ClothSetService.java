package ziozio.service.face;

import java.util.List;

import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;

public interface ClothSetService {

	ClothSet dressUp(ClothWithColor cloth, ClothSet set);

	ClothSet dressUp(ClothWithColor cloth);
	
	List<ClothSet> makeSets(List<ClothWithColor> tops, List<ClothWithColor> bottoms, List<ClothWithColor> outers); 
}
