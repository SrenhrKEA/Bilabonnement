package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.CarTypeRef;

import java.util.List;

public interface CarTypeRefService {

  CarTypeRef getCarTypeRefById(int id);

  List<CarTypeRef> getAllCarTypeRefs();

  void saveCarTypeRef(CarTypeRef carTypeRef);

  void updateCarTypeRef(CarTypeRef carTypeRef);

  void deleteCarTypeRefById(int id);

}
