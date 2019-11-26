package ziozio.utils.param;

import ziozio.utils.param.exception.InvalidParamException;

public class ParamCaster {
	
	/*
	 * 값이 올바르지 않거나 null 이면 InvalidParamException을 던진다.
	 */
	public static int toInt(String parameter) throws InvalidParamException {
		try { return Integer.parseInt(parameter);
		}catch (NumberFormatException | NullPointerException e) { throw new InvalidParamException(); }
	}

	/*
	 * 값이 올바르지 않으면 InvalidParamException을 던진다.
	 * 값이 null 이면 elseValue를 리턴한다.
	 */
	public static int toIntOrElse(String parameter, int elseValue) throws InvalidParamException {
		try { return Integer.parseInt(parameter);
		} catch (NumberFormatException e) { throw new InvalidParamException();
		} catch (NullPointerException e) { return elseValue; }
	}

	/*
	 * 값이 올바르지 않거나 null 이면 InvalidParamException을 던진다.
	 */
	public static double toDouble(String parameter) throws InvalidParamException {
		try { return Double.parseDouble(parameter);
		}catch (NumberFormatException | NullPointerException e) { throw new InvalidParamException(); }
	}

	/*
	 * 값이 올바르지 않으면 InvalidParamException을 던진다.
	 * 값이 null 이면 elseValue를 리턴한다.
	 */
	public static double toDoubleOrElse(String parameter, double elseValue) throws InvalidParamException {
		try { return Double.parseDouble(parameter);
		} catch (NumberFormatException e) { throw new InvalidParamException();
		} catch (NullPointerException e) { return elseValue; }
	}

	/*
	 * 값이 올바르지 않거나 null 이면 InvalidParamException을 던진다.
	 */
	public static char toChar(String parameter) throws InvalidParamException {
		
		try {
			char[] chars = parameter.toCharArray();
			if (chars.length == 1) return chars[0];
			else throw new InvalidParamException();
		} catch (NullPointerException e) { throw new InvalidParamException(); }
		
	}

	/*
	 * 값이 올바르지 않으면 InvalidParamException을 던진다.
	 * 값이 null 이면 elseValue를 리턴한다.
	 */
	public static char toCharOrElse(String parameter, char elseValue) throws InvalidParamException {
		
		try {
			char[] chars = parameter.toCharArray();
			if (chars.length == 1) return chars[0];
			else throw new InvalidParamException();
		} catch (NullPointerException e) { return elseValue; }
		
	}
	
	/*
	 * 값이 null이거나 'true'(대소문자 구분 안함)가 아니면 false
	 */
	public static boolean toBoolean(String param) {
		return Boolean.parseBoolean(param);
	}

}
