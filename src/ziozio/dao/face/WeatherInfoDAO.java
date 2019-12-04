package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Location;
import ziozio.dto.WeatherInfo;

public interface WeatherInfoDAO {

	WeatherInfo selectAll(Location loc);

	List<WeatherInfo> selectAll(Location loc, int count);


}
