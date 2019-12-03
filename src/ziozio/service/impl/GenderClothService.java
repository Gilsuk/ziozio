package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.GenderClothDAO;
import ziozio.dao.impl.GenderClothDAOImpl;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

public class GenderClothService implements ClothService<Character, Cloth> {
	
	private GenderClothDAO genderclothDao = new GenderClothDAOImpl();

	@Override
	public List<Cloth> getClothes(Character gender) {
		
		return genderclothDao.selectAll(gender);
		
	}

	@Override
	public List<Cloth> getClothes(Character gender, ClothCategory category) {
		
		return genderclothDao.selectAll(gender, category);
		
	}

	@Override
	public List<Cloth> getClothes(Character gender, Paging paging) {
		
		return genderclothDao.selectAll(gender, paging);
		
	}

	@Override
	public List<Cloth> getClothes(Character gender, ClothCategory category, Paging paging) {
		
		return genderclothDao.selectAll(gender, category, paging);
		
	}

	@Override
	public Paging getPaging(Character gender, HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//Style TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = genderclothDao.selectCntAll(gender);

		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
		
	}

	@Override
	public Paging getPaging(Character gender, ClothCategory category, HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//Style TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = genderclothDao.selectCntAll(gender, category);

		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

}
