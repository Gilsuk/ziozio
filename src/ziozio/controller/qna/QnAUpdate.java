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


@WebServlet("/qnaupdate")
public class QnAUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qnaService= new QnAServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		if( !qnaService.checkNick(req) ) {
			resp.sendRedirect("/qnalist");
			return;
		}
	
		QnA viewQna = qnaService.getQna_no(req);
		
		viewQna = qnaService.view(viewQna);
		
		req.setAttribute("viewQna", viewQna);
		
//		QnAFile qnaFile = qnaService.viewFile(viewQna);
//		req.setAttribute("qnaFile", qnaFile);
		
		req.getRequestDispatcher("/WEB-INF/views/qna/qnaupdate.jsp").forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		qnaService.update(req);

		resp.sendRedirect("/qnalist");
	
	}
	
}
