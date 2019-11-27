package ziozio.dto;

import java.util.Date;

public class QnADTO {

	private int account_qnano;
	private String account_title;
	private String account_email;
	private String account_content;
	private Date account_writtendate;
	
	
	@Override
	public String toString() {
		return "QnADTO [account_qnano=" + account_qnano + ", account_title=" + account_title + ", account_email="
				+ account_email + ", account_content=" + account_content + ", account_writtendate="
				+ account_writtendate + "]";
	}


	public int getAccount_qnano() {
		return account_qnano;
	}


	public void setAccount_qnano(int account_qnano) {
		this.account_qnano = account_qnano;
	}


	public String getAccount_title() {
		return account_title;
	}


	public void setAccount_title(String account_title) {
		this.account_title = account_title;
	}


	public String getAccount_email() {
		return account_email;
	}


	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}


	public String getAccount_content() {
		return account_content;
	}


	public void setAccount_content(String account_content) {
		this.account_content = account_content;
	}


	public Date getAccount_writtendate() {
		return account_writtendate;
	}


	public void setAccount_writtendate(Date account_writtendate) {
		this.account_writtendate = account_writtendate;
	}
	
	
	
	
}
