package ziozio.dto;

import ziozio.dto.face.DTO;

public class User implements DTO<User> {

	private int userno;
	private String useremail;
	private String userpw;
	private String username;
	private String usernick;
	private String userbirth;
	private String userphone;
	private String usergender;

	@Override
	public String toString() {
		return "User [userno=" + userno + ", useremail=" + useremail + ", userpw=" + userpw + ", username=" + username
				+ ", usernick=" + usernick + ", userbirth=" + userbirth + ", userphone=" + userphone + ", usergender="
				+ usergender + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}

	public String getUserbirth() {
		return userbirth;
	}

	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	

}
