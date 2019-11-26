package ziozio.utils.paramparser;

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
