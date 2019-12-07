package ziozio.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.dto.Board;
import ziozio.service.face.BoardService;
import ziozio.service.impl.BoardServiceImpl;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인한 사람의 글이 아니면 중단하고 목록으로 리다이렉트
		if( !boardService.checkId(req) ) {
			resp.sendRedirect("/board/list");
			return;
		}
		
		Board board = boardService.getBoardno(req);

		boardService.delete(board);

		//목록으로 리다이렉트
		resp.sendRedirect("/board/list");

	}

}
