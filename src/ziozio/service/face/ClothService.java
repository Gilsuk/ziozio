package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothService {
	
	List<Cloth> getClothesByWeather(String weather, String category, Paging paging);
	
	List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, Paging paging);

	List<Cloth> getClothesByStyle(String style, String category, Paging paging);

	List<Cloth> getClothesByGender(char gender, String category, Paging paging);
	
	List<Cloth> getClothesByAccountLibrary(Account account, String category, Paging paging);
	
	List<List<Cloth>> getClothSetsByAccountLike(Account account, Paging paging);

}
