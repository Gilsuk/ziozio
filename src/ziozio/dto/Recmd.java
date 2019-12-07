package ziozio.dto;

import java.util.List;

import ziozio.dto.enumeration.ClothCategory;

public class Recmd implements DTO {
	
	private WeatherInfo weather;
	private List<Style> styles;
	private ClothCategory category;
	private char gender;
	@Override
	public String toString() {
		return "Recmd [weather=" + weather + ", styles=" + styles + ", category=" + category + ", gender=" + gender
				+ "]";
	}
	public WeatherInfo getWeather() {
		return weather;
	}
	public void setWeather(WeatherInfo weather) {
		this.weather = weather;
	}
	public List<Style> getStyles() {
		return styles;
	}
	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}
	public ClothCategory getCategory() {
		return category;
	}
	public void setCategory(ClothCategory category) {
		this.category = category;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
