package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User, String> {

  boolean update(User user, String idNew);

  Optional<User>  get(String id, String pw);
}
