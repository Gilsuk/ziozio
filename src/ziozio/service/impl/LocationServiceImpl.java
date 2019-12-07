package ziozio.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ziozio.dao.face.LocationDAO;
import ziozio.dao.impl.LocationDAOImpl;
import ziozio.dto.Location;
import ziozio.enumeration.ReqParam;
import ziozio.enumeration.SessionAttr;
import ziozio.service.face.LocationService;

public class LocationServiceImpl implements LocationService {

	private LocationDAO locDao = LocationDAOImpl.getInstance();

	/*
	 * Singleton
	 */
	private LocationServiceImpl() { }
    private static class Factory {
        public static final LocationService INSTANCE = new LocationServiceImpl();
    }
    public static LocationService getInstance() { return Factory.INSTANCE; }

	@Override
	public Location getLocation(HttpServletRequest req) {
		
		try {
			return getLocationFromParamLatAndLon(req);
		} catch (NullPointerException e) {
			return getLocationFromSession(req);
		} catch (ClassCastException e) { 
			return getDefaultLocation();
		}

	}



	private Location getLocationFromSession(HttpServletRequest req) {
		try {
			// 세션에 저장된 Location을 반환
			Object object = req.getSession().getAttribute(SessionAttr.LOCATION.toString());
			if(object == null)
				throw new NullPointerException();
			return (Location) object;
		} catch (NullPointerException e) {
			return getDefaultLocation();
		} catch (ClassCastException e) {
			return getDefaultLocation();
		}

	}



	private Location getLocationFromParamLatAndLon(HttpServletRequest req) {
		double latitude = Double.parseDouble(req.getParameter(ReqParam.LATITUDE.toString()));
		double longitude = Double.parseDouble(req.getParameter(ReqParam.LONGITUDE.toString()));
		
		Location location = getLocation(latitude, longitude);
		setLocationToSession(req, location);
		return location;
	}


	
	private String getJSONLocation(double latitude, double longitude) {
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";
		url += latitude;
		url += ",";
		url += longitude;
		url += "&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw";
		
		URL link = null;
		try {
			link = new URL(url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		try {
			HttpURLConnection con = (HttpURLConnection)link.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("accept-language", "ko-KR");
			

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
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
			
			return sb.toString();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return "";
	}

//	public static void main(String[] args) {
//		LocationServiceImpl locserv = new LocationServiceImpl();
//		Location location = locserv.getLocation(37.4923615, 127.02928809999999);
//		System.out.println(location);
//	}
		
	/*
	 * lat과 lon을 통해 Location을 반환한다.
	 * 우리 DB에는 좌표 정보가 없으므로 외부 서버로부터 localname을 알아온 후,
	 * 아래의 getLocation(String localname)을 재 호출해서 Location을 반환
	 */
	
	@Override
	public Location getLocation(double latitude, double longitude) {
		
		//TEST까지 했음
		
		String json = getJSONLocation(latitude, longitude);
		
		JsonElement jsonElement = JsonParser.parseString(json);
		
		JsonElement element = jsonElement.getAsJsonObject().get("results")
				.getAsJsonArray().get(2)
				.getAsJsonObject().get("formatted_address");

		StringBuilder local = new StringBuilder(element.getAsString());
		local.delete(0, 5);
		
		return getLocation(local.toString());
	}

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
		req.getSession().setAttribute("location", location);
	}

}
