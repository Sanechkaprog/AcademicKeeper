package by.alexkrug.database.dao;

import by.alexkrug.database.exceptions.ResultSetEmptyException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T, I> {
    T add(T o) throws SQLException;

    T get(I id) throws SQLException, ResultSetEmptyException;

    boolean delete(I o) throws SQLException;

    boolean update(T o) throws SQLException;

    List<T> getAll() throws SQLException;
}
