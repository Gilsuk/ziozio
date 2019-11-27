package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.face.RecommendDao;
import web.dto.Recommend;
import ziozio.utils.db.oracle.DBConn;

public class RecommendDaoImpl implements RecommendDao {
	
	//DB관련 객체
	private Connection conn = null; 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntRecommend(Recommend recommend) {

		conn = DBConn.getConnection();

		String sql = "";
		sql += "SELECT count(*) FROM recommend";
		sql += " WHERE boardno = ?";
		sql += " 	AND userid = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		int cnt = -1;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getBoardno());
			ps.setString(2, recommend.getUserid());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	@Override
	public void insertRecommend(Recommend recommend) {

		conn = DBConn.getConnection();

		String sql = "";
		sql += "INSERT INTO recommend";
		sql += " VALUES ( ?, ? )";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, recommend.getUserid());
			ps.setInt(2, recommend.getBoardno());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteRecommend(Recommend recommend) {

		conn = DBConn.getConnection();

		String sql = "";
		sql += "DELETE recommend";
		sql += " WHERE userid = ?";
		sql += " 	AND boardno = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, recommend.getUserid());
			ps.setInt(2, recommend.getBoardno());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int selectTotalCntRecommend(Recommend recommend) {

		conn = DBConn.getConnection();

		String sql = "SELECT COUNT(*) FROM recommend"
				+ " WHERE boardno=?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recommend.getBoardno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

}









