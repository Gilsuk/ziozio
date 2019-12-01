package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothService {
	
	// TODO - 유사한 메소드가 많아서 클래스 분리가 필요함
	List<Cloth> getClothesByWeather(String weather, String category, Paging paging);
	
	List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, Paging paging);

	List<Cloth> getClothesByStyle(String style, String category, Paging paging);

	List<Cloth> getClothesByGender(char gender, String category, Paging paging);
	
	List<Cloth> getClothesByAccountLibrary(Account account, String category, Paging paging);
	
	List<List<Cloth>> getClothSetsByAccountLike(Account account, Paging paging);

	Paging getPagingByAccount(HttpServletRequest req, Account account);

}
