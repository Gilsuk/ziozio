package ziozio.dto;

import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.ClothCategoryNotMatched;

public class ClothSet implements DTO {
	
	private int cloth_set_no;
	private ClothWithColor top;
	private ClothWithColor bottom;
	private ClothWithColor outer;
	@Override
	public String toString() {
		return "ClothSet [cloth_set_no=" + cloth_set_no + ", top=" + top + ", bottom=" + bottom + ", outer=" + outer
				+ "]";
	}
	public ClothWithColor getTop() {
		return top;
	}
	public void setTop(ClothWithColor top) throws ClothCategoryNotMatched {
		if (top.getCloth_category_name() == ClothCategory.TOP.getDbValue())
			this.top = top;
		else
			throw new ClothCategoryNotMatched();
	}
	public ClothWithColor getBottom() {
		return bottom;
	}
	public void setBottom(ClothWithColor bottom) throws ClothCategoryNotMatched {
		if (bottom.getCloth_category_name() == ClothCategory.BOTTOM.getDbValue())
			this.bottom = bottom;
		else
			throw new ClothCategoryNotMatched();
	}
	public ClothWithColor getOuter() {
		return outer;
	}
	public void setOuter(ClothWithColor outer) throws ClothCategoryNotMatched {
		if (outer.getCloth_category_name() == ClothCategory.OUTER.getDbValue())
			this.outer = outer;
		else
			throw new ClothCategoryNotMatched();
	}
}
