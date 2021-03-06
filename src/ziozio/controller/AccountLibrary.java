package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.impl.AccountLibraryClothService;
import ziozio.service.impl.AccountServiceImpl;


@WebServlet("/account/library")
public class AccountLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private ClothService<Account> clothService = AccountLibraryClothService.getInstance();
	private AccountService accountService = AccountServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		// 로그인한 유저를 가져온다.
		// 로그인한 유저가 누구인지 식별하는것은 AccountService가 할 일이다.
		// 현재 해당 메소드가 미구현상태 이므로 null이 반환될 것이다.
		// 때문에 테스트 하려면 임시 객체를 만들 필요가 있다.
		Account account = null;
		try {
			account = accountService.getLoggedInAccount(req);
		} catch (AccountNotFountException e) {
			accountService.loginAndRedirect(req, resp);
			return;
		}

		
		// 로그인한 계정에 맞는 옷장 페이징을 구한다.
		Paging pagingTop = clothService.getPaging(account, ClothCategory.TOP, req);
		Paging pagingBottom = clothService.getPaging(account, ClothCategory.BOTTOM, req);
		Paging pagingOuter = clothService.getPaging(account, ClothCategory.OUTER, req);
		
		// 조회할 옷의 카테고리르 파라미터로 부터 입력 받는다.
//		ClothCategory category = ClothCategory.valueOf(req.getParameter("category"));
		
		// 파라미터로 받은 카테고리로 옷 리스트를 조회할 수 도 있고,
//		List<ClothWithColor> clothList = clothService.getClothes(account, category, paging);
		// 파라미터 받지 않고, 그냥 String 을 떄려박을 수도 있다.
		List<ClothWithColor> topList = clothService.getClothes(account, ClothCategory.TOP, pagingTop);
		List<ClothWithColor> bottomList = clothService.getClothes(account, ClothCategory.BOTTOM, pagingBottom);
		List<ClothWithColor> outerList = clothService.getClothes(account, ClothCategory.OUTER, pagingOuter);
//		for (ClothWithColor clothWithColor : clothListOuter) {
//			System.out.println(clothWithColor);
//			
//		}

		req.setAttribute("topList", topList);
		req.setAttribute("bottomList", bottomList);
		req.setAttribute("outerList", outerList);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/library.jsp").forward(req,resp);
		
	
	}
	
}
