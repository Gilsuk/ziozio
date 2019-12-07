package ziozio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Location;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.face.ClothSetService;
import ziozio.service.face.LocationService;
import ziozio.service.face.StyleService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.ClothSetServiceImpl;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.StyleServiceImpl;
import ziozio.service.impl.WeatherClothService;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClothService<WeatherInfo> clothService = WeatherClothService.getInstance();
	WeatherInfoService weatherInfoService = WeatherInfoServiceImpl.getInstance();
	LocationService locationService = LocationServiceImpl.getInstance();
	ClothSetService setService = ClothSetServiceImpl.getInstance();
	AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Location defaultLocation = locationService.getDefaultLocation();
		WeatherInfo weather = weatherInfoService.getCurrentWeatherInfo(defaultLocation);

		StyleService styleService = StyleServiceImpl.getInstance();

		List<Style> allStyles = styleService.getAllStyles();
		req.setAttribute("allStyles", allStyles);
		
		List<ClothWithColor> topList = clothService.getClothes(weather, ClothCategory.TOP);
		List<ClothWithColor> bottomList = clothService.getClothes(weather,ClothCategory.BOTTOM);
		List<ClothWithColor> outerList = clothService.getClothes(weather, ClothCategory.OUTER);
		
		List<ClothWithColor> allList = new ArrayList<>(topList);
		allList.addAll(bottomList);
		allList.addAll(outerList);
		Collections.shuffle(allList);

		
		
		req.setAttribute("allList", allList);
		
		req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);
	}
}
