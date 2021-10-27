package ua.lviv.iot.service.implementation;

import ua.lviv.iot.dao.implementation.LocationDAO;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class LocationService implements AbstractService<Location> {

    private final LocationDAO dao = new LocationDAO();

    @Override
    public List<Location> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public void create(Location entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Location entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
