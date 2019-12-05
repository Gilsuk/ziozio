package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Location;
import ziozio.service.face.LocationService;
import ziozio.service.impl.LocationServiceImpl;


@WebServlet("/location_get")
public class Location_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationService locationService = LocationServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println(req.getParameter("latitude"));
		
		Location location = locationService.getLocation(req);
		
		System.out.println(location);
	
		
		
//		System.out.println(req.getParameter("location1"));
		
		
	}
	


}
