package ziozio.dto;

public class Verification implements DTO {
	private int account_no;
	private char verification_type;
	private String verification_code;
	@Override
	public String toString() {
		return "Verification [account_no=" + account_no + ", verification_type=" + verification_type
				+ ", verification_code=" + verification_code + "]";
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public char getVerification_type() {
		return verification_type;
	}
	public void setVerification_type(char verification_type) {
		this.verification_type = verification_type;
	}
	public String getVerification_code() {
		return verification_code;
	}
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
}
