package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.service.face.LocationService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/weather_get")
public class Weather_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WeatherInfoService weatherinfoService = WeatherInfoServiceImpl.getInstance();
	private LocationService locationService = LocationServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//		Location location = null;
		Location location = locationService.getLocation(req);
		System.out.println(location);
		List<WeatherInfo> locweatherList = weatherinfoService.getWeatherInfosToday(location);
		System.out.println(locweatherList);
		req.setAttribute("locweatherList", locweatherList);
		
		req.getRequestDispatcher("/WEB-INF/views/weather/locationweather.jsp").forward(req, resp);


		
	}

}
