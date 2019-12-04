package ziozio.service.face;

import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;

public interface ClothSetService {

	ClothSet dressUp(ClothWithColor cloth, ClothSet set);

	ClothSet dressUp(ClothWithColor cloth);
}
