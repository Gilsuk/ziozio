package ziozio.controller.clothLook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.ClothWithColor;
import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;
import ziozio.service.face.LocationService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.WeatherClothService;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/weather/cloth")
public class WeatherCloth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClothService<WeatherInfo> clothService = WeatherClothService.getInstance();
	WeatherInfoService weatherInfoService = WeatherInfoServiceImpl.getInstance();
	LocationService locationService = LocationServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//	WeatherClothDAOImpl dao = new WeatherClothDAOImpl();
		//	WeatherInfo weather = new WeatherInfo();
		//	weather.setWeather_name("흐림");
		Location defaultLocation = locationService.getDefaultLocation();
		WeatherInfo weather = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
		WeatherInfo temperature = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
		
	
		
		List<ClothWithColor> topList = clothService.getClothes(weather, ClothCategory.TOP);
		List<ClothWithColor> bottomList = clothService.getClothes(weather,ClothCategory.BOTTOM);
		List<ClothWithColor> outerList = clothService.getClothes(weather, ClothCategory.OUTER);
		
		req.setAttribute("topList", topList);
		req.setAttribute("bottomList", bottomList);
		req.setAttribute("outerList", outerList);
		req.setAttribute("defaultLocation", defaultLocation);
		req.setAttribute("weather", weather);
		req.setAttribute("temperature", temperature);
		

		
		
		
		req.getRequestDispatcher("/WEB-INF/views/clothlook/weathercloth.jsp").forward(req,resp);
	}
}
