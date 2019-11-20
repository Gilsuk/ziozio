package ziozio.utils.db.sql;

public class QueryBuilder {
	/*
	 * fileds
	 */
	private String[] query;
	private String[] inputs;
	/*
	 * constructor
	 */
	public QueryBuilder(String query) {
		this.query = query.split("\\?");
		this.inputs = new String[this.query.length];
	}
	/*
	 * method
	 */
	public void setInt(int index, int input) {
		this.inputs[index - 1] = String.valueOf(input);
	}
	
	public void setLong(int index, long input) {
		this.inputs[index - 1] = String.valueOf(input);
	}

	public void setFloat(int index, float input) {
		this.inputs[index - 1] = String.valueOf(input);
	}

	public void setDouble(int index, double input) {
		this.inputs[index - 1] = String.valueOf(input);
	}
	
	public void setChar(int index, char input) {
		this.inputs[index - 1] = buildStringTypeQuery(input);
	}
	private <T extends String> String buildStringTypeQuery(T input) {
		StringBuilder sb = new StringBuilder();
		sb.append('\'').append(input).append('\'');
		return sb.toString();
	}

	public void setString(int index, String input) {
		this.inputs[index - 1] = input;
	}

//	public void setDate(int index, float input) {
//		this.inputs[index - 1] = String.valueOf(input);
//	}

	public String[] build() {
		return query;
	}

	public String buildQuery() {
		StringBuilder sb = new StringBuilder();
		for (String partedQuery : query) {
			
		}
		return null;
	}
}
