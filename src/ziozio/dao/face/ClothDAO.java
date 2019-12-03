package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.WeatherInfo;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothDAO {

	/**
	 * 내 옷장 전체 목록 조회
	 * @param account - 내 옷장 옷 총 목록
	 * @return
	 */
	public List<ClothWithColor> selectAll(Account account);
	
	/**
	 * 내 옷장에 있는 옷을  ClothCategory(TOP, BOTTOM, OUTER)로 전체 조회
	 * @param account
	 * @param category
	 * @return
	 */
	public List<ClothWithColor> selectAll(Account account, ClothCategory category);
	
	/**
	 * 개인 옷장 부분 조회
	 * @param account
	 * @param paging
	 * @return
	 */
	public List<ClothWithColor> selectAll(Account account, Paging paging);
	
	/**
	 * 개인 옷장  ClothCategory(TOP, BOTTOM, OUTER)로 부분 조회
	 * @param account
	 * @param category
	 * @param paging
	 * @return
	 */
	public List<ClothWithColor> selectAll(Account account, ClothCategory category, Paging paging);


	
	/**
	 * 개인 옷 개수 전체 조회
	 * @param account
	 * @return
	 */
	public int selectCntAll(Account account);
	
	/**
	 * 개인 옷 개수   ClothCategory(TOP, BOTTOM, OUTER)로 부분 조회
	 * @param account
	 * @param category
	 * @return
	 */
	public int selectCntAll(Account account, ClothCategory category);

	/**
	 * 날씨에 따른 옷 목록
	 * @param weather
	 * @return
	 */
	public List<Cloth> selectAll(WeatherInfo weather);
}
