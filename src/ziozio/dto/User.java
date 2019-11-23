package ziozio.dto;

public class User implements DTO {

	private int userno;
	private String useremail;
	private String userpw;
	private String username;
	private String usernick;
	private String userbirth_year;
	private String userbirth_mon;
	private String userbirth_day;
	private String userphone;
	private String usergender;
	@Override
	public String toString() {
		return "User [userno=" + userno + ", useremail=" + useremail + ", userpw=" + userpw + ", username=" + username
				+ ", usernick=" + usernick + ", userbirth_year=" + userbirth_year + ", userbirth_mon=" + userbirth_mon
				+ ", userbirth_day=" + userbirth_day + ", userphone=" + userphone + ", usergender=" + usergender + "]";
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
	public String getUserbirth_year() {
		return userbirth_year;
	}
	public void setUserbirth_year(String userbirth_year) {
		this.userbirth_year = userbirth_year;
	}
	public String getUserbirth_mon() {
		return userbirth_mon;
	}
	public void setUserbirth_mon(String userbirth_mon) {
		this.userbirth_mon = userbirth_mon;
	}
	public String getUserbirth_day() {
		return userbirth_day;
	}
	public void setUserbirth_day(String userbirth_day) {
		this.userbirth_day = userbirth_day;
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
