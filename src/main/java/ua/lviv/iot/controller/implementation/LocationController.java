package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.service.implementation.LocationService;

import java.sql.SQLException;
import java.util.List;

public class LocationController implements AbstractController<Location> {
    LocationService service = new LocationService();

    @Override
    public List<Location> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Location entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Location entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
