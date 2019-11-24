package ziozio.utils.paramparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

public class MultipartParamParser implements ParameterParser {

	@Override
	public Map<String, String[]> parse(HttpServletRequest req) {

		ServletFileUpload upload = new ServletFileUpload();

		FileItemIterator iter = null;

		try {
			iter = upload.getItemIterator(req);
		} catch (FileUploadException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }

		return getParameterMapFromIter(iter);
	}

	private Map<String, String[]> getParameterMapFromIter(FileItemIterator iter) {
		Map<String, String[]> params = new HashMap<>();

		try {
			while (iter.hasNext()) 
				putEachParamsToMap(iter, params);
		} catch (FileUploadException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }

		return params;
	}

	private void putEachParamsToMap(FileItemIterator iter, Map<String, String[]> params)
			throws FileUploadException, IOException {

		FileItemStream item = iter.next();
		if (item.isFormField()) {
			InputStream stream =  item.openStream();
			String key = item.getFieldName();
			String value = Streams.asString(stream, "utf-8");
			
			if (params.containsKey(key))
				addValueToAlreadyExistedKey(params, key, value);
			else
				newValueIfKeyDoesntExisted(params, key, value);
		}
	}

	private void newValueIfKeyDoesntExisted(Map<String, String[]> params, String key, String value) {
		params.put(key, new String[]{value});
	}

	private void addValueToAlreadyExistedKey(Map<String, String[]> params, String key, String value) {
		String[] stockValues = params.get(key);
		String[] addedValues = new String[stockValues.length + 1];

		for (int i = 0; i < stockValues.length; i++) 
			addedValues[i] = stockValues[i];

		addedValues[addedValues.length - 1] = value;
		params.put(key, addedValues);
	}

}
