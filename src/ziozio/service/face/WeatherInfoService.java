package ziozio.service.face;

import java.util.List;

import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;

public interface WeatherInfoService {
	
	/*
	 * Location DTO는 주어진 것으로 간주한다.
	 * Location DTO에서 필요한 정보를 가져와서
	 * WeatherInfo DTO 또는 그 리스트, 유용한 정보로 변환해주는 역할을 하는 서비스
	 */
	
	/*
	 * 지역정보에 기반한 현재 날씨를 WeatherInfo 형태로 반환한다.
	 */
	WeatherInfo getCurrentWeatherInfo(Location loc);

	/*
	 * 지역정보에 기반한 현재 날씨 + count 만큼의 향후 날씨를 List로 반환한다.
	 * 이를테면 현재 13시이고, count가 10 일 때, 13시부터 23시 까지의 예보를 반환.
	 */
	List<WeatherInfo> getWeatherInfos(Location loc, int count);

	/*
	 * 위 count 형태와 유사하지만, count를 명시적으로 넣지 않아도, '오늘' 날씨를
	 * 리스트로 뽑아주는 역할. 오늘이 반드시 '24'시를 기준으로 잡지 않아도 된다.
	 * 기준은 구현하는 사람 마음대로 잡을 수 있다.
	 * 예를들어 아침에 출근하는 시점(7시 쯤)에 말하는 '오늘' 날씨는 저녁, 혹은 밤 까지 일 것이며,
	 * 저녁에 외출하는 사람에게 '오늘' 날씨의 기준은 날짜를 넘긴 시각일 수도 있다.
	 */
	List<WeatherInfo> getWeatherInfosToday(Location loc);

	/*
	 * 리스트로 뽑은 날씨의 나열이 아닌, 딱 하나로 대표되는 그 날의 날씨를 반환한다.
	 * 예를 들어 '오늘 비와?' 라고 물었을 때 '온다' '안온다' 로 나뉠 수 있는 값을 반환하면 된다.
	 * '12시부터 15시까지 비 온 후 갠다' 같이 장황한거 말고,
	 * 오늘 '덥다', 오늘 '미세먼지 심하다' 같이 표현할 수 있는 내용을 담는 하나의 WeatherInfo 객체만 반환한다.
	 */
	WeatherInfo getRepresentativeWeatherInfo(List<WeatherInfo> weatherInfos);

	/*
	 * 전달된 WeatherInfo 리스트 중 가장 높은 기온을 반환
	 */
	double getHighTemperature(List<WeatherInfo> weatherInfos);

	/*
	 * 전달된 WeatherInfo 리스트 중 가장 낮은 기온을 반환
	 */
	double getLowTemperature(List<WeatherInfo> weatherInfos);
	
	/*
	 * 전달된 WeatherInfo 리스트 중 가장 높은 미세먼지 농도를 반환
	 */
	double getFineDust(List<WeatherInfo> weatherInfos);
	
	/*
	 * 전달된 WeatherInfo 리스트 비, 또는 눈 소식이 있다면 true, 없으면 false를 반환
	 */
	boolean willItBeRainOrSnow(List<WeatherInfo> weatherInfos);

}
