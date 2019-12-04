package ziozio.service.impl;

import java.util.List;
import java.util.stream.Stream;

import ziozio.dao.face.ColorDAO;
import ziozio.dao.impl.ColorDAOImpl;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.dto.WithColor;
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
		color.setColor_invert(cloth.getColor_invert());
		color.setColor_name(cloth.getColor_name());
		
		return color;
	}

	@Override
	public Color getColorByName(Color color) {
		return
		colorStream.filter(x -> x.getColor_name().equals(color.getColor_name()))
		.findFirst().orElse(getRandomColor());
	}

	@Override
	public <T extends WithColor> T setColor(T t, Color color) {

		t.setColor_brightness(color.getColor_brightness());
		t.setColor_code(color.getColor_code());
		t.setColor_hue_rotate(color.getColor_hue_rotate());
		t.setColor_invert(color.getColor_invert());
		t.setColor_name(color.getColor_name());
		t.setColor_saturate(color.getColor_saturate());
		
		return t;
	}

}
