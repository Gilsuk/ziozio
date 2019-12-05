package ziozio.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.WeatherClothDAO;
import ziozio.dao.impl.WeatherClothDAOImpl;
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
 * WeatherInfo 객체의 weather_name을 기준으로 쪼인 하여 옷을 검색한다.
 */
public class WeatherClothService implements ClothService<WeatherInfo>{
	
	private WeatherClothDAO weatherclothDao = new WeatherClothDAOImpl();
	private ClothColorService<Cloth> clothColorService = ClothColorServiceImpl.getInstance();

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo weather) {
		return clothColorService.setRandomColor(weatherclothDao.selectAll(weather));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo weather, ClothCategory category) {
		return clothColorService.setRandomColor(weatherclothDao.selectAll(weather, category));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo weather, Paging paging) {
		return clothColorService.setRandomColor(weatherclothDao.selectAll(weather, paging));
	}

	@Override
	public List<ClothWithColor> getClothes(WeatherInfo weather, ClothCategory category, Paging paging) {
		return clothColorService.setRandomColor(weatherclothDao.selectAll(weather, category, paging));
	}

	@Override
	public Paging getPaging(WeatherInfo weather, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = weatherclothDao.selectCntAll(weather);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Paging getPaging(WeatherInfo weather, ClothCategory category, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = weatherclothDao.selectCntAll(weather, category);
		
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
