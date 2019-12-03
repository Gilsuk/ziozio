package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.StyleClothDAO;
import ziozio.dao.impl.StyleClothDAOImpl;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

public class StyleClothService implements ClothService<Style, Cloth>{
	
	private StyleClothDAO styleclothDao = new StyleClothDAOImpl();

	@Override
	public List<Cloth> getClothes(Style style) {	
		
		return styleclothDao.selectAll(style);
		
	}

	@Override
	public List<Cloth> getClothes(Style style, ClothCategory category) {
		
		return styleclothDao.selectAll(style, category);
		
	}

	@Override
	public List<Cloth> getClothes(Style style, Paging paging) {
		
		return styleclothDao.selectAll(style, paging);
		
	}

	@Override
	public List<Cloth> getClothes(Style style, ClothCategory category, Paging paging) {
		return styleclothDao.selectAll(style, category, paging);
	}

	@Override
	public Paging getPaging(Style style, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//Style TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = styleclothDao.selectCntAll(style);

		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;

	}

	@Override
	public Paging getPaging(Style style, ClothCategory category, HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//Style TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = styleclothDao.selectCntAll(style, category);

		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);

		return paging;
		
	}

}
