package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;

public interface TemperatureClothDAO {

	public List<Cloth> selectAll(WeatherInfo selector);

	public List<Cloth> selectAll(WeatherInfo selector, ClothCategory category);
	
	public List<Cloth> selectAll(WeatherInfo selector, Paging paging);
	
	public List<Cloth> selectAll(WeatherInfo selector, ClothCategory category, Paging paging);
	
	public int selectCntAll(WeatherInfo selector);
	
	public int selectCntAll(WeatherInfo selector, ClothCategory category);
	
	
}
