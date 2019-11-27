package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Board;
import ziozio.dto.Comment;

public interface CommentDao {
	
	/**
	 * 코멘트 조회 - 코멘트 번호를 rnum을 통해 같이 조회한다
	 * 
	 * @param board - 댓글이 조회될 게시글 
	 * @return List - 조회된 댓글 리스트
	 */
	public List selectComment(Board board);
	
	/**
	 * 코멘트 INSERT
	 * 
	 * @param comment - 삽입될 댓글
	 */
	public void insertComment(Comment comment);

	/**
	 * 댓글 삭제하기
	 * 
	 * @param comment - 삭제할 댓글
	 */
	public void deleteComment(Comment comment);

	/**
	 * 댓글 카운트 - 댓글 존재 여부 확인
	 * 
	 * @param comment - 존재 여부 체크 대상 댓글
	 * @return int - 댓글 갯수
	 */
	public int countComment(Comment comment);

}
