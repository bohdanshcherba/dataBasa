package ua.lviv.iot.service;

import java.sql.SQLException;
import java.util.List;

public interface AbstractService<E> {
    List<E> findAll() throws SQLException;

    default void create(E entity) throws SQLException {
    }

    default void update(Integer id, E entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

}
