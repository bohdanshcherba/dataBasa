package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController<E> {
    List<E> findAll() throws SQLException;


    default void create(E entity) throws SQLException {
    }

    default void update(Integer id, E entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

}
