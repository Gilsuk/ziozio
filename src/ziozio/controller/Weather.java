package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.service.face.LocationService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/weather")
public class Weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WeatherInfoService weatherinfoService = WeatherInfoServiceImpl.getInstance();
	private LocationService locationService = LocationServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Location location = locationService.getDefaultLocation();
//		Location location = locationService.getLocation(req);
//		
//		
//		List<WeatherInfo> weatherList = weatherinfoService.getWeatherInfosToday(location);
		 
//		System.out.println(weatherList);
		
//		req.setAttribute("weatherList", weatherList);
//		
//		req.getRequestDispatcher("/WEB-INF/views/weather/weather.jsp").forward(req, resp);
		
		Location location = null;
		HttpSession session = null;
		session=req.getSession();
		System.out.println("세션확인"+session.getAttribute("location"));
		if(!(session.getAttribute("location")==null)) {
			location=(Location)session.getAttribute("location");
		}
		if(location == null) {
			
		location = locationService.getDefaultLocation();
		
		List<WeatherInfo> weatherList = weatherinfoService.getWeatherInfosToday(location);
		
		req.setAttribute("weatherList", weatherList);
		
		req.getRequestDispatcher("/WEB-INF/views/weather/weather.jsp").forward(req, resp);
		
		} else {
			
			location = locationService.getLocation(req);
//			System.out.println(location);
			List<WeatherInfo> locweatherList = weatherinfoService.getWeatherInfosToday(location);
			
			req.setAttribute("locweatherList", locweatherList);
			
			req.getRequestDispatcher("/WEB-INF/views/weather/locationweather.jsp").forward(req, resp);
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Location location = null;
//		HttpSession session = null;
//		session=req.getSession();
//		System.out.println("세션확인"+session.getAttribute("location"));
//		if(!(session.getAttribute("location")==null)) {
//			location=(Location)session.getAttribute("location");
//		
//		System.out.println(location);
//		
//		if(req.getParameter("date").equals("1")) {
//			System.out.println(req.getParameter("date"));
//			int date = 1;
//			List<WeatherInfo> locweatherList = weatherinfoService.getWeatherInfos(location, date);
//			
//			req.getRequestDispatcher("/WEB-INF/views/weather/locationweather.jsp");
//		}
		
//		}
		
		
	}

}
