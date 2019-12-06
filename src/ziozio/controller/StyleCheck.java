package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.StyleService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.StyleServiceImpl;


@WebServlet("/stylecheck")
public class StyleCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StyleService styleService = StyleServiceImpl.getInstance();
	private AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Location defaultLocation = locationService.getDefaultLocation();
//		WeatherInfo weather = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
//		WeatherInfo temperature = weatherInfoService.getCurrentWeatherInfo(defaultLocation);
//		req.setAttribute("defaultLocation", defaultLocation);
//		req.setAttribute("weather", weather);
//		req.setAttribute("temperature", temperature);
		

		try {
			List<Style> userStyles = styleService.getAccountStyles(req);
			req.setAttribute("userStyles", userStyles);
		} catch (AccountNotFountException e) {
			resp.sendRedirect("/account/restoresession");
		}
		List<Style> allStyles = styleService.getAllStyles();
		req.setAttribute("allStyles", allStyles);
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/stylecheck.jsp").forward(req,resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		List<Style> styles = styleService.getSelectedStyles(req);

		try {
			Account account = accountService.getLoggedInAccount(req);
			styleService.addStylesToAccount(account, styles);
			resp.sendRedirect("/stylecheck");

		} catch (AccountNotFountException e) {
			resp.sendRedirect("/account/restoresession");
		}


	}
}
