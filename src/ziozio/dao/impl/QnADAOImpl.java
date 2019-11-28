package ziozio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ziozio.dao.face.QnADAO;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.utils.db.oracle.DBConn;

public class QnADAOImpl implements QnADAO{

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	
	@Override
	public List selectAll() {

		conn = DBConn.getConnection(); //DB 연결		
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += " *";
		sql += " FROM account A, qna Q";
		sql += " WHERE A.account_no = Q.account_no";
		sql += " ORDER BY qna_no DESC";
		
		//최종 결과를 저장할 List
		List list = new ArrayList();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				qna.setAccount_no( rs.getInt("account_no"));
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
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
	public List selectAll(Paging paging) {

		conn = DBConn.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "           account_no, qna_no, qna_title, _qna_nick,"; 
		sql += "            qna_content, qna_writtendate";
		sql += "        FROM qna";
		sql += "		WHERE account.account_no = qna.account_no"; 
		sql += "		AND qna_title LIKE '%'||?||'%'"; 
		sql += "        ORDER BY qna_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) QNA";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//최종 결과를 저장할 List
		List list = new ArrayList();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				QnA qna = new QnA();
				
				qna.setQna_no( rs.getInt("qna_no") );
				qna.setQna_title( rs.getString("qna_title") );
				qna.setAccount_nick( rs.getString("Account_nick") );
				qna.setQna_content( rs.getString("qna_content") );
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QnA selectQnaByQna_no(QnA viewQna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(QnA qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectQna_no() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(QnA qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String selectAccount_nickByAccount_Email(QnA qna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(QnA qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFile(QnA qna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQnaFileList(String names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardList(String names) {
		// TODO Auto-generated method stub
		
	}



}
