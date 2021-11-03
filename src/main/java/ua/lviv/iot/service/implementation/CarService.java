package ua.lviv.iot.service.implementation;

import ua.lviv.iot.dao.implementation.CarDAO;
import ua.lviv.iot.model.Car;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CarService implements AbstractService<Car> {
    private final CarDAO dao = new CarDAO();

    @Override
    public List<Car> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public void create(Car entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Car entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
