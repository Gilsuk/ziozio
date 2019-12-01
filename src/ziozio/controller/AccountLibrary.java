package ziozio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.Paging;
import ziozio.service.face.ClothService;
import ziozio.service.impl.ClothServiceImpl;


@WebServlet("/account/library")
public class AccountLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private ClothService clothService = new ClothServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//요청파라미터에서 curPage를 구하고 Paging 객체 반환

		Paging paging = clothService.getPaging(req);
		
//		System.out.println("BoardListController - " + paging);

		//Paging 객체를 MODEL값으로 지정

		req.setAttribute("paging", paging);
		
		//사진 목록 조회
//		List list = clothService.getClothesByAccountLibrary(account, category, paging);

		//게시글 목록을 MODEL값으로 지정
//		req.setAttribute("list", list);		
		req.setAttribute("search", paging.getSearch());
		req.setAttribute("category", paging.getCategory());
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/library.jsp").forward(req,resp);
		
	
	}
	
}
