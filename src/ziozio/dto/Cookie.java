package ziozio.dto;

import java.util.Date;

public class Cookie implements DTO {
	
	private String cookie_id;
	private String cookie_ip;
	private int account_no;
	private Date cookie_last_login;
	@Override
	public String toString() {
		return "Cookie [cookie_id=" + cookie_id + ", cookie_ip=" + cookie_ip + ", account_no=" + account_no
				+ ", cookie_last_login=" + cookie_last_login + "]";
	}
	public String getCookie_id() {
		return cookie_id;
	}
	public void setCookie_id(String cookie_id) {
		this.cookie_id = cookie_id;
	}
	public String getCookie_ip() {
		return cookie_ip;
	}
	public void setCookie_ip(String cookie_ip) {
		this.cookie_ip = cookie_ip;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public Date getCookie_last_login() {
		return cookie_last_login;
	}
	public void setCookie_last_login(Date cookie_last_login) {
		this.cookie_last_login = cookie_last_login;
	}
}
