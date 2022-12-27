package com.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface dao <T>{
    List<T> findAll() throws SQLException;
    T findOne(int id) throws SQLException;
    T save(T o) throws SQLException;
    boolean Delete(T o) throws SQLException;
    T update(T o) throws SQLException;
}
