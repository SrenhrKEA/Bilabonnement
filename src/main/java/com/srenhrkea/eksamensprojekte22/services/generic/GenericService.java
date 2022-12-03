package com.srenhrkea.eksamensprojekte22.services.generic;

import java.util.Collection;
import java.util.Optional;

public interface GenericService<T, ID> {

  Optional<T> get(ID id);

  Collection<T> getAll();

  boolean save(T t);

  boolean update(T t);

  boolean delete(T t);
}
