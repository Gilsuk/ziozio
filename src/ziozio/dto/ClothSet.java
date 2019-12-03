package ziozio.dto;

import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.exception.ClothCategoryNotMatched;

public class ClothSet implements DTO {
	
	private Cloth top;
	private Cloth bottom;
	private Cloth outer;
	@Override
	public String toString() {
		return "ClothSet [top=" + top + ", bottom=" + bottom + ", outer=" + outer + "]";
	}
	public Cloth getTop() {
		return top;
	}
	public void setTop(Cloth top) throws ClothCategoryNotMatched {
		if (top.getCloth_category_name() == ClothCategory.TOP.getDbValue())
			this.top = top;
		else
			throw new ClothCategoryNotMatched();
	}
	public Cloth getBottom() {
		return bottom;
	}
	public void setBottom(Cloth bottom) throws ClothCategoryNotMatched {
		if (bottom.getCloth_category_name() == ClothCategory.BOTTOM.getDbValue())
			this.bottom = bottom;
		else
			throw new ClothCategoryNotMatched();
	}
	public Cloth getOuter() {
		return outer;
	}
	public void setOuter(Cloth outer) throws ClothCategoryNotMatched {
		if (outer.getCloth_category_name() == ClothCategory.OUTER.getDbValue())
			this.outer = outer;
		else
			throw new ClothCategoryNotMatched();
	}
}
