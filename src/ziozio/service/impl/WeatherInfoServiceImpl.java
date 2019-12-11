package ziozio.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.WeatherInfoDAO;
import ziozio.dao.impl.WeatherInfoDAOImpl;
import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.Weather;
import ziozio.service.face.WeatherInfoService;

public class WeatherInfoServiceImpl implements WeatherInfoService {
	
	private WeatherInfoDAO weatherinfoDao = WeatherInfoDAOImpl.getInstance();

	/*
	 * Singleton
	 */
	private WeatherInfoServiceImpl() { }
    private static class Factory {
        public static final WeatherInfoService INSTANCE = new WeatherInfoServiceImpl();
    }
    public static WeatherInfoService getInstance() { return Factory.INSTANCE; }

	@Override
	public WeatherInfo getCurrentWeatherInfo(HttpServletRequest req, Location loc) {
		Object weatherinfo = req.getSession().getAttribute("weatherinfo");

		if (weatherinfo != null)
			return (WeatherInfo) weatherinfo;

		WeatherInfo weather = weatherinfoDao.selectAll(loc);
		
		if (weather == null)
			weather = getDefaultWeather();
		
		setWeatherToSession(req, weather);
		return weather;
		
	}

	private WeatherInfo getDefaultWeather() {
		WeatherInfo weather = new WeatherInfo();
		
		weather.setLocation_name("대한민국");
		weather.setTemperature_grade_code(4);
		weather.setWeahter_info_date(new Date(System.currentTimeMillis()));
		weather.setWeahter_info_date_str(weather.getWeahter_info_date().toString());
		weather.setWeather_info_finedust(50.0);
		weather.setWeather_info_temperature(18.5);
		weather.setWeather_name("맑음");
		
		return weather;
	}

	@Override
	public List<WeatherInfo> getWeatherInfos(Location loc, int count) {
		
		return weatherinfoDao.selectAll(loc, count);
	}

	@Override
	public List<WeatherInfo> getWeatherInfosToday(Location loc) {
		return getWeatherInfos(loc, 16);
	}

	@Override
	public double getHighTemperature(List<WeatherInfo> weatherInfos) {
		double max = -100;
		for (WeatherInfo weatherInfo : weatherInfos) {
			double temp = weatherInfo.getWeather_info_temperature();
			max = temp > max ? temp : max;
		}
		return max;
	}

	@Override
	public double getLowTemperature(List<WeatherInfo> weatherInfos) {
		double low = 100;
		for (WeatherInfo weatherInfo : weatherInfos) {
			double temp = weatherInfo.getWeather_info_temperature();
			low = temp < low ? temp : low;
		}
		return low;
	}

	@Override
	public double getFineDust(List<WeatherInfo> weatherInfos) {
		double max = -100;
		for (WeatherInfo weatherInfo : weatherInfos) {
			double temp = weatherInfo.getWeather_info_finedust();
			max = temp > max ? temp : max;
		}
		return max;
	}

	@Override
	public boolean willItBeRainOrSnow(List<WeatherInfo> weatherInfos) {

		for (WeatherInfo weatherInfo : weatherInfos) {
			String name = weatherInfo.getWeather_name();
			if (name == Weather.RAIN.toString() || name == Weather.SNOW.toString())
				return true;
		}
		return false;
	}
	
	private void setWeatherToSession(HttpServletRequest req, WeatherInfo weather) {
		req.getSession().setAttribute("weatherinfo", weather);
	}

}
