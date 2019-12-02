package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;
import ziozio.service.face.ClothService;

public class GenderClothService implements ClothService<Character, Cloth> {

	@Override
	public List<Cloth> getClothes(Character gender) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(Character gender, ClothCategory category) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(Character gender, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothes(Character gender, ClothCategory category, Paging paging) {
		return null;
	}

	@Override
	public Paging getPaging(Character gender, HttpServletRequest req) {
		return null;
	}

	@Override
	public Paging getPaging(Character gender, ClothCategory category, HttpServletRequest req) {
		return null;
	}

}
