package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface GenderClothDAO {

	List<Cloth> selectAll(Character gender);

	List<Cloth> selectAll(Character gender, ClothCategory category);

	int selectCntAll(Character gender);

	int selectCntAll(Character gender, ClothCategory category);

	List<Cloth> selectAll(Character gender, Paging paging);

	List<Cloth> selectAll(Character gender, ClothCategory category, Paging paging);

}
