package ziozio.dto;

public class Location implements DTO {
	
	private int location_code;
	private String location_name;
	@Override
	public String toString() {
		return "Location [location_code=" + location_code + ", location_name=" + location_name + "]";
	}
	public int getLocation_code() {
		return location_code;
	}
	public void setLocation_code(int location_code) {
		this.location_code = location_code;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
}
