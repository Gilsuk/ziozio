package ziozio.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ziozio.dao.Dao;
import ziozio.dao.face.ColorDAO;
import ziozio.dto.Color;

public class ColorDAOImpl implements ColorDAO {

	/*
	 * fields
	 */
	
	/*
	 * Singleton
	 */
	private ColorDAOImpl() { }
    private static class Factory {
        public static final ColorDAO INSTANCE = new ColorDAOImpl();
    }
    public static ColorDAO getInstance() { return Factory.INSTANCE; }
    
    /*
     * implements
     */
	@Override
	public List<Color> selectAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM color");
		
		return
		Dao.<Color>selectList(sql.toString(), null, null, this::getColorFromResultSet);
	}
	
	private Color getColorFromResultSet(ResultSet rs) {
		Color color = new Color();
		
		try {
			color.setColor_brightness(rs.getInt("color_brightness"));
			color.setColor_code(rs.getInt("color_code"));
			color.setColor_hue_rotate(rs.getInt("color_hue_rotate"));
			color.setColor_saturate(rs.getInt("color_saturate"));
			color.setColot_invert(rs.getInt("color_invert"));
			color.setColot_name(rs.getString("color_name"));
		} catch (SQLException e) { e.printStackTrace(); }

		return color;
	}
}
