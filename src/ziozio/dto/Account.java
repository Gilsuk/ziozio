package ziozio.dto;

import java.util.Date;

import ziozio.utils.param.checker.EmailParamChecker;
import ziozio.utils.param.checker.GenderParamChecker;
import ziozio.utils.param.exception.InvalidEmailParamException;
import ziozio.utils.param.exception.InvalidGenderParamException;

public class Account implements DTO {

	private int account_no;
	private String account_email;
	private String account_nick;
	private char account_gender;
	private Date account_signed_date;
	private boolean account_verified;
	private int account_grade_code;
	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", account_email=" + account_email + ", account_nick="
				+ account_nick + ", account_gender=" + account_gender + ", account_signed_date=" + account_signed_date
				+ ", account_grade_code=" + account_grade_code + "]";
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
	public void setAccount_email(String account_email) throws InvalidEmailParamException {
		this.account_email = new EmailParamChecker(account_email).check();
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
	public void setAccount_gender(char account_gender) throws InvalidGenderParamException {
		this.account_gender = new GenderParamChecker(account_gender).check();
	}
	public Date getAccount_signed_date() {
		return account_signed_date;
	}
	public void setAccount_signed_date(Date account_signed_date) {
		this.account_signed_date = account_signed_date;
	}
	public boolean isAccount_verified() {
		return account_verified;
	}
	public void setAccount_verified(boolean account_verified) {
		this.account_verified = account_verified;
	}
	public int getAccount_grade_code() {
		return account_grade_code;
	}
	public void setAccount_grade_code(int account_grade_code) {
		this.account_grade_code = account_grade_code;
	}
}