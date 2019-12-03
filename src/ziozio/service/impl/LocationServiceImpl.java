package ziozio.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			HttpURLConnection con = (HttpURLConnection)link.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("accept-language", "ko-KR");
			

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
			
			return sb.toString();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "";
	}

//	public static void main(String[] args) {
//		LocationServiceImpl locserv = new LocationServiceImpl();
//		Location location = locserv.getLocation(37.4923615, 127.02928809999999);
//		System.out.println(location);
//		
//		
//		
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
		
		
		Gson gson = new Gson();
		JsonElement jsonElement = JsonParser.parseString(json);
		
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonElement element = jsonObject.get("results").getAsJsonArray().get(2)
				.getAsJsonObject().get("formatted_address");

		String localname = element.getAsString();
		StringBuilder local = new StringBuilder(localname);
		local.delete(0, 5);
//		System.out.println(local);
		
		
//		System.out.println(jsonElement3);

//		JsonParser jsonParser = new JsonParser();
//		JsonElement jsonElement = jsonParser.parse(json);
//		
//		String name = jsonElement.getAsJsonObject().get("results").toString();
//		String name = jsonElement.getAsJsonObject().get("results").toString();
//		System.out.println(name);
//		Location location = new Location();
//		System.out.println(jsonElement3.getAsString());
//		location.setLocation_name(element.getAsString());
		
		return getLocation(local.toString());
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
