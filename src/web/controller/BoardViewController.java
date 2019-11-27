package web.controller;
//컨트롤러는 무조건 서블릿으로 만든다~


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.dto.BoardFile;
import web.dto.Comment;
import web.dto.Recommend;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//게시글 번호 파싱
		Board viewBoard = boardService.getBoardno(req);

		//게시글 조회
		viewBoard = boardService.view(viewBoard);

		//MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);




		//첨부파일 전달
		BoardFile boardFile = boardService.viewFile(viewBoard);
		req.setAttribute("boardFile", boardFile);




		//닉네임 전달
		req.setAttribute("nick", boardService.getNick(viewBoard));




		//추천 상태 전달
		Recommend recommend = new Recommend();
		recommend.setBoardno(viewBoard.getBoardno()); //게시글 번호
		recommend.setUserid((String)req.getSession().getAttribute("userid")); //로그인한 아이디

		boolean isRecommend = boardService.isRecommend(recommend);
		req.setAttribute("isRecommend", isRecommend);
		

		//댓글 리스트 전달
		Comment comment = new Comment();
		List<Comment> commentList = boardService.getCommentList(viewBoard);
		req.setAttribute("commentList", commentList);




		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/view.jsp")
		.forward(req, resp);

	}
}






