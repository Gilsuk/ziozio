package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.ClothSet;
import ziozio.dto.Paging;
import ziozio.service.face.ClothRecommandationService;

public class ClothRecommandationServiceImpl implements ClothRecommandationService {

	/*
	 * Singleton
	 */
	private ClothRecommandationServiceImpl() { }
    private static class Factory {
        public static final ClothRecommandationService INSTANCE = new ClothRecommandationServiceImpl();
    }
    public static ClothRecommandationService getInstance() { return Factory.INSTANCE; }

	@Override
	public List<ClothSet> recommandClothSets(HttpServletRequest req, Paging paging) {
		
		
		
		
		return null;
	}

}
