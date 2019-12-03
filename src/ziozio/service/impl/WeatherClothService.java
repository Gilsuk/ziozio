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
 * WeatherInfo 객체의 weather_name을 기준으로 쪼인 하여 옷을 검색한다.
 */
public class WeatherClothService implements ClothService<WeatherInfo, Cloth>{

	@Override
	public List<Cloth> getClothes(WeatherInfo weather) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo weather, ClothCategory category) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo weather, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(WeatherInfo weather, ClothCategory category, Paging paging) {
		return null;
	}

	@Override
	public Paging getPaging(WeatherInfo weather, HttpServletRequest req) {
		return null;
	}

	@Override
	public Paging getPaging(WeatherInfo weather, ClothCategory category, HttpServletRequest req) {
		return null;
	}

}
