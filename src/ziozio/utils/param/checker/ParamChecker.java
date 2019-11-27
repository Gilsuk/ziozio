package ziozio.utils.param.checker;

import ziozio.utils.param.exception.InvalidParamException;

public interface ParamChecker<T> {
	T check() throws InvalidParamException;
}
