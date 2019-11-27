package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Board;
import ziozio.dto.BoardFile;
import ziozio.dto.Paging;

public interface BoardDao { //face 이니까 interface

	/**
	 * 게시글 전체 목록 조회
	 * 
	 * @return List - 조회된 게시글 목록
	 */
	public List selectAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param Paging - 페이징 정보
	 * @return List - 조회된 게시글 목록
	 */
	public List selectAll(Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @return int - 총 게시글 수
	 */
	public int selectCntAll(String search, int category);
	
	/**
	 * 조회되는 게시글의 조회수 +1
	 * 
	 * @param viewBoard - 조회 대상
	 */
	public void updateHit(Board viewBoard);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public Board selectBoardByBoardno(Board viewBoard);
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void insert(Board board);
	
	
	/**
	 * 다음 게시글 번호 반환
	 * 	게시글 테이블과 첨부파일 테이블에 들어갈 게시글 번호를 미리 추출
	 * 
	 * @return int
	 */
	public int selectBoardno();
	
	/**
	 * 첨부파일 입력
	 * 
	 * @param boardFile - 업로드 된 첨부파일 내용
	 */
	public void insertFile(BoardFile boardFile);
	
	/**
	 * 첨부파일 조회
	 * 
	 * @param board - 첨부파일을 조회할 게시글 객체
	 * @return BoardFile - 조회된 첨부파일
	 */
	public BoardFile selectFile(Board board);

	/**
	 * 파일번호로 첨부파일 정보 조회
	 * 
	 * @param fileno - 조회할 첨부파일의 번호
	 * @return BoardFile - 조회된 첨부파일
	 */
	public BoardFile selectByFileno(int fileno);
	
	/**
	 * 게시글 수정 
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	public void update(Board board);
	
	/**
	 * id를 이용해 nick을 조회하고 반환한다
	 * 
	 * @param board - id를 가진 객체
	 * @return String - nick
	 */
	public String selectNickByUserid(Board board);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void delete(Board board);
	
	/**
	 * 게시글에 첨부된 파일 기록 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void deleteFile(Board board);
	
	
	
	
}
