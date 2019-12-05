package ziozio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.ClothDAO;
import ziozio.dao.impl.ClothDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

public class AccountLibraryClothService implements ClothService<Account> {

	/*
	 * Fields
	 */
	private ClothDAO clothDao = ClothDAOImpl.getInstance();

	/*
	 * Singleton
	 */
	private AccountLibraryClothService() { }
    private static class Factory {
        public static final ClothService<Account> INSTANCE = new AccountLibraryClothService();
    }
    public static ClothService<Account> getInstance() { return Factory.INSTANCE; }

	
	@Override
	public List<ClothWithColor> getClothes(Account account) {
		return clothDao.selectAll(account);
	}

	@Override
	public List<ClothWithColor> getClothes(Account account, ClothCategory category) {
		return clothDao.selectAll(account, category);
	}

	@Override
	public List<ClothWithColor> getClothes(Account account, Paging paging) {
		return clothDao.selectAll(account, paging);
	}

	@Override
	public List<ClothWithColor> getClothes(Account account, ClothCategory category, Paging paging) {
		return clothDao.selectAll(account, category, paging);
	}

	@Override
	public Paging getPaging(Account account, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = clothDao.selectCntAll(account);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage, 5);
		
		return paging;
	}

	@Override
	public Paging getPaging(Account account, ClothCategory category, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = clothDao.selectCntAll(account, category);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage, 5);
		
		return paging;
	}
		
	/**
	 * 내 옷장에 옷을 추가
	 * 
	 * @param account : account_no 를 활용
	 * @param cloth : cloth_code, color_code 를 활용
	 */
	public void addToLibrary(Account account, ClothWithColor cloth) {
		clothDao.addToLibrary(account, cloth);
	}
	
	/**
	 * 내 옷장에서 옷을 제거
	 * 
	 * @param account : account_no 를 활용
	 * @param cloth : cloth_code, color_code 를 활용
	 */
	public void removeFromLibrary(Account account, ClothWithColor cloth) {
		clothDao.removeFromLibrary(account, cloth);
	}

	@Override
	public List<ClothWithColor> getClothes(List<Account> selector, ClothCategory category) {
		return new ArrayList<>();
	}

	@Override
	public List<ClothWithColor> getClothes(List<Account> selector, ClothCategory category, Paging paging) {
		return new ArrayList<>();
	}
}
