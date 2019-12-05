package ziozio.controller;

import java.io.IOException;

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


@WebServlet("/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);
	}
}
