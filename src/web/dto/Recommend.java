package web.dto;

public class Recommend {
	private String userid;
	private int boardno;
	
	@Override
	public String toString() {
		return "Recommend [userid=" + userid + ", boardno=" + boardno + "]";
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
}
