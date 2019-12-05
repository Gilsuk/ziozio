package ziozio.dto.enumeration;

public enum Weather {
	
	SUNNY("맑음", 1), CLOUDY("흐림", 2), RAIN("비", 3), SNOW("눈", 4);
	
	private final String name;
	private final int dbvalue;
	
	private Weather(String name, int dbvalue) {
		this.name = name;
		this.dbvalue = dbvalue;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public int dbValue() {
		return dbvalue;
	}

}
