package ziozio.service.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothSetService<T> {

	public List<List<Cloth>> getClothSets(T selector, Paging paging);

}
