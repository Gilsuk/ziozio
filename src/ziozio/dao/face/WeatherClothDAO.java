package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;

public interface WeatherClothDAO {

	/**
	 * 날씨에 따른 옷 목록
	 * @param weather
	 * @return
	 */
	public List<Cloth> selectAll(WeatherInfo weather);
	
	public List<Cloth> selectAll(WeatherInfo weather, ClothCategory category);
	
	public List<Cloth> selectAll(WeatherInfo weather, Paging paging);
	
	public List<Cloth> selectAll(WeatherInfo weather, ClothCategory category, Paging paging);
	
	public int selectCntAll(WeatherInfo weather);

	public int selectCntAll(WeatherInfo weather, ClothCategory category);
	
	
}
