package ziozio.dto;

public class Location implements DTO {
	
	private long location_code;
	private String location_name;
	@Override
	public String toString() {
		return "Location [location_code=" + location_code + ", location_name=" + location_name + "]";
	}
	public long getLocation_code() {
		return location_code;
	}
	public void setLocation_code(long location_code) {
		this.location_code = location_code;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
}
