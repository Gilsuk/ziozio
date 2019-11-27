package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.BoardFile;
import ziozio.dto.Paging;
import ziozio.dto.QnA;




public interface QnAService {

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
	public QnA getQnAno(HttpServletRequest req);
	
	/**
	 * 상세보기 게시글 조회
	 * 조회수 업데이트
	 * 
	 * @param viewBoard - 상세보기할 boardno를 가진 객체
	 * @return Board - 상세보기할 게시글 조회 결과
	 */
	public QnA view(QnA viewQna);
	
	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 *  첨부파일을 함께 업로드 할 수 있도록 처리
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
//	public BoardFile viewFile(QnA qna);
	


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
	public String getNick(QnA qna);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호를 가진 객체
	 */
	public void delete(QnA qna);
	

	
	
	
}
