package ziozio.utils.paramparser;

import java.util.regex.Pattern;

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
