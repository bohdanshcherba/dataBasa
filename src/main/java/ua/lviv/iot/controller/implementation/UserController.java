package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.User;
import ua.lviv.iot.service.implementation.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController implements AbstractController<User> {
    UserService service = new UserService();

    @Override
    public List<User> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(User entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, User entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
