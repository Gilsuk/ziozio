package ziozio.dto;

public class ClothWithColor extends Cloth implements DTO, WithColor {
	private int color_code;
	private String color_name;
	private int color_hue_rotate;
	private int color_saturate;
	private int color_brightness;
	private int color_invert;

	public ClothWithColor() { }
	public ClothWithColor(Cloth cloth) {
		setCloth_category_name(cloth.getCloth_category_name());
		setCloth_code(cloth.getCloth_code());
		setCloth_gender(cloth.getCloth_gender());
		setCloth_img(cloth.getCloth_img());
		setCloth_link_url(cloth.getCloth_link_url());
		setCloth_name(cloth.getCloth_name());
		setStyle_name(cloth.getStyle_name());
		setTemperature_grade_code(cloth.getTemperature_grade_code());
		setWeather_name(cloth.getWeather_name());
	}
	
	@Override
	public String toString() {
		return "ClothWithColor [color_code=" + color_code + ", color_name=" + color_name + ", color_hue_rotate="
				+ color_hue_rotate + ", color_saturate=" + color_saturate + ", color_brightness=" + color_brightness
				+ ", color_invert=" + color_invert + ", toString()=" + super.toString() + "]";
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
	public int getColor_invert() {
		return color_invert;
	}
	public void setColor_invert(int color_invert) {
		this.color_invert = color_invert;
	}
}

