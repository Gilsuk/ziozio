package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.ClothSet;
import ziozio.dto.ClothWithColor;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothSetLikeService {
	
	void like(Account account, ClothSet set);
	
	void unlike(Account account, ClothSet set);
	
	List<ClothSet> getLikedList(Account account);
	
	int getLikeCount(ClothSet set);

	ClothSet dressUp(ClothWithColor cloth, ClothCategory category);

	ClothSet dressUp(ClothWithColor cloth);
	
}
