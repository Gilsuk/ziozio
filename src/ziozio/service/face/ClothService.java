package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.dto.Board;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;

public interface ClothService {
	
	List<Cloth> getClothesByWeather(String weather, String category, Paging paging);
	
	List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, Paging paging);

	List<Cloth> getClothesByStyle(String style, String category, Paging paging);

	List<Cloth> getClothesByGender(char gender, String category, Paging paging);
	
	/**
	 * cloth_library 목록 조회
	 *  
	 * @return List - 내옷장 목록
	 */	
	List<Cloth> getClothesByAccountLibrary();

	/**
	 * 페이징 정보를 활용하여 보여질 cloth_library 목록만 조회
	 *  
	 * @param Paging - 페이징 정보
	 * @return List - 내옷장 목록
	 */	
	List<Cloth> getClothesByAccountLibrary(Account account, String category, Paging paging);

	
	
	List<List<Cloth>> getClothSetsByAccountLike(Account account, Paging paging);


	Paging getPagingByAccount(HttpServletRequest req, Account account);


}
