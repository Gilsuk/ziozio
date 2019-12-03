package ziozio.service.impl;

import java.util.List;
import java.util.stream.Stream;

import ziozio.dao.face.ColorDAO;
import ziozio.dao.impl.ColorDAOImpl;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.service.face.ColorService;

public class ColorServiceImpl implements ColorService {
	
	/*
	 * fields
	 */
	private ColorDAO dao;
	private Stream<Color> colorStream;
	
	/*
	 * Singleton
	 */
	private ColorServiceImpl() {
		this.dao = ColorDAOImpl.getInstance();
		this.colorStream = getColorStream();
	}
	private static class Factory {
        public static final ColorService INSTANCE = new ColorServiceImpl();
    }
    public static ColorService getInstance() { return Factory.INSTANCE; }
    
    private Stream<Color> getColorStream() {
    	List<Color> list = dao.selectAll();
		return list.stream();
	}

    /*
     * implements
     */
	@Override
	public Color getRandomColor() {
		return colorStream.findAny().get();
	}

	@Override
	public Color extractColorFromClothWithColor(ClothWithColor cloth) {
		Color color = new Color();
		
		color.setColor_brightness(cloth.getColor_brightness());
		color.setColor_code(cloth.getColor_code());
		color.setColor_hue_rotate(cloth.getColor_hue_rotate());
		color.setColor_saturate(cloth.getColor_saturate());
		color.setColot_invert(cloth.getColor_invert());
		color.setColot_name(cloth.getColor_name());
		
		return null;
	}

}
