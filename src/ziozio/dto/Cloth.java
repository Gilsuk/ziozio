package ziozio.dto;

import java.util.Arrays;

public class Cloth implements DTO {
	
	private int cloth_code;
	private int cloth_category_code;
	private String cloth_name;
	private String cloth_link_url;
	private char cloth_gender;
	private String[] style_name;
	private int[] temperature_grade_code;
	private int[] cloth_weather;

	@Override
	public String toString() {
		return "Cloth [cloth_code=" + cloth_code + ", cloth_category_code=" + cloth_category_code + ", cloth_name="
				+ cloth_name + ", cloth_link_url=" + cloth_link_url + ", cloth_gender=" + cloth_gender + ", style_name="
				+ Arrays.toString(style_name) + ", temperature_grade_code=" + Arrays.toString(temperature_grade_code)
				+ ", cloth_weather=" + Arrays.toString(cloth_weather) + "]";
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
	public String[] getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String[] style_name) {
		this.style_name = style_name;
	}
	public int[] getTemperature_grade_code() {
		return temperature_grade_code;
	}
	public void setTemperature_grade_code(int[] temperature_grade_code) {
		this.temperature_grade_code = temperature_grade_code;
	}
	public int[] getCloth_weather() {
		return cloth_weather;
	}
	public void setCloth_weather(int[] cloth_weather) {
		this.cloth_weather = cloth_weather;
	}
}
