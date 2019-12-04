package ziozio.service.face;

import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.dto.WithColor;

public interface ColorService {
	
	Color getRandomColor();
	
	Color extractColorFromClothWithColor(ClothWithColor cloth);
	
	Color getColorByName(Color color);
	
	/*
	 * Mutable T
	 */
	<T extends WithColor> T setColor(T t, Color color);

}
