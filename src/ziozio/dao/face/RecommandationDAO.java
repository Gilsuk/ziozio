package ziozio.dao.face;

import java.util.List;

import ziozio.dto.Cloth;
import ziozio.dto.Recmd;

public interface RecommandationDAO {

	List<Cloth> select(Recmd recmd);

	List<Cloth> selectByAccount(Recmd recmd);

}
