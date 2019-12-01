package ziozio.dto;

import java.util.Date;

public class WeatherInfo implements DTO {
	private Date weahter_info_date;
	private String location_name;
	private String weather_name;
	private int temperature_grade_code;
	private double weather_info_temperature;
	private double weather_info_finedust;
	@Override
	public String toString() {
		return "WeatherInfo [weahter_info_date=" + weahter_info_date + ", location_name=" + location_name
				+ ", weather_name=" + weather_name + ", temperature_grade_code=" + temperature_grade_code
				+ ", weather_info_temperature=" + weather_info_temperature + ", weather_info_finedust="
				+ weather_info_finedust + "]";
	}
	public Date getWeahter_info_date() {
		return weahter_info_date;
	}
	public void setWeahter_info_date(Date weahter_info_date) {
		this.weahter_info_date = weahter_info_date;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getWeather_name() {
		return weather_name;
	}
	public void setWeather_name(String weather_name) {
		this.weather_name = weather_name;
	}
	public int getTemperature_grade_code() {
		return temperature_grade_code;
	}
	public void setTemperature_grade_code(int temperature_grade_code) {
		this.temperature_grade_code = temperature_grade_code;
	}
	public double getWeather_info_temperature() {
		return weather_info_temperature;
	}
	public void setWeather_info_temperature(double weather_info_temperature) {
		this.weather_info_temperature = weather_info_temperature;
	}
	public double getWeather_info_finedust() {
		return weather_info_finedust;
	}
	public void setWeather_info_finedust(double weather_info_finedust) {
		this.weather_info_finedust = weather_info_finedust;
	}
}
