package ziozio.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qnaview")
public class QnAView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/qna/qnaview.jsp")
		.forward(req, resp);
	
	}
	
}
