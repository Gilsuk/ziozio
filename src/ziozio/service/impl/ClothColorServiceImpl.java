package ziozio.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Color;
import ziozio.service.face.ClothColorService;
import ziozio.service.face.ColorService;

public class ClothColorServiceImpl implements ClothColorService<Cloth> {

	private ColorService colorService = ColorServiceImpl.getInstance();

	@Override
	public ClothWithColor setRandomColor(Cloth cloth) {
		return setColor(cloth, colorService.getRandomColor());
	}

	@Override
	public List<ClothWithColor> setRandomColor(List<Cloth> clothes) {
		return clothes.parallelStream()
				.map(x -> setColor(x, colorService.getRandomColor()))
				.collect(Collectors.toList());
	}

	@Override
	public ClothWithColor setColor(Cloth cloth, Color color) {
		
		ClothWithColor coloredCloth = new ClothWithColor(cloth);
		
		coloredCloth.setColor_brightness(color.getColor_brightness());
		coloredCloth.setColor_code(color.getColor_code());
		coloredCloth.setColor_hue_rotate(color.getColor_hue_rotate());
		coloredCloth.setColor_invert(color.getColor_invert());
		coloredCloth.setColor_name(color.getColor_name());
		coloredCloth.setColor_saturate(color.getColor_saturate());
		
		return coloredCloth;
	}
}
