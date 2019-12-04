package ziozio.service.impl;

import java.util.List;

import ziozio.dao.face.WeatherInfoDAO;
import ziozio.dao.impl.WeatherInfoDAOImpl;
import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.service.face.WeatherInfoService;

public class WeatherInfoServiceImpl implements WeatherInfoService {
	
	private WeatherInfoDAO weatherinfoDao = new WeatherInfoDAOImpl();

	@Override
	public WeatherInfo getCurrentWeatherInfo(Location loc) {
		
		return weatherinfoDao.selectAll(loc);
		
	}

	@Override
	public List<WeatherInfo> getWeatherInfos(Location loc, int count) {
		
		return weatherinfoDao.selectAll(loc, count);
	}

	@Override
	public List<WeatherInfo> getWeatherInfosToday(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		WeatherInfoDAOImpl infoDao = new WeatherInfoDAOImpl();
		WeatherInfoService infoSiv = new WeatherInfoServiceImpl();
		
		Location loc = new Location();
		loc.setLocation_name("서울특별시 서초구 서초2동");
		String str = "흐림";
		
		List<WeatherInfo> weatherInfos = infoSiv.getWeatherInfos(loc, 1);

//		Location loc = new Location();
//		loc.setLocation_name("서울특별시 서초구 서초2동");
//		List<WeatherInfo> weatherinfos = infoDao.selectAll(loc, 10);
//		
		for (WeatherInfo weatherInfo : weatherInfos) {
			System.out.println(weatherInfo);
		}

	}
	
	@Override
	public WeatherInfo getRepresentativeWeatherInfo(List<WeatherInfo> weatherInfos) {
				
		return null;
	}

	@Override
	public double getHighTemperature(List<WeatherInfo> weatherInfos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLowTemperature(List<WeatherInfo> weatherInfos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getFineDust(List<WeatherInfo> weatherInfos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean willItBeRainOrSnow(List<WeatherInfo> weatherInfos) {

	
		
		return false;
	}

}
