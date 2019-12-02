package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothService<T> {
	
	// by weather, temp_grade, style, gender, account(library)
	
	List<Cloth> getClothes(T selector);

	List<Cloth> getClothes(T selector, ClothCategory category);

	List<Cloth> getClothes(T selector, Paging paging);

	List<Cloth> getClothes(T selector, ClothCategory category, Paging paging);

	Paging getPaging(T selector, HttpServletRequest req);

	Paging getPaging(T selector, ClothCategory category, HttpServletRequest req);
	
}
