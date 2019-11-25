package ziozio.dto;

import java.util.Date;

public class Account implements DTO {

	private int account_no;
	private String account_email;
	private String account_nick;
	private char account_gender;
	private Date account_signed_date;
	private int account_grade;
	@Override
	public String toString() {
		return "User [account_no=" + account_no + ", account_email=" + account_email + ", account_nick=" + account_nick
				+ ", account_gender=" + account_gender + ", account_signed_date=" + account_signed_date
				+ ", account_grade=" + account_grade + "]";
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
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
	public char getAccount_gender() {
		return account_gender;
	}
	public void setAccount_gender(char account_gender) {
		this.account_gender = account_gender;
	}
	public Date getAccount_signed_date() {
		return account_signed_date;
	}
	public void setAccount_signed_date(Date account_signed_date) {
		this.account_signed_date = account_signed_date;
	}
	public int getAccount_grade() {
		return account_grade;
	}
	public void setAccount_grade(int account_grade) {
		this.account_grade = account_grade;
	}
}