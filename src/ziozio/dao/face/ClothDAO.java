package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Account;
import ziozio.dto.Cloth;
import ziozio.dto.ClothWithColor;
import ziozio.dto.Paging;
import ziozio.dto.Style;
import ziozio.dto.enumeration.ClothCategory;

public interface ClothDAO {


	public List<ClothWithColor> selectAll(Account account);
	
	public List<ClothWithColor> selectAll(Account account, ClothCategory category);
	
	public List<ClothWithColor> selectAll(Account account, ClothCategory category, Paging paging);


	
}
