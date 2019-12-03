package ziozio.service.face;

import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;

public interface ColorService {
	
	Color getRandomColor();
	
	Color extractColorFromClothWithColor(ClothWithColor cloth);

}
