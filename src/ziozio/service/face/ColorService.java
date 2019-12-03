package ziozio.service.face;

import java.util.List;

import ziozio.dto.Color;

public interface ColorService {
	
	Color getRandomColor();
	
	List<Color> getRandomColorList(int count);

}
