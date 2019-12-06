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
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.ClothService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.GenderClothService;


@WebServlet("/cloth/select/ok")
public class ClothSelectOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClothService<Character> clothService = GenderClothService.getInstance();
	AccountService accountService = AccountServiceImpl.getInstance();
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
			
		req.getRequestDispatcher("/WEB-INF/views/mypage/clothselectok.jsp").forward(req,resp);

	
	
	}


}
