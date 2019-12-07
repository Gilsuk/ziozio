package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ziozio.dao.face.QnADAO;
import ziozio.dto.Account;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.dto.QnAFile;
import ziozio.utils.db.oracle.DBConn;

public class QnADAOImpl implements QnADAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	
	@Override
	public List<QnA> selectAll() {

		conn = DBConn.getConnection(); //DB 연결		
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += " *";
		sql += " FROM account A, qna Q";
		sql += " WHERE A.account_no = Q.account_no";
		sql += " ORDER BY qna_no DESC";
		
		//최종 결과를 저장할 List
		List<QnA> list = new ArrayList<QnA>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("account_nick") );
				qna.setQna_content( rs.getString("qna_content") );
				qna.setQna_writtendate( rs.getDate("writtendate") );
				
				list.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}		

	@Override
	public List<QnA> selectAccount(Account account) {
		conn = DBConn.getConnection(); //DB 연결		
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += " A.account_no";
		sql += " , Q.qna_no";
		sql += " , Q.qna_title";
		sql += " , A.account_nick";
		sql += " , Q.qna_content";
		sql += " , Q.writtendate";
		sql += " FROM account A, qna Q";
		sql += " WHERE A.account_no = Q.account_no AND A.account_no = ?";
		sql += " ORDER BY qna_no DESC";
		
		//최종 결과를 저장할 List
		List<QnA> list = new ArrayList<QnA>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("account_nick") );
				qna.setQna_content( rs.getString("qna_content") );
				qna.setQna_writtendate( rs.getDate("writtendate") );
				
				list.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}
	

	@Override
	public List<QnA> selectAll(Paging paging) {

		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "          A.account_no, Q.qna_no, A.account_nick,  Q.qna_title, Q.qna_writtendate";
		sql += "        FROM account A, qna Q";
		sql += " 		WHERE A.account_no = Q.account_no";
//		if (paging.getSearch() != null) {
//		sql += " AND";
//			if (paging.getCategory() == 1) {
//				sql += " title LIKE '%' || ? || '%'";
//			} else if (paging.getCategory() == 2) {
//				sql += " content LIKE '%' || ? || '%'";
//			} else if (paging.getCategory() == 3) {
//				sql += " title LIKE '%' || ? || '%' OR content LIKE '%' || ? || '%'";
//			}
//		}
		sql += "        ORDER BY qna_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) QNA";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List<QnA> list = new ArrayList<QnA>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
//			ps.setString(1, paging.getSearch());
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("account_nick") );
//				qna.setQna_content( rs.getString("qna_content") );
				qna.setQna_writtendate( rs.getDate("qna_writtendate") );
				
				list.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}


	@Override
	public List<QnA> selectAccount(Account account, Paging paging) {
		conn = DBConn.getConnection(); //DB 연결
		
		// 수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "          Q.account_no, Q.qna_no, A.account_nick,  Q.qna_title, Q.qna_writtendate";
		sql += "        FROM account A, qna Q";
		sql += " 		WHERE A.account_no = Q.account_no AND Q.account_no = ?";
		sql += "        ORDER BY qna_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) QNA";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List<QnA> list = new ArrayList<QnA>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			

			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("account_nick") );
