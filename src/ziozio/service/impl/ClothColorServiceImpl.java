package ziozio.service.impl;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.service.face.ClothColorService;

public class ClothColorServiceImpl implements ClothColorService<Cloth> {

	@Override
	public ClothWithColor setRandomColor(Cloth cloth) {
		return null;
	}

	@Override
	public ClothWithColor setRandomColor(List<Cloth> clothes) {
		return null;
	}

	@Override
	public ClothWithColor setColor(Cloth cloth, Color color) {
		
		ClothWithColor coloredCloth = new ClothWithColor();

		coloredCloth.setColor_brightness(color.getColor_brightness());
		coloredCloth.setColor_code(color.getColor_code());
		coloredCloth.setColor_hue_rotate(color.getColor_hue_rotate());
		coloredCloth.setColor_invert(color.getColor_invert());
		coloredCloth.setColor_name(color.getColor_name());
		coloredCloth.setColor_saturate(color.getColor_saturate());
		
		return coloredCloth;
	}
}
