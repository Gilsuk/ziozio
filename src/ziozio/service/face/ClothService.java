package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;

public interface ClothService {
	
	List<Cloth> getClothesByWeather(String weather, String category, int count);
	
	List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, int count);

	List<Cloth> getClothesByStyle(String style, String category, int count);

	List<Cloth> getClothesByGender(char gender, String category, int count);
	
	List<Cloth> getClothesByAccountLibrary(Account account, String category, int count);
	
	List<List<Cloth>> getClothSetsByAccountLike(Account account, int count);

	
	
}
