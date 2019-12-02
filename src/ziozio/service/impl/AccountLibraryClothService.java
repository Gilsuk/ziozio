package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.ClothDAO;
import ziozio.dao.impl.ClothDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

public class AccountLibraryClothService implements ClothService<Account, ClothWithColor> {

	private ClothDAO clothDao = new ClothDAOImpl();
	
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
		
}
