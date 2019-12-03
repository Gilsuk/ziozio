package ziozio.dao.impl;

import ziozio.dao.face.LocationDAO;
import ziozio.dto.Location;

public class LocationDAOImpl implements LocationDAO {

	/*
	 * Singleton
	 */
    private LocationDAOImpl() { }
    private static class Factory {
        public static final LocationDAO INSTANCE = new LocationDAOImpl();
    }
    public static LocationDAO getInstance() { return Factory.INSTANCE; }

    /*
     * implements
     */
	@Override
	public Location select(String localname) {
		return null;
	}
}
