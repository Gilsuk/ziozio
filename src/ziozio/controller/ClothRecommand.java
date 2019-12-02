package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Style;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.face.StyleService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.StyleClothService;
import ziozio.service.impl.StyleServiceImpl;

/**
 * Servlet implementation class ClothProposeControlloer
 */
@WebServlet("/cloth/recommand")
public class ClothRecommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StyleService styleService = new StyleServiceImpl();
	private AccountService accountService = AccountServiceImpl.getInstance();
//	private ClothService<Style, Cloth> clothService = new StyleClothService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println("접속확인");
		
//		List<Style> list = styleService.getAllStyles();
		
//		System.out.println(list); // 전체 스타일 목록 확인
		
		

//		List<Style> styles = styleService.getStyles(req);
//		
//		for (int i = 0; i < array.length; i++) {
//			
//		}
//
//		List<Cloth> clothesbystyle = clothService.getClothes(styleList.get(1));
//		List<Cloth> clothesbyaccount = clothService.getClothes(styleList.get(1));
//		
//		
//		
//		req.setAttribute("clothes", clothes);
//		

		req.getRequestDispatcher("/WEB-INF/views/cloth/style.jsp").forward(req, resp);;

	}

}
