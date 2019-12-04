package ziozio.dto;

public class ClothSet implements DTO {
	
	private int clost_set_no;
	private ClothWithColor top;
	private ClothWithColor bottom;
	private ClothWithColor outer;
	@Override
	public String toString() {
		return "ClothSet [clost_set_no=" + clost_set_no + ", top=" + top + ", bottom=" + bottom + ", outer=" + outer
				+ "]";
	}
	public int getClost_set_no() {
		return clost_set_no;
	}
	public void setClost_set_no(int clost_set_no) {
		this.clost_set_no = clost_set_no;
	}
	public ClothWithColor getTop() {
		return top;
	}
	public void setTop(ClothWithColor top) {
		this.top = top;
	}
	public ClothWithColor getBottom() {
		return bottom;
	}
	public void setBottom(ClothWithColor bottom) {
		this.bottom = bottom;
	}
	public ClothWithColor getOuter() {
		return outer;
	}
	public void setOuter(ClothWithColor outer) {
		this.outer = outer;
	}

}
