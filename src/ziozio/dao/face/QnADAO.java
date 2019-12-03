package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.dto.QnAFile;



public interface QnADAO {

	/**
	 * 게시글 전체 목록 조회
	 * 
	 * @return List - 조회된 게시글 목록
	 */
	public List<QnA> selectAll();
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param Paging - 페이징 정보
	 * @return List - 조회된 게시글 목록
	 */
	public List<QnA> selectAll(Paging paging);
	
	public List<QnA> selectAccount(Account account);
	
	public List<QnA> selectAccount(Account account, Paging paging);
	
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @return int - 총 게시글 수
	 */
	public int selectCntAll();
	
	

	public int selectCntAccount(Account account);
	
	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public QnA selectQnaByQna_no(QnA viewQna);
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void insert(QnA qna);
	
	/**
	 * 다음 게시글 번호 반환
	 * 	게시글 테이블과 첨부파일 테이블에 들어갈 게시글 번호를 미리 추출
	 * 
	 * @return int
	 */
	public int selectQna_no();
	
	/**
	 * 첨부파일 입력
	 * 
	 * @param qnaFile - 업로드 된 첨부파일 내용
	 */
	public void insertFile(QnAFile qnaFile);
	
	/**
	 * 첨부파일 조회
	 * 
	 * @param qna - 첨부파일을 조회할 게시글 객체
	 * @return QnaFile - 조회된 첨부파일
	 */
	public QnAFile selectFile(QnA qna);

	/**
	 * 파일번호로 첨부파일 정보 조회
	 * 
	 * @param fileno - 조회할 첨부파일의 번호
	 * @return QnaFile - 조회된 첨부파일
	 */
	public QnAFile selectByFileno(int fileno);
	
	/**
	 * 게시글 수정 
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	public void update(QnA qna);
	
	/**
	 * id를 이용해 nick을 조회하고 반환한다
	 * 
	 * @param board - id를 가진 객체
	 * @return String - nick
	 */
	public String selectAccount_nickByAccount_Nick(QnA qna);
	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void delete(QnA qna);
	
	/**
	 * 게시글에 첨부된 파일 기록 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void deleteFile(QnA qna);
	

	

	
}
