package ziozio.service.impl;

import java.util.List;
import java.util.stream.Stream;

import ziozio.dao.face.ColorDAO;
import ziozio.dao.impl.ColorDAOImpl;
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
	public List<Color> getRandomColorList(int count) {
		return null;
	}

}
