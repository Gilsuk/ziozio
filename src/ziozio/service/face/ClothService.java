package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothService<T, U extends Cloth> {
	
	// by weather, temp_grade, style, gender, account(library)
	
	public List<U> getClothes(T selector);

	public List<U> getClothes(T selector, ClothCategory category);

	public List<U> getClothes(T selector, Paging paging);

	public List<U> getClothes(T selector, ClothCategory category, Paging paging);

	public Paging getPaging(T selector, HttpServletRequest req);

	public Paging getPaging(T selector, ClothCategory category, HttpServletRequest req);
	
}
