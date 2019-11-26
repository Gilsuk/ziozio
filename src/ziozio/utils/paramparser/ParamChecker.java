package ziozio.utils.paramparser;

public interface ParamChecker<T> {
	T check() throws InvalidEmailParamException;
}
