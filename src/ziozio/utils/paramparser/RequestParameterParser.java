package ziozio.utils.paramparser;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RequestParameterParser implements ParameterParser {

	@Override
	public Map<String, String[]> parse(HttpServletRequest req) {
		try { req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); }
		
		if (ServletFileUpload.isMultipartContent(req)) 
			return new MultipartParamParser().parse(req);

		return new URLEncodedParamParser().parse(req);
	}

}
