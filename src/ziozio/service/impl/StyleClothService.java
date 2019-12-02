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
		
		return null;
		
	}

	@Override
	public List<Cloth> getClothes(Style style, ClothCategory category, Paging paging) {
		return null;
	}

	@Override
	public Paging getPaging(Style style, HttpServletRequest req) {
		
		return null;
		
	}

	@Override
	public Paging getPaging(Style style, ClothCategory category, HttpServletRequest req) {
		return null;
	}

}
