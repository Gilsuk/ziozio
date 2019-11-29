package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Location;

public interface LocationService {
	
	/*
	 * 지역정보를 반환한다.
	 * 유저의 지역정보를 얻는것은 이미 구현되어 있으므로 활용할 것
	 */
	Location getLocation(HttpServletRequest req);

}
