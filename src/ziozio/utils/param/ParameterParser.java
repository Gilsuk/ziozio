package ziozio.utils.param;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ParameterParser {

	Map<String, String[]> parse(HttpServletRequest req);

}
