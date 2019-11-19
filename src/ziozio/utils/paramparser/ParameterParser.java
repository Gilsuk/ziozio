package ziozio.utils.paramparser;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ParameterParser {

	Map<String, String[]> parse(HttpServletRequest req);

}
