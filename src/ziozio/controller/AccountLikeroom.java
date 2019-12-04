package ziozio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.impl.AccountLibraryClothService;
import ziozio.service.impl.AccountServiceImpl;


@WebServlet("/account/likeroom")
public class AccountLikeroom extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/mypage/likeroom.jsp").forward(req,resp);
		
	}
	
}
