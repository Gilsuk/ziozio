package ziozio.service.face;

import java.util.List;

import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;

public interface WeatherInfoService {
	
	WeatherInfo getCurrentWeatherInfo(Location loc);

	List<WeatherInfo> getWeatherInfos(Location loc, int count);

	List<WeatherInfo> getWeatherInfosToday(Location loc);

	WeatherInfo getRepresentativeWeatherInfo(List<WeatherInfo> weatherInfos);

	double getHighTemperature(List<WeatherInfo> weatherInfos);

	double getLowTemperature(List<WeatherInfo> weatherInfos);
	
	double getFineDust(List<WeatherInfo> weatherInfos);
	
	boolean willItBeRainOrSnow(List<WeatherInfo> weatherInfos);

}
