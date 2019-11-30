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

/**
 * Servlet implementation class QnADelete
 */
@WebServlet("/qnadelete")
public class QnADelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qnaService = new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		QnA qna = qnaService.getQna_no(req);

		qnaService.delete(qna);

		//목록으로 리다이렉트
		resp.sendRedirect("/qnalist");	
	
	}
	
}
