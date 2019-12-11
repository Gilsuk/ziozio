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

import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Location;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothRecommandationService;
import ziozio.service.face.LocationService;
import ziozio.service.face.StyleService;
import ziozio.service.face.WeatherInfoService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.ClothRecommandationServiceImpl;
import ziozio.service.impl.LocationServiceImpl;
import ziozio.service.impl.StyleServiceImpl;
import ziozio.service.impl.WeatherInfoServiceImpl;


@WebServlet("/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WeatherInfoService weatherInfoService = WeatherInfoServiceImpl.getInstance();
	private LocationService locationService = LocationServiceImpl.getInstance();
	private AccountService accountService = AccountServiceImpl.getInstance();
	private StyleService styleService = StyleServiceImpl.getInstance();
	private ClothRecommandationService rcmdService = ClothRecommandationServiceImpl.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Location location = locationService.getLocation(req);
		WeatherInfo weather = weatherInfoService.getCurrentWeatherInfo(req, location);
		List<Style> styles = null;
		Account account = null;

		try {
			// 로그인 된 사용자 처리
			account = accountService.getLoggedInAccount(req);
			styles = styleService.getStylesByAccount(account);
		} catch (AccountNotFountException e) {
			// 비 로그인 사용자 처리
			styles = styleService.getAllStyles();
		}

		
//		List<ClothWithColor> topList = rcmdService.getClothes(account, weather, styles, ClothCategory.TOP);
//		List<ClothWithColor> bottomList = rcmdService.getClothes(account, weather, styles, ClothCategory.TOP);
//		List<ClothWithColor> outerList = rcmdService.getClothes(account, weather, styles, ClothCategory.TOP);
		

		List<ClothWithColor> allList  = rcmdService.getClothes(account, weather, styles, ClothCategory.TOP);
//		allList.addAll(bottomList);
//		allList.addAll(outerList);
		Collections.shuffle(allList);


		
		for (ClothWithColor clothWithColor : allList) {
			System.out.println(clothWithColor);
			
		}
		
		req.setAttribute("allList", allList);
		
		req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);
	}
}
