package ziozio.utils.param.checker;

import java.util.regex.Pattern;

import ziozio.utils.param.exception.InvalidEmailParamException;

public class EmailParamChecker implements ParamChecker<String> {
	
	private String email;
	
	public EmailParamChecker(String email) {
		this.email = email;
	}

	@Override
	public String check() throws InvalidEmailParamException {
		if (Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) return email;
		else throw new InvalidEmailParamException();
	}

}
