package ziozio.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.QnAService;
import ziozio.service.impl.QnAServiceImpl;

/**
 * Servlet implementation class QnAWrite
 */
@WebServlet("/qnawrite")
public class QnAWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private QnAService qnaService = new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/qna/qnawrite.jsp")
			.forward(req, resp);	
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		qnaService.write(req);
		
		//목록으로 리다이렉션
		resp.sendRedirect("/qnalist");	
	
	
	}
	
}
