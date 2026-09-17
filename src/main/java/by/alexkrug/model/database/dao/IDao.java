package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T, I> {
    T add(T o) throws SQLException;

    T get(I id) throws SQLException, ResultSetEmptyException;

    boolean delete(I id) throws SQLException;

    boolean update(T id) throws SQLException;

    List<T> getAll() throws SQLException;

}
