package ua.lviv.iot.service.implementation;

import ua.lviv.iot.dao.implementation.FineDAO;
import ua.lviv.iot.model.Fine;
import ua.lviv.iot.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class FineService implements AbstractService<Fine> {

    private final FineDAO dao = new FineDAO();

    @Override
    public List<Fine> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public void create(Fine entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Fine entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
