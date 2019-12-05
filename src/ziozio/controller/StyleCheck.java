package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Location;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.service.face.LocationService;
import ziozio.service.face.StyleService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.StyleServiceImpl;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/stylecheck")
public class StyleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	WeatherInfoService weatherInfoService = WeatherInfoServiceImpl.getInstance();
	LocationService locationService = LocationServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Location defaultLocation = locationService.getDefaultLocation();
//		WeatherInfo weather = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
//		WeatherInfo temperature = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
//		req.setAttribute("defaultLocation", defaultLocation);
//		req.setAttribute("weather", weather);
//		req.setAttribute("temperature", temperature);
		
		StyleService styleService = StyleServiceImpl.getInstance();

		List<Style> allStyles = styleService.getAllStyles();
		req.setAttribute("allStyles", allStyles);
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/stylecheck.jsp").forward(req,resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String[] parameterValues = req.getParameterValues("styles[]");
		for (String string : parameterValues) {
			System.out.println(string);

		
		}
	}
}
