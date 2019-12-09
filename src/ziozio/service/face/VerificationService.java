package ziozio.service.face;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Account;
import ziozio.dto.AccountWithPw;
import ziozio.enumeration.VerificationType;
import ziozio.service.exception.TypeNotAllowedException;

public interface VerificationService {
	
	String getQueryString(Account account, VerificationType type) throws SelectResultException;

	Account getAccountno(HttpServletRequest request);

	VerificationType getType(HttpServletRequest request) throws TypeNotAllowedException;


	void generateKey(Account account) throws SQLException;
	
	

}
