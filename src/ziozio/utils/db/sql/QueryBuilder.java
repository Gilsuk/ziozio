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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < inputs.length; i++) 
			if (inputs[i] == null) throw new QueryNotCompletedException();

		for (int i = 0; i < query.length; i++)
			sb.append(query[i]).append(inputs[i]);

		return sb.toString();
	}
	public <T extends Number> void setNumber(int index, T input) {
		inputs[index - 1] = String.valueOf(input);
	}
	public void setString(int index, String input) {
		inputs[index - 1] = new StringBuilder("'")
				.append(input).append('\'').toString();
	}
//	public void setDate(int index, float input) {
//		this.inputs[index - 1] = String.valueOf(input);
//	}
	public void setNull(int index) {
		inputs[index - 1] = "null";
	}
	public void setAllToNullIfNotSet() {
		for (int i = 0; i < inputs.length; i++) 
			if (inputs[i] == null) inputs[i] = "null";
	}
}