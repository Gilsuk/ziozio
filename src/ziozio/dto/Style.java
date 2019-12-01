package ziozio.dto;

import java.util.Arrays;

public class Style implements DTO {
	
	private int style_code;
	private String style_name;
	private String color_name;;
	private String cloth_category_name;
	private String cloth_name;
	@Override
	public String toString() {
		return "Style [style_code=" + style_code + ", style_name=" + style_name + ", color_name=" + color_name
				+ ", cloth_category_name=" + cloth_category_name + ", cloth_name=" + cloth_name + "]";
	}
	public int getStyle_code() {
		return style_code;
	}
	public void setStyle_code(int style_code) {
		this.style_code = style_code;
	}
	public String getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getCloth_category_name() {
		return cloth_category_name;
	}
	public void setCloth_category_name(String cloth_category_name) {
		this.cloth_category_name = cloth_category_name;
	}
	public String getCloth_name() {
		return cloth_name;
	}
	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}
	
	
	
	
	
	

}
