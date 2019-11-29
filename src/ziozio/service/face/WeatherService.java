package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Location;
import ziozio.dto.Weather;

public interface WeatherService {
	
	Weather getCurrentWeather(Location loc);

	Weather getCurrentWeather(HttpServletRequest req);

	List<Weather> getWeathers(Location loc, int count);

	List<Weather> getWeathers(HttpServletRequest req, int count);
	
	List<Weather> getWeathersToday(Location loc);

	List<Weather> getWeathersToday(HttpServletRequest req);
	
	Weather getRepresentativeWeather(List<Weather> weathers);

	double getHighTemperature(List<Weather> weathers);

	double getLowTemperature(List<Weather> weather);
	
	double getFineDust(List<Weather> weather);
	
	boolean willItBeRainOrSnow(List<Weather> weather);

}
