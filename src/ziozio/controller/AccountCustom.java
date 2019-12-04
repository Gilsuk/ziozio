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
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.GenderClothService;


@WebServlet("/account/custom")
public class AccountCustom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClothService<Character, Cloth> clothService = new GenderClothService();
		AccountService accountService = AccountServiceImpl.getInstance();


		try {
			Account account = accountService.getLoggedInAccount(req);

			List<Cloth> topList = clothService.getClothes(account.getAccount_gender(), ClothCategory.TOP);
			List<Cloth> bottomList = clothService.getClothes(account.getAccount_gender(), ClothCategory.BOTTOM);
			req.setAttribute("toplist", topList);
			req.setAttribute("bottomlist", bottomList);
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/custom.jsp").forward(req,resp);
		} catch (AccountNotFountException e) {
			resp.sendRedirect("/account/login");
		}
		
		
	}
	
}
