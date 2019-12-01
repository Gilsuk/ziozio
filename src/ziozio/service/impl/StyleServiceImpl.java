package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.StyleDAO;
import ziozio.dao.impl.StyleDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.service.face.StyleService;

public class StyleServiceImpl implements StyleService {
	
	private StyleDAO styleDao = new StyleDAOImpl();

	@Override
	public List<Style> getAllStyles() {
		
		return styleDao.selectAll();
	}

	@Override
	public List<Style> getStylesByAccount(Account account) {
		return null;
	}

	@Override
	public List<Style> getStyles(HttpServletRequest req) {
		return null;
	}

}
