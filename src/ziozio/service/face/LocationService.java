package ziozio.service.face;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Location;

public interface LocationService {
	
	/*
	 * 지역정보를 반환한다.
	 */
	Location getLocation(HttpServletRequest req);
	
	/**
	 * 
	 * @return
	 * 
	 * 사용자의 위치정보를 확인할 수 없는 경우 기본으로 제공할 Location 객체를 반환
	 */
	Location getDefaultLocation();
	
	/**
	 * 
	 * @param req
	 * 
	 * req를 파싱해서 location 객체를 생성하고, session attribute로 저장한다.
	 */
	void setLocationToSession(HttpServletRequest req);

}
