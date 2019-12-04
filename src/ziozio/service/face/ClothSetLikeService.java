package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.ClothSet;

public interface ClothSetLikeService {
	
	void like(Account account, ClothSet set);
	
	void unlike(Account account, ClothSet set);
	
	List<ClothSet> getLikedList(Account account);
	
	int getLikeCount(ClothSet set);

}
