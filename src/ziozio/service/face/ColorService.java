package ziozio.service.face;

import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.dto.WithColor;

public interface ColorService {
	
	Color getRandomColor();
	
	Color extractColorFromClothWithColor(ClothWithColor cloth);
	
	Color getColorByName(Color color);
	
}
