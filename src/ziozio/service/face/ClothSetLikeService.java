package ziozio.service.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.ClothSet;

public interface ClothSetLikeService {
	
	//insert
	void like(Account account, ClothSet set);
	
	//delete
	void unlike(Account account, ClothSet set);
	
	//select
	List<ClothSet> getLikedList(Account account);
	
	//select
	int getLikeCount(ClothSet set);

}
