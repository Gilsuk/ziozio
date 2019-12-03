package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.StyleDAO;
import ziozio.dao.impl.StyleDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.service.exception.AccountNotFountException;
import ziozio.service.face.AccountService;
import ziozio.service.face.StyleService;

public class StyleServiceImpl implements StyleService {
	
	private StyleDAO styleDao = new StyleDAOImpl();
	private AccountService accountService = AccountServiceImpl.getInstance();

	@Override
	public List<Style> getAllStyles() {
		
		return styleDao.selectAll();
	}

	@Override
	public List<Style> getStylesByAccount(Account account) {
		
		return styleDao.accountSelectAll(account);
	
	}

	@Override
	public List<Style> getStyles(HttpServletRequest req) {
		
		Account loggedInAccount = null;
		try {
			loggedInAccount = accountService.getLoggedInAccount(req);
			return getStylesByAccount(loggedInAccount);
			
		} catch (AccountNotFountException e) {
			return  getAllStyles();
		}
		
	}

	@Override
	public Style getStyle(HttpServletRequest req) {
		
		return null;
	}

}
