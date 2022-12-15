package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDAO extends GenericDAO<User, String> {

  boolean update(User user, String idNew) throws SQLException;

  Optional<User>  get(String id, String pw) throws SQLException;
}
