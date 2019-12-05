package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothService<T> {
	
	public List<ClothWithColor> getClothes(T selector);

	public List<ClothWithColor> getClothes(T selector, ClothCategory category);

	public List<ClothWithColor> getClothes(List<T> selector, ClothCategory category);

	public List<ClothWithColor> getClothes(T selector, Paging paging);

	public List<ClothWithColor> getClothes(T selector, ClothCategory category, Paging paging);

	public List<ClothWithColor> getClothes(List<T> selector, ClothCategory category, Paging paging);

	public Paging getPaging(T selector, HttpServletRequest req);

	public Paging getPaging(T selector, ClothCategory category, HttpServletRequest req);
	
}
