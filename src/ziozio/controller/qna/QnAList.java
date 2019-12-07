package ziozio.controller.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Account;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.QnAService;
import ziozio.service.impl.AccountServiceImpl;
import ziozio.service.impl.QnAServiceImpl;

@WebServlet("/qnalist")
public class QnAList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private QnAService qnaService = new QnAServiceImpl();
	private AccountService accountService = AccountServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Account account = null;
		try {
			account = accountService.getLoggedInAccount(req);
		} catch (AccountNotFountException e) {
			e.printStackTrace();
		}
		
		Paging pagingAll = qnaService.getPaging(req);
		Paging pagingAccount = qnaService.getPaging(account, req);
		
		List<QnA> listAll = qnaService.getListAll(pagingAll);
		List<QnA> listAccount = qnaService.getListAccount(account, pagingAccount);
		
		req.setAttribute("listAll", listAll);
		req.setAttribute("listAccount", listAccount);

		
		req.getRequestDispatcher("/WEB-INF/views/qna/qnalist.jsp")
			.forward(req, resp);
	
	}
	

}
