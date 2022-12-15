package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.KilometragePlanRef;

import java.sql.SQLException;
import java.util.List;

public interface KilometragePlanRefService {

  KilometragePlanRef getKilometragePlanRefById(int id) throws Exception;

  List<KilometragePlanRef> getAllKilometragePlanRefs() throws SQLException;

  boolean saveKilometragePlanRef(KilometragePlanRef kilometragePlanRef) throws SQLException;

  boolean updateKilometragePlanRef(KilometragePlanRef kilometragePlanRef) throws SQLException;

  boolean deleteKilometragePlanRefById(int id) throws SQLException;

}
