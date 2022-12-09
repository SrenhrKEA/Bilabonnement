package com.srenhrkea.eksamensprojekte22.daos.generic;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface GenericDAO<T, ID> {

  Optional<T> get(ID id) throws SQLException;

  Collection<T> getAll()  throws SQLException;

  boolean save(T t)  throws SQLException;

  boolean update(T t)  throws SQLException;

  boolean delete(ID id)  throws SQLException;
}
