package ziozio.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
	private StyleDAO styleDao = StyleDAOImpl.getInstance();
	private AccountService accountService = AccountServiceImpl.getInstance();

	/*
	 * Singleton
	 */
	private StyleServiceImpl() { }
    private static class Factory {
        public static final StyleService INSTANCE = new StyleServiceImpl();
    }
    public static StyleService getInstance() { return Factory.INSTANCE; }

	@Override
	public List<Style> getAllStyles() {
		
		return styleDao.selectAll();
	}

	@Override
	public List<Style> getStylesByAccount(Account account) {
		
		return styleDao.accountSelectAll(account);
	
	}

	@Override
	public List<Style> getAccountStyles(HttpServletRequest req) throws AccountNotFountException {
		
		Account loggedInAccount = null;
			loggedInAccount = accountService.getLoggedInAccount(req);
			return getStylesByAccount(loggedInAccount);
			
		
	}

	@Override
	public List<Style> getSelectedStyles(HttpServletRequest req) {
		String[] values = req.getParameterValues("styles[]");
		List<Style> list = new ArrayList<>();
		
		for (String style_name : values) {
			Style style = new Style();
			style.setStyle_name(style_name);
			list.add(style);
		}

		return list;
	}

	@Override
	public int addStylesToAccount(Account account, List<Style> styles) {
		/*
		 * 미-완-성
		 */
		if (styles.size() <= 0) return 0;
		try {
			styleDao.insert(account, styleDao.selectAll(styles));
		} catch (SQLException e) {
			styles.remove(0);
		}
//		else {
//			int count = styleDao.insert(account, styleDao.selectAll(styles)); 
//			System.out.println(count + " size:" + styles.size());
//			for (int i = 0; i < count; i++) {
//				styles.remove(0);
//			}
			return addStylesToAccount(account, styles);
//		}
	}

}
