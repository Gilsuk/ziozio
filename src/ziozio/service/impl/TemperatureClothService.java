package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.TemperatureClothDAO;
import ziozio.dao.impl.TemperatureClothDAOImpl;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

/**
 * 
 * @author gilsuk
 *
 * WeatherInfo 객체에서 temperature_grade_code를 얻어서 옷을 조회한다.
 */
public class TemperatureClothService implements ClothService<WeatherInfo, Cloth>{

	TemperatureClothDAO temperatureClothDao = new TemperatureClothDAOImpl();
	
	@Override
	public List<Cloth> getClothes(WeatherInfo selector) {
		return temperatureClothDao.selectAll(selector);
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, ClothCategory category) {
		return temperatureClothDao.selectAll(selector, category);
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, Paging paging) {
		return temperatureClothDao.selectAll(selector, paging);
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, ClothCategory category, Paging paging) {
		return temperatureClothDao.selectAll(selector, category, paging);
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

}
