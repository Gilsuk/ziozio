package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.StyleClothDAO;
import ziozio.dao.impl.StyleClothDAOImpl;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothColorService;
import ziozio.service.face.ClothService;

public class StyleClothService implements ClothService<Style> {
	
	private StyleClothDAO styleclothDao = StyleClothDAOImpl.getInstance();
	private ClothColorService<Cloth> clothColorService = ClothColorServiceImpl.getInstance();

	/*
	 * Singleton
	 */
	private StyleClothService() { }
    private static class Factory {
        public static final ClothService<Style> INSTANCE = new StyleClothService();
    }
    public static ClothService<Style> getInstance() { return Factory.INSTANCE; }

	@Override
	public List<ClothWithColor> getClothes(Style style) {	
		return clothColorService.setRandomColor(styleclothDao.selectAll(style));
		
	}

	@Override
	public List<ClothWithColor> getClothes(Style style, ClothCategory category) {
		return clothColorService.setRandomColor(styleclothDao.selectAll(style, category));
		
	}

	@Override
	public List<ClothWithColor> getClothes(Style style, Paging paging) {
		return clothColorService.setRandomColor(styleclothDao.selectAll(style, paging));
		
	}

	@Override
	public List<ClothWithColor> getClothes(Style style, ClothCategory category, Paging paging) {
		return clothColorService.setRandomColor(styleclothDao.selectAll(style, category, paging));
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

	@Override
	public List<ClothWithColor> getClothes(List<Style> selector, ClothCategory category) {
		return clothColorService.setRandomColor(styleclothDao.selectAll(selector, category));
	}

	@Override
	public List<ClothWithColor> getClothes(List<Style> selector, ClothCategory category, Paging paging) {
		return clothColorService.setRandomColor(styleclothDao.selectAll(selector, category, paging));
	}

}
