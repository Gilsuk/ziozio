package ziozio.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccountAuth extends Account {

	private String account_pw;
	private boolean account_verified;

	public String getAccount_pw() {
		return account_pw;
	}
	public void setAccount_pw(String account_pw) {
		this.account_pw = toSHA256(account_pw);
	}
	public boolean isAccount_verified() {
		return account_verified;
	}
	public void setAccount_verified(boolean account_verified) {
		this.account_verified = account_verified;
	}

    private String toSHA256(String pw) {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			return bytesToHex(md.digest());
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		
		return null;
    }
 
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) 
          builder.append(String.format("%02x", b));

        return builder.toString();
    }
}
