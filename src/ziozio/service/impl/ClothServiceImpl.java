package ziozio.service.impl;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.service.face.ClothService;

public class ClothServiceImpl implements ClothService{

	@Override
	public List<Cloth> getClothesByWeather(String weather, String category, int count) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, int count) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByStyle(String style, String category, int count) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByGender(char gender, String category, int count) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByAccountLibrary(Account account, String category, int count) {
		return null;
	}

	@Override
	public List<List<Cloth>> getClothSetsByAccountLike(Account account, int count) {
		return null;
	}

}
