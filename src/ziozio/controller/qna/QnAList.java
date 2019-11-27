package ziozio.controller.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Paging;
import ziozio.service.face.QnAService;
import ziozio.service.impl.QnAServiceImpl;

@WebServlet("/qnalist")
public class QnAList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private QnAService qnaService = new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = qnaService.getPaging(req);
		System.out.println("QnAList - " + paging);
		
		req.setAttribute("paging", paging);
		
		List list = qnaService.getList(paging);
		
		req.setAttribute("list", list);
		
		
		req.getRequestDispatcher("/WEB-INF/views/qna/qnalist.jsp")
			.forward(req, resp);
	
	}
	

}
