package ziozio.utils.param.checker;

import ziozio.utils.param.exception.InvalidGenderParamException;

public class GenderParamChecker implements ParamChecker<Character> {
	
	private char gender;
	
	public GenderParamChecker(char nick) {
		this.gender = Character.toUpperCase(nick);
	}

	@Override
	public Character check() throws InvalidGenderParamException {
		
		if (gender == 'F' || gender == 'M' || gender == 'N') return gender;
		throw new InvalidGenderParamException();
	}

}
