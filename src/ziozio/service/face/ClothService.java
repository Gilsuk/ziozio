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

	
	
	/**
	 * 요청파라미터 curPage를 파싱한다
	 * Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
	 * 
	 * @param req - 요청정보 객체
	 * @return Paging - 페이징 정보
	 */
	Paging getPaging(HttpServletRequest req);	
	
	/**
	 * 요청 파라미터 cloth_code 파싱
	 * 
	 * @param req - 요청 정보 객체
	 * @return Board - cloth_code를 가진 객체
	 */
	Board cloth_code(HttpServletRequest req);
	
}
