package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothServiceGeneric<T> {
	
	// by weather, temp_grade, style, gender, account(library)
	
	List<Cloth> getClothes(T selector, ClothCategory category);

	List<Cloth> getClothes(T selector, ClothCategory category, Paging paging);

	Paging getPaging(T selector, HttpServletRequest req);

}
