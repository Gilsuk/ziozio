package ziozio.service.impl;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.SelectResultException;
import ziozio.dao.face.VerificationDAO;
import ziozio.dao.impl.VerificationDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.dto.Verification;
import ziozio.enumeration.VerificationType;
import ziozio.service.exception.TypeNotAllowedException;
import ziozio.service.face.VerificationService;

public class VerificationServiceImpl implements VerificationService {
	
	private VerificationDAO dao = VerificationDAOImpl.getInstance();

	/*
	 * Singleton
	 */
    private VerificationServiceImpl() { }
    private static class Factory {
        public static final VerificationService INSTANCE = new VerificationServiceImpl();
    }
    public static VerificationService getInstance() { return Factory.INSTANCE; }

	@Override
	public String getQueryString(Account account, VerificationType type) throws SelectResultException {
		
		Verification veri = new Verification();
		veri.setAccount_no(account.getAccount_no());
		veri.setVerification_type(type.getValue());
		
		Verification select = dao.select(veri);
		
		StringBuilder query = new StringBuilder();
		query.append("a=").append(select.getAccount_no())
		.append("&t=").append(select.getVerification_type())
		.append("&c=").append(select.getVerification_code());
		
		return query.toString();
	}

	@Override
	public Account getAccountno(HttpServletRequest request) {
		String accno = request.getParameter("a");
		Account account = new Account();
		account.setAccount_no(Integer.parseInt(accno));
		return account;
	}

	@Override
	public VerificationType getType(HttpServletRequest request) throws TypeNotAllowedException {
		String type = request.getParameter("t");
		
		if (type.equals("M"))
			return VerificationType.EMAIL;
		else if (type.equals("F"))
			return VerificationType.FIND;
		else throw new TypeNotAllowedException();
	}

	@Override
	public void generateKey(AccountWithPw account) {
	}

}
