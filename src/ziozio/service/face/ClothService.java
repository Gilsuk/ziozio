package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothService<T, U extends Cloth> {
	
	// by weather, temp_grade, style, gender, account(library)
	
	List<U> getClothes(T selector);

	List<U> getClothes(T selector, ClothCategory category);

	List<U> getClothes(T selector, Paging paging);

	List<U> getClothes(T selector, ClothCategory category, Paging paging);

	Paging getPaging(T selector, HttpServletRequest req);

	Paging getPaging(T selector, ClothCategory category, HttpServletRequest req);
	
}
