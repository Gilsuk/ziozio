package ziozio.enumeration;

public enum SessionAttr {
	
	ACCOUNT("account"), LOCATION("location");
	
	private final String name;

	private SessionAttr(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
