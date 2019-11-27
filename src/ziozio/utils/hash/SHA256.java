package ziozio.utils.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 implements HashConverter {

	private String value;
	
	public SHA256(String value) {
		this.value = value;
	}
	
	@Override
	public String toHash() {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());
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
