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
	private List<Color> colorList;
	
	/*
	 * Singleton
	 */
	private ColorServiceImpl() {
		this.dao = ColorDAOImpl.getInstance();
		this.colorList = getColorList();
	}
	private static class Factory {
        public static final ColorService INSTANCE = new ColorServiceImpl();
    }
    public static ColorService getInstance() { return Factory.INSTANCE; }
    
    private List<Color> getColorList() {
    	return dao.selectAll();
    }

    private Stream<Color> getColorStream() {
		return colorList.stream();
	}

    /*
     * implements
     */
	@Override
	public Color getRandomColor() {
		return getColorStream().findAny().get();
	}

	@Override
	public Color extractColorFromClothWithColor(ClothWithColor cloth) {
		Color color = new Color();
		
		color.setColor_brightness(cloth.getColor_brightness());
		color.setColor_code(cloth.getColor_code());
		color.setColor_hue_rotate(cloth.getColor_hue_rotate());
		color.setColor_saturate(cloth.getColor_saturate());
		color.setColor_invert(cloth.getColor_invert());
		color.setColor_name(cloth.getColor_name());
		
		return color;
	}

	@Override
	public Color getColorByName(Color color) {
		return
		getColorStream().filter(x -> x.getColor_name().equals(color.getColor_name()))
		.findFirst().orElse(getRandomColor());
	}


}
