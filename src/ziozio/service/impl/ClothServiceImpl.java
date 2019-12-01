package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.dto.Board;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.service.face.ClothService;

public class ClothServiceImpl implements ClothService{


	@Override
	public List<Cloth> getClothesByWeather(String weather, String category, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cloth> getClothesByTemperatureGrade(int tempGrade, String category, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cloth> getClothesByStyle(String style, String category, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cloth> getClothesByGender(char gender, String category, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cloth> getClothesByAccountLibrary(Account account, String category, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Cloth>> getClothSetsByAccountLike(Account account, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cloth> getClothesByAccountLibrary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board cloth_code(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
