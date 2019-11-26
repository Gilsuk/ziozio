package ziozio.utils.param;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class URLEncodedParamParser implements ParameterParser {

	@Override
	public Map<String, String[]> parse(HttpServletRequest req) {
		return req.getParameterMap();
	}

}
