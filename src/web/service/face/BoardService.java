package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Board;
import web.dto.BoardFile;
import web.dto.Comment;
import web.dto.Recommend;

public interface BoardService {

	/**
	 * 게시글 목록 조회
	 *  
	 * @return List - 게시글 목록
	 */
	public List getList();
	
	/**
	 * 페이징 정보를 활용하여 보여질 게시글 목록만 조회
	 *  
	 * @param Paging - 페이징 정보
	 * @return List - 게시글 목록
	 */
	public List getList(Paging paging);
	
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 요청 파라미터 게시글 번호 파싱
	 * 
	 * @param req - 요청 정보 객체
	 * @return Board - 게시글 번호를 가진 객체
	 */
	public Board getBoardno(HttpServletRequest req);
	
	/**
	 * 상세보기 게시글 조회
	 * 조회수 업데이트
	 * 
	 * @param viewBoard - 상세보기할 boardno를 가진 객체
	 * @return Board - 상세보기할 게시글 조회 결과
	 */
	public Board view(Board viewBoard);
	
	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  [ 예정 ] 첨부파일을 함께 업로드 할 수 있도록 처리
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * 
	 */
	public void write(HttpServletRequest req);
	
	/**
	 * 첨부파일 얻기
	 * 
	 * @param board - 첨부파일을 조회할 게시글 번호 객체
	 * @return BoardFile - 게시글에 첨부된 파일 정보
	 */
	public BoardFile viewFile(Board board);
	
	/**
	 * 글 작성자인지 판단하기
	 * 
	 * @param req - 요청 정보 객체
	 * @return boolean - true : 로그인한 사람이 글 작성자
	 */
	public boolean checkId(HttpServletRequest req);

	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	/**
	 * ID를 통해 닉네임얻기
	 * 
	 * @param board - id를 가진 board 객체
	 * @return String - 닉네임
	 */
	public String getNick(Board board);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호를 가진 객체
	 */
	public void delete(Board board);
	
	/**
	 * 게시글 추천 상태 조회
	 * 
	 * @param recommend - 추천 상태 체크 객체
	 * @return boolean - true:추천했음, false:추천하지않았음
	 */
	public boolean isRecommend(Recommend recommend);
	
	/**
	 * 추천 정보 파라미터 얻기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Recommend - 추천 정보 객체
	 */
	public Recommend getRecommend(HttpServletRequest req);
	
	/**
	 * 추천 토글
	 * 
	 * @param recommend - 추천 정보 객체
	 * @return boolean - true:추천 성공, false:추천취소 성공
	 */
	public boolean recommend(Recommend recommend);
	
	/**
	 * 게시글의 총 추천 수 구하기
	 * 
	 * @param board - 해당 게시글
	 * @return int - 총 추천 수
	 */
	public int getTotalCntRecommend(Recommend recommend);
	
	/**
	 * 댓글 전달파라미터 꺼내기
	 */
	public Comment getComment(HttpServletRequest req);
	
	/**
	 * 댓글 입력
	 * 
	 * @param comment - 삽입될 댓글
	 */
	public void insertComment(Comment comment);
	
	/**
	 * 댓글 리스트
	 * 
	 * @param board - 댓글이 조회될 게시글
	 * @return List - 댓글 리스트
	 */
	public List getCommentList(Board board);
	
	/**
	 * 댓글 삭제
	 *  
	 * @param comment - 삭제할 댓글
	 * @return boolean - 삭제 성공 여부
	 */
	public boolean deleteComment(Comment comment);
	
}














