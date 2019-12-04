package ziozio.service.impl;

import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;
import ziozio.service.exception.ClothCategoryNotMatched;
import ziozio.service.face.ClothSetService;

public class ClothSetServiceImpl implements ClothSetService {

	@Override
	public ClothSet dressUp(ClothWithColor cloth, ClothSet set) {
		String cloth_category_name = cloth.getCloth_category_name();
		
		try {
			if (cloth_category_name.equals("상의")) 
				set.setTop(cloth);
			else if (cloth_category_name.equals("하의"))
				set.setBottom(cloth);
			else if (cloth_category_name.equals("하의"))
				set.setOuter(cloth);
		} catch (ClothCategoryNotMatched e) { e.printStackTrace(); }

		return set;
	}

	@Override
	public ClothSet dressUp(ClothWithColor cloth) {
		ClothSet set = new ClothSet();
		dressUp(cloth, set);

		return set;
	}

}
