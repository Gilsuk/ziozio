package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.Paging;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothDAO {

	public List<Cloth> selectAll();
	
	
	
	public List<Cloth> selectAll(Account account, ClothCategory category, Paging paging);
	
}
