package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.Fine;
import ua.lviv.iot.service.implementation.FineService;

import java.sql.SQLException;
import java.util.List;

public class FineController implements AbstractController<Fine> {
    FineService service = new FineService();

    @Override
    public List<Fine> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Fine entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Fine entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
