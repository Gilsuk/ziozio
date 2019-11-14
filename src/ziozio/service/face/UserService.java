package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.MyPage;
import ziozio.dto.User;

public interface UserService {

	MyPage getMyPage(User user);

	String getUserMail(HttpServletRequest req);

}
