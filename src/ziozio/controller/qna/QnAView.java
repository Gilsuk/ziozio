package ziozio.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.QnA;
import ziozio.service.face.QnAService;
import ziozio.service.impl.QnAServiceImpl;

@WebServlet("/qnaview")
public class QnAView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qnaService = new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		QnA viewQna = qnaService.getQna_no(req);
	
		viewQna = qnaService.view(viewQna);
		
		req.setAttribute("viewQna", viewQna);
		
		
//		QnaFile qnaFile = qnaService.viewFile(viewQna);
		
		req.setAttribute("nick", qnaService.getNick(viewQna));
		
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/qna/qnaview.jsp")
		.forward(req, resp);
	
	}
	
}
