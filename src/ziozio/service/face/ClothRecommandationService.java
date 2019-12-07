package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothRecommandationService {
	
	List<ClothWithColor> getClothes(Account account, WeatherInfo weather, List<Style> styles, ClothCategory category);

}
