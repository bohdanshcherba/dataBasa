package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.Car;
import ua.lviv.iot.service.implementation.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarController implements AbstractController<Car> {

    CarService service = new CarService();

    @Override
    public List<Car> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Car entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Car entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
