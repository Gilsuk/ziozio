package ziozio.utils.db.sql;

public class QueryBuilderTest {

	public static void main(String[] args) {

		
		String query = "? SELECT (?, ?, ?) FROM board";
		query += " WHERE boardno = ?";
		query += " AND title = ?";
		QueryBuilder qb = new QueryBuilder(query);
		
		String[] arr = qb.build();
		System.out.println(arr.length);
		
		for (String string : arr) {
			System.out.println(string);
		}

	}

}
