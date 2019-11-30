package ziozio.dto;

public class Color implements DTO {
	private int color_code;
	private String color_name;
	private int hue_rotate;
	private double saturate;
	private double brightness;

	@Override
	public String toString() {
		return "Color [color_code=" + color_code + ", color_name=" + color_name + ", hue_rotate=" + hue_rotate
				+ ", saturate=" + saturate + ", brightness=" + brightness + "]";
	}
	public int getColor_code() {
		return color_code;
	}
	public void setColor_code(int color_code) {
		this.color_code = color_code;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public int getHue_rotate() {
		return hue_rotate;
	}
	public void setHue_rotate(int hue_rotate) {
		this.hue_rotate = hue_rotate;
	}
	public double getSaturate() {
		return saturate;
	}
	public void setSaturate(double saturate) {
		this.saturate = saturate;
	}
	public double getBrightness() {
		return brightness;
	}
	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}
}
