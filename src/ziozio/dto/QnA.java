package ziozio.dto;

import java.util.Date;

public class QnA {

	private int account_no; //FK
	private int qna_no; //PK
	private String qna_title;
	private String account_email;
	private String account_nick;
	private String qna_content;
	private Date qna_writtendate;
	@Override
	public String toString() {
		return "QnA [account_no=" + account_no + ", qna_no=" + qna_no + ", qna_title=" + qna_title + ", account_email="
				+ account_email + ", account_nick=" + account_nick + ", qna_content=" + qna_content
				+ ", qna_writtendate=" + qna_writtendate + "]";
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getAccount_email() {
		return account_email;
	}
	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	public String getAccount_nick() {
		return account_nick;
	}
	public void setAccount_nick(String account_nick) {
		this.account_nick = account_nick;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_writtendate() {
		return qna_writtendate;
	}
	public void setQna_writtendate(Date qna_writtendate) {
		this.qna_writtendate = qna_writtendate;
	}
	
	

	
	
}
