package ziozio.dao.face;

import ziozio.dao.exception.SelectResultException;
import ziozio.dto.Verification;

public interface VerificationDAO {

	Verification select(Verification veri) throws SelectResultException;

}
