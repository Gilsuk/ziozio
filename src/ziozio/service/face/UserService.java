package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.MyPage;
import ziozio.dto.Account;

public interface UserService {

	MyPage getMyPage(Account account);

	String getUserMail(HttpServletRequest req);

}
