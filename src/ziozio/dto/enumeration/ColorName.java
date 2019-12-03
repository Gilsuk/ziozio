package ziozio.dto.enumeration;

public enum ColorName {
	
	RED("빨강");
	
	private final String name;
	
	private ColorName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
