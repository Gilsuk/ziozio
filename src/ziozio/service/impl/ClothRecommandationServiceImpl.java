package ziozio.service.impl;

import java.util.List;

import ziozio.dao.face.RecommandationDAO;
import ziozio.dao.impl.RecommandationDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Recmd;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothColorService;
import ziozio.service.face.ClothRecommandationService;

public class ClothRecommandationServiceImpl implements ClothRecommandationService {

	/*
	 * Fields
	 */
	private RecommandationDAO dao = RecommandationDAOImpl.getInstance();
	private ClothColorService<Cloth> serv = ClothColorServiceImpl.getInstance();
	
	/*
	 * Singleton
	 */
	private ClothRecommandationServiceImpl() { }
    private static class Factory {
        public static final ClothRecommandationService INSTANCE = new ClothRecommandationServiceImpl();
    }
    public static ClothRecommandationService getInstance() { return Factory.INSTANCE; }


	@Override
	public List<ClothWithColor> getClothes(Account account, WeatherInfo weather,
			List<Style> styles, ClothCategory category) {
		
		Recmd recmd = new Recmd();
		recmd.setCategory(category);
		recmd.setStyles(styles);
		recmd.setWeather(weather);
		
		if (account == null)
			return serv.setRandomColor(dao.select(recmd));
		
		recmd.setGender(account.getAccount_gender());
		return serv.setRandomColor(dao.selectByAccount(recmd));
		
	}

}
