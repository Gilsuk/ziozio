package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.TemperatureClothDAO;
import ziozio.dao.impl.TemperatureClothDAOImpl;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothColorService;
import ziozio.service.face.ClothService;

/**
 * 
 * @author gilsuk
 *
 * WeatherInfo 객체에서 temperature_grade_code를 얻어서 옷을 조회한다.
 */
public class TemperatureClothService implements ClothService<WeatherInfo>{

	/*
	 * Fields
	 */
	private TemperatureClothDAO temperatureClothDao = TemperatureClothDAOImpl.getInstance();
	private ClothColorService<Cloth> clothColorService = ClothColorServiceImpl.getInstance();
	
	/*
	 * Singleton
	 */
	private TemperatureClothService() { }
    private static class Factory {
        public static final ClothService<WeatherInfo> INSTANCE = new TemperatureClothService();
    }
    public static ClothService<WeatherInfo> getInstance() { return Factory.INSTANCE; }

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo selector) {
		return clothColorService.setRandomColor(temperatureClothDao.selectAll(selector));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo selector, ClothCategory category) {
		return clothColorService.setRandomColor(temperatureClothDao.selectAll(selector, category));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo selector, Paging paging) {
		return clothColorService.setRandomColor(temperatureClothDao.selectAll(selector, paging));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo selector, ClothCategory category, Paging paging) {
		return clothColorService.setRandomColor(temperatureClothDao.selectAll(selector, category, paging));
	}

	@Override
	public Paging getPaging(WeatherInfo selector, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = temperatureClothDao.selectCntAll(selector);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging(WeatherInfo selector, ClothCategory category, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = temperatureClothDao.selectCntAll(selector, category);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public List<ClothWithColor> getClothes(List<WeatherInfo> selector, ClothCategory category) {
		return null;
	}

	@Override
	public List<ClothWithColor> getClothes(List<WeatherInfo> selector, ClothCategory category, Paging paging) {
		return null;
	}

}
