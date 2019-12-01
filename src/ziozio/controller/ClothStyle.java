package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Style;
import ziozio.service.face.StyleService;
import ziozio.service.impl.StyleServiceImpl;

/**
 * Servlet implementation class ClothProposeControlloer
 */
@WebServlet("/cloth/style")
public class ClothStyle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StyleService styleService = new StyleServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("접속확인");
		List<Style> list = styleService.getAllStyles();
//		System.out.println(list);
				
		req.getRequestDispatcher("/WEB-INF/views/cloth/style.jsp");
		
		}

}
