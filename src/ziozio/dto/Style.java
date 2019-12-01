package ziozio.dto;

public class Style implements DTO {
	
	private int style_code;
	private String style_name;
	@Override
	public String toString() {
		return "Style [style_code=" + style_code + ", style_name=" + style_name + "]";
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
}
