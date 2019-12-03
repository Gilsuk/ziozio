package ziozio.dto;

public class ClothWithColor extends Cloth {
	private int color_code;
	private String color_name;
	private int color_hue_rotate;
	private int color_saturate;
	private int color_brightness;
	@Override
	public String toString() {
		return "ClothWithColor [color_code=" + color_code + ", color_name=" + color_name + ", color_hue_rotate="
				+ color_hue_rotate + ", color_saturate=" + color_saturate + ", color_brightness=" + color_brightness
				+ ", toString()=" + super.toString() + "]";
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
	public int getColor_hue_rotate() {
		return color_hue_rotate;
	}
	public void setColor_hue_rotate(int color_hue_rotate) {
		this.color_hue_rotate = color_hue_rotate;
	}
	public int getColor_saturate() {
		return color_saturate;
	}
	public void setColor_saturate(int color_saturate) {
		this.color_saturate = color_saturate;
	}
	public int getColor_brightness() {
		return color_brightness;
	}
	public void setColor_brightness(int color_brightness) {
		this.color_brightness = color_brightness;
	}
}
