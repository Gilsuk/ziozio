package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.ClothDAO;
import ziozio.dao.impl.ClothDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.service.face.StyleService;

public class StyleServiceImpl implements StyleService {
	
	private ClothDAO clothDao = new ClothDAOImpl();

	@Override
	public List<Style> getAllStyles() {
		
		return clothDao.selectAll();
	}

	@Override
	public List<Style> getStylesByAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Style> getStyles(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
