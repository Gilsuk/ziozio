package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@Override
	public List<Cloth> getClothes(WeatherInfo selector) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, ClothCategory category) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo selector, ClothCategory category, Paging paging) {
		return null;
	}

	@Override
	public Paging getPaging(WeatherInfo selector, HttpServletRequest req) {
		return null;
	}

	@Override
	public Paging getPaging(WeatherInfo selector, ClothCategory category, HttpServletRequest req) {
		return null;
	}

}
