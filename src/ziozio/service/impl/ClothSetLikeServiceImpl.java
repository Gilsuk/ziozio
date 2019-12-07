package ziozio.service.impl;

import java.util.List;

import ziozio.dao.face.ClothSetDAO;
import ziozio.dao.impl.ClothSetDAOImpl;
import ziozio.dto.Account;
import ziozio.dto.ClothSet;
import ziozio.service.face.ClothSetLikeService;

public class ClothSetLikeServiceImpl implements ClothSetLikeService {
	
	/*
	 * Fields
	 */
	private ClothSetDAO clothsetlikeDao = ClothSetDAOImpl.getInstance();

	/*
	 * Singleton
	 */
	private ClothSetLikeServiceImpl() { }
    private static class Factory {
        public static final ClothSetLikeService INSTANCE = new ClothSetLikeServiceImpl();
    }
    public static ClothSetLikeService getInstance() { return Factory.INSTANCE; }

	@Override
	public void like(Account account, ClothSet set) {
		
		clothsetlikeDao.insert(account, set);
		
	}

	@Override
	public void unlike(Account account, ClothSet set) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClothSet> getLikedList(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLikeCount(ClothSet set) {
		// TODO Auto-generated method stub
		return 0;
	}

}
