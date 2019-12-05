package ziozio.controller.clothLook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.face.StyleService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.GenderClothService;
import ziozio.service.impl.StyleServiceImpl;

@WebServlet("/gender/cloth")
public class GenderCloth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClothService<Character> clothService = GenderClothService.getInstance();
	AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		StyleService styleService = new StyleServiceImpl();

		List<Style> allStyles = styleService.getAllStyles();
		req.setAttribute("allStyles", allStyles);
	
		try {
			Account account = accountService.getLoggedInAccount(req);

			List<ClothWithColor> topList = clothService.getClothes(account.getAccount_gender(), ClothCategory.TOP);
			List<ClothWithColor> bottomList = clothService.getClothes(account.getAccount_gender(), ClothCategory.BOTTOM);
			List<ClothWithColor> outerList = clothService.getClothes(account.getAccount_gender(), ClothCategory.OUTER);
			req.setAttribute("topList", topList);
			req.setAttribute("bottomList", bottomList);
			req.setAttribute("outerList", outerList);
			
			req.getRequestDispatcher("/WEB-INF/views/clothlook/gendercloth.jsp").forward(req,resp);
		} catch (AccountNotFountException e) {
			resp.sendRedirect("/account/login");
		}
	}
	
}
