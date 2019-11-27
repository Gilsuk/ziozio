package web.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.Paging;
import web.dao.face.BoardDao;
import web.dao.face.CommentDao;
import web.dao.face.RecommendDao;
import web.dao.impl.BoardDaoImpl;
import web.dao.impl.CommentDaoImpl;
import web.dao.impl.RecommendDaoImpl;
import web.dto.Board;
import web.dto.BoardFile;
import web.dto.Comment;
import web.dto.Recommend;
import web.service.face.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();
	private RecommendDao recommendDao = new RecommendDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();

	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	@Override
	public List getList(Paging paging) {
		return boardDao.selectAll(paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//		System.out.println("curPage : " + curPage);
		
		
		String search = null;
		param = req.getParameter("search");
		if (param != null && !"".equals(param)) {
			search = param;
		}
		
		int category = 0;
		param = req.getParameter("category");
		if( param!=null && !"".equals(param) ) {
			category = Integer.parseInt(req.getParameter("category"));
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = boardDao.selectCntAll(search, category);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		paging.setSearch(search);
		paging.setCategory(category);
		
		return paging;
	}
	
	@Override
	public Board getBoardno(HttpServletRequest req) {
		
		//요청파라미터 boardno를 파싱한다
		String param = req.getParameter("boardno");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//게시글 번호를 DTO에 넣기
		Board board = new Board();
		board.setBoardno(boardno);
		
		return board;
	}
	
	@Override
	public Board view(Board viewBoard) {
		
		//게시글 조회수 +1
		boardDao.updateHit(viewBoard);
		
		//게시글 조회 반환
		return boardDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void write(HttpServletRequest req) {
		
		Board board = null;
		BoardFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) { //multipart/form-data 형식인지 검사
			System.out.println("[ERROR] multipart/form-data 형식이 아님");
			return;
			
		}
		
		
		//파일업로드를 사용하고 있을 경우
		board = new Board();

		//디스크팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//메모리처리 사이즈
		factory.setSizeThreshold(1 * 1024 * 1024); //1MB

		//임시 저장소
		File repository=new File(req.getServletContext().getRealPath("tmp"));
		factory.setRepository(repository);
		
		//업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//용량 제한 설정 : 10MB
		upload.setFileSizeMax(10 * 1024 * 1024);
		
		//form-data 추출 
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//파싱된 데이터 처리 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//요청정보 처리
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			// 빈 파일 처리
			if( item.getSize() <= 0 )	continue;
			
			// form data 처리
			if( item.isFormField() ) {
				
				try {
					
					//제목 처리
					if( "title".equals( item.getFieldName() ) ) {
						board.setTitle( item.getString("utf-8") );
					}
					
					//본문 처리
					if( "content".equals( item.getFieldName() ) ) {
						board.setContent( item.getString("utf-8") );
					}
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//작성자id 처리
				board.setId((String) req.getSession().getAttribute("userid"));
				
			} else { //파일 처리
				UUID uuid = UUID.randomUUID();
				String u = uuid.toString().split("-")[4];
				
				//로컬 저장소 파일
				String stored = item.getName() + "_" + u;
				File up = new File(
					req.getServletContext().getRealPath("upload")
					, stored);
				
				//첨부파일 정보 객체
				boardFile = new BoardFile();
				boardFile.setOriginName(item.getName());
				boardFile.setStoredName(stored);
				boardFile.setFilesize(item.getSize());
				
				try {
					// 실제 업로드
					item.write(up);
					
					// 임시 파일 삭제
					item.delete();
					
				} catch (Exception e) {
					e.printStackTrace();
				} // try end
			} //if end
		} //while end
		

		//게시글 번호 생성
		int boardno = boardDao.selectBoardno();
		
		//게시글 정보가 없을 경우 처리
		if(board != null) {
			board.setBoardno(boardno); //게시글 번호 입력
			
			//게시글 제목 없을 경우 처리
			if(board.getTitle()==null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");
			}

			boardDao.insert(board); //게시글 삽입
		}
		
		//첨부파일 정보가 없을 경우 처리
		if(boardFile != null) {
			boardFile.setBoardno(boardno); //첨부파일에 게시글 번호 입력
			
			boardDao.insertFile(boardFile); //첨부파일 정보 삽입
		}
		
	}

	@Override
	public BoardFile viewFile(Board board) {
		return boardDao.selectFile(board);
	}
	
	@Override
	public boolean checkId(HttpServletRequest req) {
		
		//로그인한 세션 ID 얻기
		String loginId = (String) req.getSession().getAttribute("userid");

		//작성한 게시글 번호 얻기
		Board board = getBoardno(req);
		
		//게시글 얻어오기
		board = boardDao.selectBoardByBoardno(board);

		//게시글의 작성자와 로그인 아이디 비교
		if( !loginId.equals(board.getId()) ) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void update(HttpServletRequest req) {
		Board board = null;
		BoardFile boardFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없을 경우
			board = new Board();
			
			board.setTitle(req.getParameter("title"));
			board.setId((String) req.getSession().getAttribute("userid"));
			board.setContent(req.getParameter("content"));
			
		} else {
			//파일업로드를 사용하고 있을 경우
			board = new Board();

			//디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//임시 저장소
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					try {
						if( "boardno".equals( item.getFieldName() ) ) {
							board.setBoardno( Integer.parseInt(item.getString()) );
						}
	
						if( "title".equals( item.getFieldName() ) ) {
							board.setTitle( item.getString("utf-8") ); 
						}
						if( "content".equals( item.getFieldName() ) ) {
							board.setContent( item.getString("utf-8") );
						}
						
						board.setId((String) req.getSession().getAttribute("writer"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
					String u = uuid.toString().split("-")[4];

					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					boardFile = new BoardFile();
					boardFile.setOriginName(item.getName());
					boardFile.setStoredName(stored);
					boardFile.setFilesize(item.getSize());
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		

//		System.out.println(board);
//		System.out.println(boardFile);
		
		if(board != null) {
			boardDao.update(board);
		}
		
		if(boardFile != null) {
			boardFile.setBoardno(board.getBoardno());
			boardDao.insertFile(boardFile);
		}
	}
	
	@Override
	public String getNick(Board board) {
		return boardDao.selectNickByUserid(board);
	}
	

	@Override
	public void delete(Board board) {
		
		boardDao.deleteFile(board);
		
		boardDao.delete(board);
		
	}
	
	@Override
	public boolean isRecommend(Recommend recommend) {
		int cnt = recommendDao.selectCntRecommend(recommend);
		
		if(cnt > 0) { //추천했음
			return true;
			
		} else { //추천하지 않았음
			return false;
			
		}
	}

	@Override
	public Recommend getRecommend(HttpServletRequest req) {
		
		//전달파라미터 파싱
		int boardno = 0;
		String param = req.getParameter("boardno");
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//로그인한 아이디
		String userid = (String) req.getSession().getAttribute("userid");
		
		Recommend recommend = new Recommend();
		recommend.setBoardno(boardno);
		recommend.setUserid(userid);
		
		return recommend;
	}
	
	@Override
	public boolean recommend(Recommend recommend) {
		if( isRecommend(recommend) ) { //추천한 상태
			recommendDao.deleteRecommend(recommend);
			
			return false;
			
		} else { //추천하지 않은 상태
			recommendDao.insertRecommend(recommend);
			
			return true;
			
		}
		
	}
	
	@Override
	public int getTotalCntRecommend(Recommend recommend) {
		return recommendDao.selectTotalCntRecommend(recommend);
	}
	
	@Override
	public Comment getComment(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String boardNo = (String) req.getParameter("boardNo");
		String userid = (String) req.getParameter("userid");
		String content = (String) req.getParameter("content");
		
		Comment comment = new Comment();
		comment.setBoardNo( Integer.parseInt(boardNo) );
		comment.setUserid(userid);
		comment.setContent(content);
		
		return comment;
	}
	
	@Override
	public void insertComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public List getCommentList(Board board) {
		return commentDao.selectComment(board);
	}

	@Override
	public boolean deleteComment(Comment comment) {
		commentDao.deleteComment(comment); 
		
		if( commentDao.countComment(comment) > 0 ) {
			return false;
		} else {
			return true;
		}
	}
	
}



