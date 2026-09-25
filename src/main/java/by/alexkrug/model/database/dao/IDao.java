package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T, I> {
    T add(T o) throws SQLException;

    T get(I param) throws SQLException, ResultSetEmptyException;

    boolean delete(I param) throws SQLException;

    boolean update(T o) throws SQLException;

    List<T> getAll() throws SQLException;

}
