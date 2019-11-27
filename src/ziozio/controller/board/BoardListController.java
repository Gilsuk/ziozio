package ziozio.controller.board;
//컨트롤러는 무조건 서블릿으로 만든다~

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Paging;
import ziozio.service.face.BoardService;
import ziozio.service.impl.BoardServiceImpl;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//요청파라미터에서 curPage를 구하고 Paging 객체 반환
		Paging paging = boardService.getPaging(req);
		System.out.println("BoardListController - " + paging);

		//Paging 객체를 MODEL값으로 지정
		req.setAttribute("paging", paging);
		
		//게시글 목록 조회
		List list = boardService.getList(paging);

		//게시글 목록을 MODEL값으로 지정
		req.setAttribute("list", list);
		req.setAttribute("search", paging.getSearch());
		req.setAttribute("category", paging.getCategory());

		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp")
		.forward(req, resp);
		
	}
}