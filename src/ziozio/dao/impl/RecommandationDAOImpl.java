package ziozio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ziozio.dao.Dao;
import ziozio.dao.face.RecommandationDAO;
import ziozio.dto.Cloth;
import ziozio.dto.Recmd;
import ziozio.dto.Style;

public class RecommandationDAOImpl implements RecommandationDAO {
	
	/*
	 * Singleton
	 */
	private RecommandationDAOImpl() { }
    private static class Factory {
        public static final RecommandationDAO INSTANCE = new RecommandationDAOImpl();
    }
    public static RecommandationDAO getInstance() { return Factory.INSTANCE; }
	@Override
	public List<Cloth> select(Recmd recmd) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cloth C");
		sql.append(" INNER JOIN cloth_temperature_grade CT ON C.cloth_code = CT.cloth_code");
		sql.append(" INNER JOIN cloth_style CS ON C.cloth_code = CS.cloth_code");
		sql.append(" INNER JOIN style S ON CS.style_code = S.style_code");
		sql.append(" INNER JOIN cloth_weather CW ON C.cloth_code = CW.cloth_code");
		sql.append(" INNER JOIN cloth_category CC ON C.cloth_category_code = CC.cloth_category_code");
		sql.append(" INNER JOIN weather W ON CW.weather_code = W.weather_code");
		sql.append(" WHERE W.weather_name = ?");
		sql.append(" AND CT.temperature_grade_code = ?");
		sql.append(" AND CC.cloth_category_name = ?");
		sql.append(" AND S.style_name IN (");
		insertKeywordsIntoSql(sql, recmd.getStyles());
		sql.append(" )");
		sql.append(" ORDER BY DBMS_RANDOM.RANDOM");
		
		return
		Dao.<Recmd, Cloth>selectList(sql.toString(), null, null, (t, u) -> {
			t.setString(1, recmd.getWeather().getWeather_name());
			t.setInt(2, recmd.getWeather().getTemperature_grade_code());
			t.setString(3, recmd.getCategory().getDbValue());
		}, this::getClothByResultSet);
	}
	@Override
	public List<Cloth> selectByAccount(Recmd recmd) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cloth C");
		sql.append(" INNER JOIN cloth_temperature_grade CT ON C.cloth_code = CT.cloth_code");
		sql.append(" INNER JOIN cloth_style CS ON C.cloth_code = CS.cloth_code");
		sql.append(" INNER JOIN style S ON CS.style_code = S.style_code");
		sql.append(" INNER JOIN cloth_weather CW ON C.cloth_code = CW.cloth_code");
		sql.append(" INNER JOIN cloth_category CC ON C.cloth_category_code = CC.cloth_category_code");
		sql.append(" INNER JOIN weather W ON CW.weather_code = W.weather_code");
		sql.append(" WHERE W.weather_name = ?");
		sql.append(" AND CT.temperature_grade_code = ?");
		sql.append(" AND CC.cloth_category_name = ?");
		sql.append(" AND S.style_name IN (");
		insertKeywordsIntoSql(sql, recmd.getStyles());
		sql.append(" )");
		sql.append(" AND C.cloth_gender = ?");
		sql.append(" ORDER BY DBMS_RANDOM.RANDOM");
		
		return
		Dao.<Recmd, Cloth>selectList(sql.toString(), null, null, (t, u) -> {
			t.setString(1, recmd.getWeather().getWeather_name());
			t.setInt(2, recmd.getWeather().getTemperature_grade_code());
			t.setString(3, recmd.getCategory().getDbValue());
			t.setString(4, String.valueOf(recmd.getGender()));
		}, this::getClothByResultSet);
	}
	
	private void insertKeywordsIntoSql(StringBuilder sql, List<Style> selector) {
		for (int i = 0; i < selector.size(); i++)
			if (i == 0) 
				sql.append("'").append(selector.get(0).getStyle_name()).append("'");
			else
				sql.append(",'").append(selector.get(i).getStyle_name()).append("'");
	}

	private Cloth getClothByResultSet(ResultSet rs) {
		Cloth cloth = new Cloth();

		try {
			cloth.setCloth_name(rs.getString("cloth_name"));								
			cloth.setCloth_code(rs.getInt("cloth_code"));								
			cloth.setCloth_link_url(rs.getString("cloth_link_url"));								
			cloth.setCloth_gender(rs.getString("cloth_gender").charAt(0));	
			cloth.setCloth_img(rs.getString("cloth_img"));
		} catch (SQLException e) { e.printStackTrace(); }

		return cloth;
	}
}