//				qna.setQna_content( rs.getString("qna_content") );
				qna.setQna_writtendate( rs.getDate("qna_writtendate") );
				
				list.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}

	
	@Override
	public int selectCntAll() {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM qna";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}
	
	@Override
	public int selectCntAccount(Account account) {
		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM qna WHERE account_no = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getAccount_no());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}
	
	

	@Override
	public QnA selectQnaByQna_no(QnA viewQna) {

		conn = DBConn.getConnection(); // DB 연결

		// 게시글 조회쿼리
		String sql = "";
		sql += "SELECT ";
		sql += "	A.account_no";
		sql += "	, Q.qna_no";
		sql += "	, Q.qna_title";
		sql += "	, A.account_nick";
		sql += "	, Q.qna_content";
		sql += "	, Q.qna_writtendate";
		sql += " FROM account A, qna Q";
		sql += " WHERE A.account_no = Q.account_no AND qna_no = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, viewQna.getQna_no());

			rs = ps.executeQuery();

			while (rs.next()) {

				viewQna.setQna_no(rs.getInt("qna_no"));
				viewQna.setQna_title(rs.getString("qna_title"));
				viewQna.setAccount_nick(rs.getString("account_nick"));
				viewQna.setQna_content(rs.getString("qna_content"));
				viewQna.setQna_writtendate(rs.getDate("qna_writtendate"));

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

		return viewQna;

	}

	@Override
	public void insert(QnA qna) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO qna(qna_no,qna_title,account_no,qna_content) ";
		sql += " VALUES (?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qna.getQna_no());
			ps.setString(2, qna.getQna_title());
			ps.setInt(3, qna.getAccount_no());
			ps.setString(4, qna.getQna_content());

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
	public int selectQna_no() {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT qna_seq.nextval";
		sql += " FROM dual";

		// 게시글번호
		int qna_no = 0;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 결과 담기
			while (rs.next()) {
				qna_no = rs.getInt(1);
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
		return qna_no;
	}

	@Override
	public void update(QnA qna) {
		
		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE qna";
		sql += " SET qna_title = ?,";
		sql += " 	qna_content = ?";
		sql += " WHERE qna_no = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, qna.getQna_title());
			ps.setString(2, qna.getQna_content());
			ps.setInt(3, qna.getQna_no());

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
	public String selectAccount_nickByAccount_Nick(QnA qna) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT account_nick FROM account, qna";
		sql += " WHERE account.account_no = qna.account_no AND account_nick = ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		String account_nick = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, qna.getAccount_nick());

			rs = ps.executeQuery();

			while (rs.next()) {
				account_nick = rs.getString("account_nick");
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

		return account_nick;
	}

	@Override
	public void delete(QnA qna) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE qna";
		sql += " WHERE qna_no = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qna.getQna_no());

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
	public void deleteFile(QnA qna) {
		
		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE qnafile";
		sql += " WHERE qna_no = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qna.getQna_no());

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
	public void insertFile(QnAFile qnaFile) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO qnaFile(qnafile_no, qna_no, originname, storedname, filesize) ";
		sql += " VALUES (boardfile_seq.nextval, ?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qnaFile.getQna_no());
			ps.setString(2, qnaFile.getOriginName());
			ps.setString(3, qnaFile.getStoredName());
			ps.setLong(4, qnaFile.getFilesize());

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
	public QnAFile selectFile(QnA qna) {

		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM qnafile";
		sql += " WHERE qna_no = ?";

		QnAFile qnaFile = new QnAFile();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qna.getQna_no());

			rs = ps.executeQuery();

			while (rs.next()) {

				qnaFile.setQnafile_no(rs.getInt("qnafile_no"));
				qnaFile.setQna_no(rs.getInt("qna_no"));
				qnaFile.setOriginName(rs.getString("originname"));
				qnaFile.setStoredName(rs.getString("storedname"));
				qnaFile.setFilesize(rs.getLong("filesize"));
				qnaFile.setWriteDate(rs.getDate("writedate"));

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

		return qnaFile;
	}


	@Override
	public QnAFile selectByFileno(int fileno) {
	
		conn = DBConn.getConnection(); // DB 연결

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM qnafile";
		sql += " WHERE qnafile_no = ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		QnAFile qnaFile = new QnAFile();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fileno);

			rs = ps.executeQuery();

			while (rs.next()) {

				qnaFile.setQnafile_no(rs.getInt("qnafile_no"));
				qnaFile.setQna_no(rs.getInt("qna_no"));
				qnaFile.setOriginName(rs.getString("originname"));
				qnaFile.setStoredName(rs.getString("storedname"));
				qnaFile.setFilesize(rs.getLong("filesize"));
				qnaFile.setWriteDate(rs.getDate("writedate"));

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

		return qnaFile;
	}










}
