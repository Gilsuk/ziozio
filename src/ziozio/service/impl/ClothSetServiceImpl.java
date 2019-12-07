package ziozio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ziozio.dto.Cloth;
import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;
import ziozio.service.exception.ClothCategoryNotMatched;
import ziozio.service.face.ClothColorService;
import ziozio.service.face.ClothSetService;

public class ClothSetServiceImpl implements ClothSetService {

    private Random random = new Random();
    private ClothColorService<Cloth> clothColorService = ClothColorServiceImpl.getInstance();

	/*
	 * Singleton
	 */
	private ClothSetServiceImpl() { }
    private static class Factory {
        public static final ClothSetService INSTANCE = new ClothSetServiceImpl();
    }
    public static ClothSetService getInstance() { return Factory.INSTANCE; }

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

	@Override
	public List<ClothSet> makeSets(List<ClothWithColor> tops, List<ClothWithColor> bottoms,
			List<ClothWithColor> outers) {
		
		int max = tops.size();
		max = bottoms.size() > max ? bottoms.size() : max;
		max = outers.size() > max ? outers.size() : max;
		
		if (tops.size() == 0) tops = null; else stretchListLengthByMaxWidth(tops, max);
		if (bottoms.size() == 0) bottoms = null; else stretchListLengthByMaxWidth(bottoms, max);
		if (outers.size() == 0) outers = null; else stretchListLengthByMaxWidth(outers, max);

		List<ClothSet> list = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			ClothSet set = new ClothSet();
			try {
				if (tops != null) set.setTop(tops.get(i));
				if (bottoms != null) set.setBottom(bottoms.get(i));
				if (outers != null) set.setOuter(outers.get(i));
			} catch (ClothCategoryNotMatched e) { e.printStackTrace(); }

			list.add(set);
		}
		
		return list;
	}

	private void stretchListLengthByMaxWidth(List<ClothWithColor> list, int max) {
		while (list.size() < max) {
			Cloth cloth = list.get(random.nextInt(list.size()));
			list.add(clothColorService.setRandomColor(cloth));
		}
	}

}
