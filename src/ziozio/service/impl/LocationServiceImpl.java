package ziozio.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import ziozio.dao.face.LocationDAO;
import ziozio.dao.impl.LocationDAOImpl;
import ziozio.dto.Location;
import ziozio.enumeration.ReqParam;
import ziozio.enumeration.SessionAttr;
import ziozio.service.face.LocationService;

public class LocationServiceImpl implements LocationService {

	private LocationDAO locDao = LocationDAOImpl.getInstance();

	@Override
	public Location getLocation(HttpServletRequest req) {
		
		try {
			double latitude = Double.parseDouble(req.getParameter(ReqParam.LATITUDE.toString()));
			double longitude = Double.parseDouble(req.getParameter(ReqParam.LONGITUDE.toString()));
			return getLocation(latitude, longitude);
		} catch (NullPointerException e) {
			
		} catch (ClassCastException e) { 
			e.printStackTrace();
			return null;
		}
		
		try {
			// 세션에 저장된 Location을 반환
			return (Location) req.getSession().getAttribute(SessionAttr.LOCATION.toString());
		} catch (NullPointerException e) {
			// 세션에 저장된게 없으면
			
		} catch (ClassCastException e) {
			
		}
		return null;
	}

	/*
	 * lat과 lon을 통해 Location을 반환한다.
	 * 우리 DB에는 좌표 정보가 없으므로 외부 서버로부터 localname을 알아온 후,
	 * 아래의 getLocation(String localname)을 재 호출해서 Location을 반환
	 */
	public static void main(String[] args) {
		LocationService los = new LocationServiceImpl();
		los.getLocation(123, 321);
		
	}
	@Override
	public Location getLocation(double latitude, double longitude) {
		try {
			URL url = new URL("https://www.google.com");
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
			con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
			con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
//			con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); //key값 설정

			con.setRequestMethod("GET");
			con.setDoOutput(false); 

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//Stream을 처리해줘야 하는 귀찮음이 있음. 
				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			System.out.println(sb);

		} catch (Exception e) {
		}



		return null;
	}

	/*
	 * DB에서 localname을 통해 조회해서 Location_code를 완성하여 반환
	 */
	@Override
	public Location getLocation(String localname) {
		return locDao.select(localname);
	}

	@Override
	public Location getDefaultLocation() {
		Location location = new Location();
		location.setLocation_code(1168091100);
		location.setLocation_name("서울특별시 강남구 역삼1동");
		return location;
	}

	@Override
	public void setLocationToSession(HttpServletRequest req, Location location) {
		req.getSession().setAttribute("locatin", location);
	}

}
