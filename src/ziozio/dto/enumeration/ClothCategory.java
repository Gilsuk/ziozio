package ziozio.dto.enumeration;

public enum ClothCategory {
	
	TOP("top", "상의"), BOTTOM("bottom", "하의"), OUTER("outer", "외투")
	, UMBRELLA("umbrella", "우산"), MASK("mask", "마스크");

	private final String paramvalue;
	private final String dbvalue;

	ClothCategory(String paramvalue, String dbvalue) {;
		this.paramvalue = paramvalue;
		this.dbvalue = dbvalue;
	}
	
	@Override
	public String toString() {
		return this.paramvalue;
	}

	public String getDbValue() {
		return this.dbvalue;
	}
}
