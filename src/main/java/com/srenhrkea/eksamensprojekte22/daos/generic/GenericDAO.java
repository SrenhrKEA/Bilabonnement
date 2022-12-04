package com.srenhrkea.eksamensprojekte22.daos.generic;

import java.util.Collection;
import java.util.Optional;

public interface GenericDAO<T, ID> {

  Optional<T> get(ID id);

  Collection<T> getAll();

  boolean save(T t);

  boolean update(T t);

  boolean delete(ID id);
}
