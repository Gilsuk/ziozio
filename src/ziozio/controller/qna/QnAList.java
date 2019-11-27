package ziozio.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.QnAService;
import ziozio.service.impl.QnAServiceImpl;

@WebServlet("/qnalist")
public class QnAList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private QnAService qnaService = new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Paging paing = qnaService.getPaging(req);
//		
//		req.setAttribute("paging", paging);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/qna/qnalist.jsp")
			.forward(req, resp);
	
	}
	

}
