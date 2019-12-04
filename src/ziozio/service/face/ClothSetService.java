package ziozio.service.face;

import java.util.List;

import ziozio.dto.ClothSet;
import ziozio.dto.Paging;

public interface ClothSetService<T> {

	public List<ClothSet> getClothSets(T selector, Paging paging);

}
