package ziozio.service.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;

public interface ClothColorService<T extends Cloth> {
	
	ClothWithColor setRandomColor(T cloth);

	List<ClothWithColor> setRandomColor(List<T> clothes);
	
	ClothWithColor setColor(T cloth, Color color);

}
