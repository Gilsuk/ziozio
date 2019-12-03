package ziozio.dto.enumeration;

public enum StyleCategory {

	CASUAL("casual", "캐쥬얼", 1), BUSINESS("business", "비지니스", 2), DANDY("dandy", "댄디", 3);

	private final String param;
	private final String dbname;
	private final int dbcode;

	StyleCategory(String param, String dbname, int dbcode) {
		this.param= param;
		this.dbname = dbname;
		this.dbcode = dbcode;
	}
	
	@Override
	public String toString() {
		return this.param;
	}

	public String getDbname() {
		return this.dbname;
	}
	
	public int getDbcode() {
		return this.dbcode;
	}
}
