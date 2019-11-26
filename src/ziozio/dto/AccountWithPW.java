package ziozio.dto;

import ziozio.utils.hash.SHA256;

public class AccountWithPW extends Account {

	private String account_pw;

	public String getAccount_pw() {
		return account_pw;
	}
	public void setAccount_pw(String account_pw) {
		this.account_pw = new SHA256(account_pw).toHash();
	}
}
