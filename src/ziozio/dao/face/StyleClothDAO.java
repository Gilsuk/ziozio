package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;

public interface StyleClothDAO {

	List<Cloth> selectAll(Style style);

	List<Cloth> selectAll(Style style, ClothCategory category);

}
