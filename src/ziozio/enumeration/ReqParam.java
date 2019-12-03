package ziozio.enumeration;

public enum ReqParam {
	
	LOCALNAME("localname"), LATITUDE("lat"), LONGITUDE("lon");
	
	private final String name;

	private ReqParam(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
