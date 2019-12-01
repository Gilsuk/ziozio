package ziozio.dto;

import java.util.List;

public class Cloth implements DTO {
	private int cloth_code;
	private int cloth_category_code;
	private String cloth_name;
	private String cloth_link_url;
	private char cloth_gender;
	private List<String> style_name;
	private List<Integer> temperature_grade_code;
	private List<String> weather_name;
	@Override
	public String toString() {
		return "Cloth [cloth_code=" + cloth_code + ", cloth_category_code=" + cloth_category_code + ", cloth_name="
				+ cloth_name + ", cloth_link_url=" + cloth_link_url + ", cloth_gender=" + cloth_gender + ", style_name="
				+ style_name + ", temperature_grade_code=" + temperature_grade_code + ", weather_name=" + weather_name
				+ "]";
	}
	public int getCloth_code() {
		return cloth_code;
	}
	public void setCloth_code(int cloth_code) {
		this.cloth_code = cloth_code;
	}
	public int getCloth_category_code() {
		return cloth_category_code;
	}
	public void setCloth_category_code(int cloth_category_code) {
		this.cloth_category_code = cloth_category_code;
	}
	public String getCloth_name() {
		return cloth_name;
	}
	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}
	public String getCloth_link_url() {
		return cloth_link_url;
	}
	public void setCloth_link_url(String cloth_link_url) {
		this.cloth_link_url = cloth_link_url;
	}
	public char getCloth_gender() {
		return cloth_gender;
	}
	public void setCloth_gender(char cloth_gender) {
		this.cloth_gender = cloth_gender;
	}
	public List<String> getStyle_name() {
		return style_name;
	}
	public void setStyle_name(List<String> style_name) {
		this.style_name = style_name;
	}
	public List<Integer> getTemperature_grade_code() {
		return temperature_grade_code;
	}
	public void setTemperature_grade_code(List<Integer> temperature_grade_code) {
		this.temperature_grade_code = temperature_grade_code;
	}
	public List<String> getWeather_name() {
		return weather_name;
	}
	public void setWeather_name(List<String> weather_name) {
		this.weather_name = weather_name;
	}
}
