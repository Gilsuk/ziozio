package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ziozio.dao.face.BoardDao;
import ziozio.dto.Board;
import ziozio.dto.BoardFile;
import ziozio.dto.Paging;
import ziozio.utils.db.oracle.DBConn;

public class BoardDaoImpl implements BoardDao {

	private Connection conn = null;

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List selectAll() {

		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	boardno";
		sql += "	, title";
		sql += "	, id";
		sql += "	, content";
		sql += "	, hit";
		sql += "	, writtendate";
		sql += " FROM board";
		sql += " ORDER BY boardno DESC";

		// 최종 결과를 저장할 List
		List list = new ArrayList();

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWrittendate(rs.getDate("writtendate"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return list;
	}

	@Override
	public List selectAll(Paging paging) {

		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "            boardno, title, id,";
		sql += "            content, hit, writtendate";
		sql += "        FROM board";
		if (paging.getSearch() != null) {
			sql += " WHERE";
			if (paging.getCategory() == 1) {
				sql += " title LIKE '%' || ? || '%'";
			} else if (paging.getCategory() == 2) {
				sql += " content LIKE '%' || ? || '%'";
			} else if (paging.getCategory() == 3) {
				sql += " title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%'";
			}
		}
		sql += "        ORDER BY boardno DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";

		// 최종 결과를 저장할 List
		List list = new ArrayList();

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			if (paging.getSearch() != null) {
				
				if (paging.getCategory() == 1 || paging.getCategory() == 2) {
					ps.setString(1, paging.getSearch());
					ps.setInt(2, paging.getStartNo());
					ps.setInt(3, paging.getEndNo());
				}
				if (paging.getCategory() == 3) {
					ps.setString(1, paging.getSearch());
					ps.setString(2, paging.getSearch());
					ps.setInt(3, paging.getStartNo());
					ps.setInt(4, paging.getEndNo());
				}
			} else {
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
			}
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWrittendate(rs.getDate("writtendate"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return list;
	}

	@Override
	public int selectCntAll(String search, int category) {

		conn = DBConn.getConnection(); // DB 연결

		// 수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM board";
		if (search != null) {
			sql += " WHERE";
			if (category == 1) {
				sql += " title LIKE '%' || ? || '%'";
			} else if (category == 2) {
				sql += " content LIKE '%' || ? || '%'";
			} else if (category == 3) {
				sql += " title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%'";
			}
		}

		// 최종 결과 변수
		int cnt = 0;

		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			if (search != null) {
				ps.setString(1, search);
				
				if (category == 3) {
					ps.setString(2, search);
				}
			}

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// SQL 수행 결과 처리
			while (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return cnt;
	}

	@Override
	public void updateHit(Board viewBoard) {

		conn = DBConn.getConnection(); // DB 연결

		// 게시글 조회수 증가 쿼리
		String sql = "";
		sql += "UPDATE board";
		sql += " SET hit = hit + 1";
		sql += " WHERE boardno = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, viewBoard.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Board selectBoardByBoardno(Board viewBoard) {
System.out.println(viewBoard);
		conn = DBConn.getConnection(); // DB 연결

		// 게시글 조회쿼리
		String sql = "";
		sql += "SELECT ";
		sql += "	boardno";
		sql += "	, title";
		sql += "	, id";
		sql += "	, content";
		sql += "	, hit";
		sql += "	, writtendate";
		sql += " FROM board";
		sql += " WHERE boardno = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, viewBoard.getBoardno());

			rs = ps.executeQuery();

			while (rs.next()) {

				viewBoard.setBoardno(rs.getInt("boardno"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setId(rs.getString("id"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setWrittendate(rs.getDate("writtendate"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return viewBoard;

	}

	@Override
	public void insert(Board board) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO board(BOARDNO,TITLE,ID,CONTENT,HIT) ";
		sql += " VALUES (?, ?, ?, ?, 0)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getId());
			ps.setString(4, board.getContent());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int selectBoardno() {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT board_seq.nextval";
		sql += " FROM dual";

		// 게시글번호
		int boardno = 0;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 결과 담기
			while (rs.next()) {
				boardno = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 게시글 번호 반환
		return boardno;
	}

	@Override
	public void insertFile(BoardFile boardFile) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO boardFile(fileno,boardno,originname,storedname,filesize) ";
		sql += " VALUES (boardfile_seq.nextval, ?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardFile.getBoardno());
			ps.setString(2, boardFile.getOriginName());
			ps.setString(3, boardFile.getStoredName());
			ps.setLong(4, boardFile.getFilesize());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public BoardFile selectFile(Board board) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM boardfile";
		sql += " WHERE boardno = ?";

		BoardFile boardFile = new BoardFile();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

			rs = ps.executeQuery();

			while (rs.next()) {

				boardFile.setFileno(rs.getInt("fileno"));
				boardFile.setBoardno(rs.getInt("boardno"));
				boardFile.setOriginName(rs.getString("originname"));
				boardFile.setStoredName(rs.getString("storedname"));
				boardFile.setFilesize(rs.getLong("filesize"));
				boardFile.setWriteDate(rs.getDate("writedate"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return boardFile;
	}

	@Override
	public BoardFile selectByFileno(int fileno) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM boardfile";
		sql += " WHERE fileno = ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		BoardFile boardFile = new BoardFile();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fileno);

			rs = ps.executeQuery();

			while (rs.next()) {

				boardFile.setFileno(rs.getInt("fileno"));
				boardFile.setBoardno(rs.getInt("boardno"));
				boardFile.setOriginName(rs.getString("originname"));
				boardFile.setStoredName(rs.getString("storedname"));
				boardFile.setFilesize(rs.getLong("filesize"));
				boardFile.setWriteDate(rs.getDate("writedate"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return boardFile;
	}

	@Override
	public void update(Board board) {
//		System.out.println(board);

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE board";
		sql += " SET title = ?,";
		sql += " 	content = ?";
		sql += " WHERE boardno = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String selectNickByUserid(Board board) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT usernick FROM member";
		sql += " WHERE userid = ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		String usernick = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getId());

			rs = ps.executeQuery();

			while (rs.next()) {
				usernick = rs.getString("usernick");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usernick;
	}

	@Override
	public void delete(Board board) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE board";
		sql += " WHERE boardno = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteFile(Board board) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE boardfile";
		sql += " WHERE boardno = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}