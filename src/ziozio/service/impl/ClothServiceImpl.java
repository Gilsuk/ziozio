package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.service.face.ClothService;

public class ClothServiceImpl implements ClothService{

	@Override
	public List<Cloth> getClothesByWeather(String weather, String category, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByStyle(String style, String category, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByGender(char gender, String category, Paging paging) {
		return null;
	}

	@Override
	public List<Cloth> getClothesByAccountLibrary(Account account, String category, Paging paging) {
		return null;
	}

	@Override
	public List<List<Cloth>> getClothSetsByAccountLike(Account account, Paging paging) {
		return null;
	}

	@Override
	public Paging getPagingByAccount(HttpServletRequest req, Account account) {
		return null;
	}

}
